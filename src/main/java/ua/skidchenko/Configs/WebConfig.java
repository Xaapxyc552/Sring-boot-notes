package ua.skidchenko.Configs;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Log4j2
@Configuration
@EnableWebMvc
@ComponentScan("ua.skidchenko")

public class WebConfig implements WebMvcConfigurer {
//
//    @Bean
//    public FreeMarkerViewResolver freemarkerViewResolver () {
//        log.info("Initializing Freemarker ViewResolver.");
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(true);
//        resolver.setPrefix("");
//        resolver.setSuffix(".ftl");
//        resolver.setContentType("text/html; charset=UTF-8");
//        log.info("Freemarker ViewResolver Initializing successful.");
//        return resolver;
//    }
//
//    @Bean
//    public FreeMarkerConfigurer freemarkerConfig() {
//        log.info("Initializing Freemarker Configurer.");
//
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("/WEB-INF/templates/");
//        configurer.setDefaultEncoding("UTF-8");
//        log.info("Freemarker Configurer Initializing successful.");
//        return configurer;
//    }
//
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
}
