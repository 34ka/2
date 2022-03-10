package guru.qa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Класс с простыми тестами")
public class SimpleTest {

    @Test
    @DisplayName("Зелёный тест")
    public void simpleGreenTest() {
        assertTrue(3 > 1);
    }

    @Test
    @DisplayName("Красный тест")
    public void simpleRedTest() {
        assertTrue(3 < 1);
    }

    @Test
    @Disabled("bug")
    public void simpleBrokenTest() {
        throw new IllegalStateException("Broken");
    }
}