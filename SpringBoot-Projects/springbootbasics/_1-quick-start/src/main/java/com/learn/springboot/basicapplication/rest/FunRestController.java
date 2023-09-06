package com.learn.springboot.basicapplication.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "10 exercise";
    }

    @Value("${topic.name}")
    private String topicName;
    @Value("${dev.name}")
    private String developerName;

    @GetMapping("/topicInfo")
    public String getTopicInfo(){
        return "Topic Name : "+ topicName + "| Developer Name : "+ developerName;
    }
}
