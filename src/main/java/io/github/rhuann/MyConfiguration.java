package io.github.rhuann;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfiguration {

    @Bean
    public String applicationName(){
        return "Sistema de Vendas";
    }

    @Bean
    public String applicationVersion(){
        return "0.1";
    }

}
