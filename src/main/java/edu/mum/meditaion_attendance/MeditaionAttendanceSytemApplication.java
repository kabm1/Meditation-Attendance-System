package edu.mum.meditaion_attendance;

import edu.mum.meditaion_attendance.formatter.PhoneFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MeditaionAttendanceSytemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeditaionAttendanceSytemApplication.class, args);
    }
    @Configuration
    static class MyConfig implements WebMvcConfigurer {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new PhoneFormatter());
        }
    }
    @Bean
    public static LocalValidatorFactoryBean validatorFactory() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public static MethodValidationPostProcessor validationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}
