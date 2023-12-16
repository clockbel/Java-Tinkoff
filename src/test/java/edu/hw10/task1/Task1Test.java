package edu.hw10.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {
    @Test
    void test1() throws Exception {
        RandomObjectGenerator ram = new RandomObjectGenerator();
        POJOwithoutAnnotations myClass = ram.nextObject(POJOwithoutAnnotations.class);
        assertNull(myClass.getStringValue());
    }

    @Test
    void test2() throws Exception {
        RandomObjectGenerator ram = new RandomObjectGenerator();
        POJOwithAnnotations myClass = ram.nextObject(POJOwithAnnotations.class);
        assertTrue(myClass.getIntValue() > 10 && myClass.getIntValue() < 1000);
        assertNotNull(myClass.getStringValue());
    }

    @Test
    void test3() throws Exception {
        RandomObjectGenerator ram = new RandomObjectGenerator();
        RecordWithoutAnnotations myClass = ram.nextObject(RecordWithoutAnnotations.class);
        assertNull(myClass.string());
    }

    @Test
    void test4() throws Exception {
        RandomObjectGenerator ram = new RandomObjectGenerator();
        RecordWithAnnotations myClass = ram.nextObject(RecordWithAnnotations.class);
        assertTrue(myClass.value() > 10 && myClass.value() < 1000);
        assertNotNull(myClass.string());
    }

    @Test
    void test5() throws Exception {
        RandomObjectGenerator ram = new RandomObjectGenerator();
        POJOwithAnnotations myClass = ram.nextObject(POJOwithAnnotations.class, "create");
        assertTrue(myClass.getIntValue() > 10 && myClass.getIntValue() < 1000);
        assertNotNull(myClass.getStringValue());
    }

    @Test
    void test6() throws Exception {
        RandomObjectGenerator ram = new RandomObjectGenerator();
        RecordWithAnnotations myClass = ram.nextObject(RecordWithAnnotations.class, "start");
        assertTrue(myClass.value() > 10 && myClass.value() < 1000);
        assertNotNull(myClass.string());
    }
}
