# 1.unit-test

### Simple Add method Testing

    // Method in DemoUtils class
    public int add(int a, int b) {
        return a + b;
    }
    
    // Method in Springboot Test Class
    @Test
    public void testEqualsAndNotEquals(){
        DemoUtils demoUtils = new DemoUtils();
        assertEquals(6,demoUtils.add(2,4),"2+4 must be 6");
        assertNotEquals(6,demoUtils.add(1,9),"1+9 must not be 6");
    }
