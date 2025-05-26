package org.example.lession13.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingConfig {
    @Bean
    CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter f = new CommonsRequestLoggingFilter();
        f.setIncludeQueryString(true);
        f.setIncludePayload(true);
        f.setMaxPayloadLength(10000);
        f.setIncludeHeaders(false);
        return f;
    }
}