package org.example.lession11.lession2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TimedBeanPostProcessor implements BeanPostProcessor {

    private final MetricStorage storage;
    private final Set<Class<?>> processed = ConcurrentHashMap.newKeySet();

    public TimedBeanPostProcessor(MetricStorage storage) {
        this.storage = storage;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        Class<?> targetClass = bean.getClass();
        boolean classTimed = targetClass.isAnnotationPresent(Timed.class);
        boolean hasTimedMethods = Arrays.stream(targetClass.getMethods())
                .anyMatch(m -> m.isAnnotationPresent(Timed.class));

        if (!classTimed && !hasTimedMethods || processed.contains(targetClass)) {
            return bean;
        }
        processed.add(targetClass);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            boolean measure = classTimed || method.isAnnotationPresent(Timed.class);
            if (!measure) return proxy.invoke(bean, args);

            long start = System.currentTimeMillis();
            try {
                return proxy.invoke(bean, args);
            } finally {
                long duration = System.currentTimeMillis() - start;
                String id = targetClass.getSimpleName() + "#" + method.getName();
                storage.add(id, new MetricEntry(LocalDateTime.now(), duration));
            }
        });
        return enhancer.create();
    }
}


