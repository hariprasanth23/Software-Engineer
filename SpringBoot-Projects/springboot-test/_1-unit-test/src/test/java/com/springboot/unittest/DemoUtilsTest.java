package com.springboot.unittest;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoUtilsTest {
    DemoUtils demoUtils;

    // we need to initialize the demoutils before Each test so
    // we added them in a method and called before each
    @BeforeEach
    public void setupBeforeEach(){
        demoUtils = new DemoUtils();
       // System.out.println("@Before Each executes before every methods");
    }

    @Test
    @DisplayName("Multiply")
    public void testMultiply(){
        assertEquals(12,demoUtils.multiply(3,4),"should be equal to expected");
    }


    @Test
    public void testEqualsAndNotEquals(){
        DemoUtils demoUtils = new DemoUtils();
        assertEquals(6,demoUtils.add(2,4),"2+4 must be 6");
        assertNotEquals(6,demoUtils.add(1,9),"1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not null")
    @Order(0)
    public void testNullAndNotNull(){
        //System.out.println("Running test : testNullAndNotNull");

        String str1 = null;
        String str2 = "hari";

        assertNull(demoUtils.checkNull(str1),"Object should be null");
        assertNotNull(demoUtils.checkNull(str2),"Object should be not null");
    }

    @Test
    @DisplayName("Same and Not Same")
    public void testSameAndNotSame(){
        String str = "luv2Code";
        assertSame(demoUtils.getAcademy(),demoUtils.getAcademyDuplicate(),"Objects should refer to same object");
        assertNotSame(str,demoUtils.getAcademy(),"Objects should refer to same Object");
    }

    @Test
    @DisplayName("True and False")
    public void testTrueOrFalse(){
        assertTrue(demoUtils.isGreater(10,5),"this should return true");
        assertFalse(demoUtils.isGreater(5,10),"this should return false");
    }

    @Test
    @DisplayName("Array Equals")
    public void testArrayEquals(){
        String[] stringArray = {"A","B","C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(),"Array Should be equal");
    }

    @Test
    @DisplayName("Iterable Equals")
    public void testIterableEquals(){
        List<String> theList = List.of("luv","2","code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(),"this list should be equal");
    }

    @Test
    @DisplayName("Lines Match")
    public void testLinesMatch(){
        List<String> theList = List.of("luv","2","code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(),"lines should be match");
    }

    @Test
    @DisplayName(" Throw and Does not Throw")
    public void testThrowAndDoesNotThrow(){
        assertThrows(Exception.class,()-> demoUtils.throwException(-1),"should throw exception");
        assertDoesNotThrow(()->{demoUtils.throwException(9);},"does not throw Exception");
    }

    @Test
    @DisplayName("TimeOut")
    public void testTimeOut(){
        assertTimeoutPreemptively(Duration.ofSeconds(3),()->{demoUtils.checkTimeout();},"method should execute in 3 seconds");
    }


    // before all and after all should be static

   /* @BeforeAll
    public static void setupBeforeAll(){
        System.out.println("@beforeAll will come before beforeEach (executes only once)");
    }

    @AfterAll
    public static void setupAfterAll(){
        System.out.println("@afterAll will come after AfterEach (executes only once)");
    }

     @AfterEach
    public void setupAfterEach(){
        System.out.println("@After Each executes After every methods");
        System.out.println();
    }

    */
}
