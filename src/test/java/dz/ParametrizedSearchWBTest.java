package dz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class ParametrizedSearchWBTest {

    @BeforeEach
    public void precondition() {
        open("https://www.wildberries.ru/");
    }

    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }

    @ValueSource(strings = {"гель для душа женский", "гель для душа мужской"})
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в WB для запроса \"{0}\"")
    @DisplayName("Проверка отображения поисковых результатов в WB")
    public void commonSearchTest(String testData) {
        $("#searchInput").setValue(testData).pressEnter();
        $("span[class='goods-name']").click();
    }
}
