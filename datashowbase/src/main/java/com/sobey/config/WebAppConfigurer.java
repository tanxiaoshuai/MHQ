package com.sobey.config;

import com.sobey.exception.URLInterceptor;
import com.sobey.util.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by TS on 2017/8/16.
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/gis")
                .addResourceLocations("classpath:/nbtv")
                .addResourceLocations("classpath:/reception")
                .addResourceLocations("classpath:/admin")
                .addResourceLocations("classpath:/starmaps")
                .addResourceLocations("classpath:/dp");
        super.addResourceHandlers(registry);
    }

    /**
     * 解决跨域
     * @return
     */
    @Bean
    public FilterRegistrationBean corsFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(corsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }

    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter();
    }
}

