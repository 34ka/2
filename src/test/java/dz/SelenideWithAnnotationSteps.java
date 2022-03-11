package dz;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWithAnnotationSteps {

    private static final String REPOSITORY = "34ka/2";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("[data-test-selector=nav-search-input]").setValue(repo).pressEnter();
    }

    @Step("Открываем репозиторий {repo}")
    public void openRepository(String repo) {
        $(byLinkText(repo)).click();
    }

    @Step("Переходим в таб Issue")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем текст")
    public void shouldHaveText() {
        $("h3").shouldHave(text("Welcome to issues!"));
    }

    @Test
    public void testAnnotatedSteps() {
        SelenideWithAnnotationSteps steps = new SelenideWithAnnotationSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldHaveText();
    }
}