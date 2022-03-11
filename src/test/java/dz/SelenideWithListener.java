package dz;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWithListener {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $("[data-test-selector=nav-search-input]").setValue("34ka/2").pressEnter();

        $(byLinkText("34ka/2")).click();

        $("#issues-tab").click();
        $("h3").shouldHave(text("Welcome to issues!"));
    }
}
