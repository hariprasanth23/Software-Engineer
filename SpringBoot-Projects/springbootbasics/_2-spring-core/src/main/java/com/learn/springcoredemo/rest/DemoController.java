package com.learn.springcoredemo.rest;

import com.learn.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    // below part is constructor injection
    // spring instructs to use constructor injection always
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
        myCoach = theCoach;
    }
    // when we have many implementation for Coach the bean gets confused which one to inject so we will use @Qualifier
    // alternative is we can use @primary annotation , when we use both Qualifier has priority


    // below part is setter injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach = theCoach;
//    }

    // anyone injection should be present , should not have both the injection then it will cause issue

    // using @ primary Annotations
//       @Autowired
//       public DemoController(Coach theCoach){
//           myCoach = theCoach;
//       }
    // check cricketcoach class we have already used @primary annotations so that we can use without any qualifier


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
