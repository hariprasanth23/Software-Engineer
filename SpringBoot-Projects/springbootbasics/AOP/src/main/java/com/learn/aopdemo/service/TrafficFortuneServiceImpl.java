package com.learn.aopdemo.service;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        try{
            Thread.sleep(5);
        }catch (InterruptedException e ){
            throw new RuntimeException(e);
        }
        return "Expect heavy Traffic this Morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Major Accident in the Highway");
        }
        return "Expect heavy Traffic this Morning";
    }
}
