package dz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedSumma {
    static Stream<Arguments> TestData() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, 9, 10)
        );
    }

    @MethodSource(value = "TestData")
    @ParameterizedTest(name = "Summa {2}")
    @DisplayName("Проверка суммы аргументов")
    public void argumentsTest(int firstArg, int secondArg, int excepted) {
        int actual = firstArg+secondArg;
        assertEquals(actual, excepted);
    }
}
