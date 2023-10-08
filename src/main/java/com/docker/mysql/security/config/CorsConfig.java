package com.docker.mysql.security.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {
        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration corsConfig = new CorsConfiguration();
//            corsConfig.setAllowCredentials(true);
            corsConfig.addAllowedOrigin("*");
            corsConfig.addAllowedOrigin("http://localhost:5173");
            corsConfig.setAllowedHeaders(Arrays.asList(
                    HttpHeaders.AUTHORIZATION,
                    HttpHeaders.ACCEPT,
                    HttpHeaders.SET_COOKIE,
                    HttpHeaders.CONTENT_TYPE
            ));
            corsConfig.setAllowedMethods(Arrays.asList(
                    HttpMethod.HEAD.name(),
                    HttpMethod.GET.name(),
                    HttpMethod.POST.name(),
                    HttpMethod.PUT.name(),
                    HttpMethod.PATCH.name(),
                    HttpMethod.DELETE.name(),
                    HttpMethod.OPTIONS.name()
            ));
            corsConfig.setMaxAge(3600L);
            source.registerCorsConfiguration("/**", corsConfig);
            return new CorsFilter();
        }
}
