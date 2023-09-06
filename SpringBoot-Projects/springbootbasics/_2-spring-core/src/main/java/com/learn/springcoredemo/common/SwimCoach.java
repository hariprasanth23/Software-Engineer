package com.learn.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("Swim Coach");
    }
    @Override
    public String getDailyWorkout() {
        return "SwimCoach Class";
    }
}
