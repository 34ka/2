package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    @Test
    public void assertTrueTest() {
        assertTrue(3 > 1);
    }

    @Test
    public void assertFalseTest() {
        assertFalse(3 < 2);
    }

    @Test
    public void assertFailAnotherTest() {
        fail("another fail!");
        System.out.println(3);
    }
}