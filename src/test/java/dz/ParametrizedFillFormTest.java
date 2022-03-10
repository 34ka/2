package dz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedFillFormTest {

    @BeforeEach
    public void precondition() {
        open("https://demoqa.com/register");
    }

    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }

    @CsvSource(value = {
            "Василий | Васильев | Dedmoroz | 12345 | Please verify reCaptcha to register!" ,
            "Иван | Иванов |  |  | "
    }, delimiter = '|')
    @ParameterizedTest(name = "Проверка заполнения формы\"{0}\"")
    public void threeInputsTest(String firstName, String lastName, String userName, String password, String expectedText) {
        $("#firstname").setValue(firstName);
        $("#lastname").setValue(lastName);
        $("#userName").setValue(userName);
        $("#password").setValue(password);
        $("#register").click();
        $("#name").$(withText(expectedText));
    }
}
