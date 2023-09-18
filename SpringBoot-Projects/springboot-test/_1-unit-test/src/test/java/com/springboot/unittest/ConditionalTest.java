package com.springboot.unittest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;


public class ConditionalTest {

    @Test
    @Disabled("Dont run until JIRA 123")
    public void basicTest(){
        // nothing to execute
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testForWindows(){

    }

    @Test
    @EnabledOnOs(OS.MAC)
    public void testForMAC(){

    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    public void testForMACAndWindows(){

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    public void testForLinux(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_20)
    public void testForJava20(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    public void testForJava17(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8 , max = JRE.JAVA_21)
    public void testForJava8ToJava21(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SPRING_UNIT_ENV",matches = "DEV")
    public void testOnlyForDevEnvironment(){

    }

    @Test
    @EnabledIfSystemProperty(named = "SPRING_UNIT_SYS_PROP",matches = "DEV")
    public void testOnlyForSystemProperty(){

    }


}
