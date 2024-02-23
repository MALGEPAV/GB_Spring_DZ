package malgepav.dz6basic.configs;

import malgepav.dz6basic.aspects.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
