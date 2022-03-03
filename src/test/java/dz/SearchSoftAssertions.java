package dz;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchSoftAssertions {

    @Test
    public void shouldHaveExamplesCodeJUnit5InSoftAssertionsPage() {
        //открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        //перейти в раздел "Wiki" проекта
        $("#wiki-tab").click();
        //ввести в поиск SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        //открыть страницу SoftAssertions
        $("#wiki-pages-box").$(withText("SoftAssertions")).click();
        //проверить, что внутри есть пример кода на JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
