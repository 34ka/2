package dz;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideWithLambdaSteps {

    private static final String REPOSITORY = "34ka/2";

    @Test
    public void testLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репоизторий " + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").setValue(REPOSITORY).pressEnter();
        });
        step("Открываем репозиторий " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });
        step("Переходим в таб Issue", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем что текст", () -> {
            $("h3").shouldHave(text("Welcome to issues!"));
        });
    }
}
