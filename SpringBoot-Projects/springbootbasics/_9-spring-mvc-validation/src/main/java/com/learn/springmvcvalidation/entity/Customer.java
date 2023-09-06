package com.learn.springmvcvalidation.entity;

import com.learn.springmvcvalidation.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private String firstName;
    @NotNull(message = "is Required")
    @Size(min=1,message = "is required")
    private String lastName ;
    @NotNull(message = "is Required")
    @Min(value=0,message="must be greater than or equal to zero")
    @Max(value=10,message = "must be less than or equal to 10")
    private Integer freePasses;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Only 5 chars or digits")
    private String postalCode;
    //@CourseCode(value="hari",message="")
    // if you need to start with other words directly change in this class
    @CourseCode
    private String courseCode;

}
