package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest {

    @Test
    public void assertTrueTest() {
        assertTrue(3 > 1);
    }

    @Test
    public void assertFalseTest() {
        assertFalse(3 < 2);
    }
}