package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainContributorTest {

    @Test
    public void andreiSolntsevShouldBeTheMainContributor() {
        //открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        //навести курсор к аватару в области Contributors
        $(".Layout-sidebar").$(withText("Contributors")).closest(".BorderGrid-row").$("ul li").hover();
        //проверить в появившемся окне текст "Andrey Solntsev"
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
