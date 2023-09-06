package com.learn.springcoredemo.config;

import com.learn.springcoredemo.common.Coach;
import com.learn.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach getSwimCoach(){
        return new SwimCoach();
    }

    // we given bean name like @Bean("hari") --> we should use in the Qualifier as hari
}
