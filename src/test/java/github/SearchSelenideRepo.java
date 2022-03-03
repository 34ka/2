package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepo {

    @Test
    public void shouldFindSelenideInGitHub() {
        //открыть страницу github.com
        open("https://github.com");
        //ввести в поле "selenide" и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажать на линк от первого результата поиска
        $$(".repo-list li").first().$("a").click();
        //проверить в заголовке "selenide/selenide"
        $("h1").shouldHave(text("selenide / selenide"));
    }
}
