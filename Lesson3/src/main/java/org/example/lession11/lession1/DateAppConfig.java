package org.example.lession11.lession1;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import java.text.*;
import java.util.*;

@Configuration
@ComponentScan(basePackages = "org.example.lession11.lession1")
public class DateAppConfig {

    @Bean @Profile("ru")
    public Locale ruLocale()   { return new Locale("ru", "RU"); }

    @Bean @Profile("en")
    public Locale enLocale()   { return Locale.US; }

    /** Локаль по умолчанию, если профиль не задан  */
    @Bean
    @Primary
    public Locale defaultLocale() {
        return Locale.getDefault();
    }
    // ============================================

    /** ISO-формат */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SimpleDateFormat isoFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    /** Локальный формат */
    @Bean("localeFormatter")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SimpleDateFormat localeFormatter(Locale locale) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return (SimpleDateFormat) df;
    }
}
