package com.slin.authority.common;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig extends CorsFilter {
    public CorsConfig() {
        super(configurationSource());
    }

    private static UrlBasedCorsConfigurationSource configurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        List<String> allowedHeaders = Arrays.asList("Access-Control-Allow-Headers", "Content-Type","Authorization", "X-Requested-With","X-auth-Token","XMLHttpRequest","X-Custom-Header");
        List<String> exposedHeaders = Arrays.asList("Access-Control-Allow-Headers", "Content-Type","Authorization", "X-Requested-With","X-auth-Token","XMLHttpRequest","X-Custom-Header");
        List<String> allowedMethods = Arrays.asList("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS");
        List<String> allowedOrigins = Arrays.asList("*");
        corsConfig.setAllowedHeaders(allowedHeaders);
        corsConfig.setAllowedMethods(allowedMethods);
        corsConfig.setAllowedOrigins(allowedOrigins);
        corsConfig.setExposedHeaders(exposedHeaders);
        corsConfig.setMaxAge(36000L);
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }

}
