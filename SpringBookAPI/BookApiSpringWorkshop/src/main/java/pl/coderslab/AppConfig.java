package pl.coderslab;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.channels.WritableByteChannel;

@Configuration
@ComponentScan
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
}
