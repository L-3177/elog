package com.l_3177;

import com.l_3177.converter.StringToListConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@Configuration
public class ElogApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(ElogApplication.class, args);
    }

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addConverter(new StringToListConverter());
    }
}
