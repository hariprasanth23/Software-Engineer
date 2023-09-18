package com.springboot.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    // if number is divisible by 3 , print fizz
    // if number is divisible by 5 , print buzz
    // if number is divisible by 3 and 5 , print fizzbuzz
    // if number is not divisible by 3 or 5 , then print number

    @Test
    @DisplayName(" Divisible by 3")
    @Order(1)
    public void testForDivisibleByThree(){
        //fail("fail");
        String expected = "Fizz";
        assertEquals(expected,FizzBuzz.compute(3),"should return Fizz");
    }

    @Test
    @DisplayName(" Divisible by 5")
    @Order(2)
    public void testForDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected,FizzBuzz.compute(5),"should return Buzz");
    }

    @Test
    @DisplayName(" Divisible by 3 and 5")
    @Order(3)
    public void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected,FizzBuzz.compute(15),"should return FizzBuzz");
    }

    @Test
    @DisplayName(" Not Divisible by 3 or 5")
    @Order(4)
    public void testForNotDivisibleByThreeOrFive(){
        String expected = "1";
        assertEquals(expected,FizzBuzz.compute(1),"should return 1");
    }

    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @DisplayName("Testing with small Data file")
    @Order(5)
    public void testSmallDataFile(int value,String expected){
        assertEquals(expected,FizzBuzz.compute(value));
    }

    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @DisplayName("Testing with medium Data file")
    @Order(6)
    public void testMediumDataFile(int value,String expected){
        assertEquals(expected,FizzBuzz.compute(value));
    }

    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @DisplayName("Testing with large Data file")
    @Order(7)
    public void testLargeDataFile(int value,String expected){
        assertEquals(expected,FizzBuzz.compute(value));
    }

}
