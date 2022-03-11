package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ListenerTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        //вот здесь beforeEvent
        open("https://github.com");
        //вот здесь afterEvent

        //вот здесь beforeEvent
        $(".header-search-input").click();
        //вот здесь afterEvent

        //вот здесь beforeEvent
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        //вот здесь afterEvent

        $(".header-search-input").submit();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#68")).should(Condition.exist);
    }
}