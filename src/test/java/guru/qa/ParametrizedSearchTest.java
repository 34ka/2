package guru.qa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedSearchTest {

    @BeforeEach
    public void precondition() {
        open("https://ya.ru");
    }

    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }

    @ValueSource(strings = {"Selenide", "JUnit5"})
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в яндексе для запроса \"{0}\"")
    @DisplayName("Проверка отображения поисковых результатов в яндексе для запроса {test_data}")
    public void commonSearchTest(String testData) {
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").find(text(testData)).shouldBe(visible);
    }

    @CsvSource(value = {
            "Selenide| concise UI tests in Java",
            "JUnit 5| IntelliJ IDEA"
    }, delimiter = '|')
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в яндексе для запроса \"{0}\"")
    public void complexSearchTest(String testData, String expectedText) {
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").find(text(expectedText)).shouldBe(visible);
    }

    static Stream<Arguments> mixedArgumentsTestDataProvider() {
        return Stream.of(
                Arguments.of("Selenide", List.of(1,2,4), true),
                Arguments.of("JUnit 5", List.of(5,6,7), false)
        );
    }

    @MethodSource(value = "mixedArgumentsTestDataProvider")
    @ParameterizedTest(name = "Name {2}")
    public void mixedArgumentsTest(String firstArg, List<Integer> secondArg, boolean aBooleanValue) {
        System.out.println("String:" + firstArg + " list: " + secondArg.toString() + " boolean: " + aBooleanValue);
    }

    @CsvSource(value = {
            "Дмитрий| Тучс" ,
            "Иван | Иванов"
    }, delimiter = '|')
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в яндексе для запроса \"{0}\"")
    public void threeInputsTest(String name, String surname) {
        $("#surname").setValue(name);
        $("#name").setValue(surname);
        $("button[type='submit']").click();
    }
}
