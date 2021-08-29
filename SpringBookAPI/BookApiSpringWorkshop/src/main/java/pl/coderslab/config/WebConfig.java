package pl.coderslab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//Nie wolno powielc adnotacji @ComponentScan i @EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

}
