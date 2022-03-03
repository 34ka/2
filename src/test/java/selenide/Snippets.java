package selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class Snippets {

    public void browserCommandExamples() {
        //открытие полного url
        open("https://www.google.ru");
        //открытие относительного url
        open("/custom/orders"); // -Dselenide.baseUrl=http://github.com
        //
        open("/", AuthenticationType.BASIC, new BasicAuthCredentials("user", "password"));

        //нопка обновить страницу
        Selenide.refresh();
        //кнопка назад в браузере
        Selenide.back();

        //очистить куки
        Selenide.clearBrowserCookies();
        //очистить локальные данные
        Selenide.clearBrowserLocalStorage();

        //в выпадающим окне нажимает на принять или ок. Пример, окно с куками
        Selenide.confirm();
        //тоже самое, но нажимает на нет или отмену
        Selenide.dismiss();

        //закрыть одно окно
        Selenide.closeWindow();
        //закрыть все окна
        Selenide.closeWebDriver();

        //iframe страница в странице. Селенид не могут искать в iframe не переходя в него. Сначала нужно в него перейти.
        //Переход в страницу
        Selenide.switchTo().frame("name");
        //
        Selenide.switchTo().defaultContent();

        //открыть новое окно, перейти
        Selenide.switchTo().window("name");
    }

    public void selectorsExamples() {
        $("div").click();
        element("div").click();

        $("div", 2).click(); // the third div

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click();
        $(withText("ull tex")).click();

        $("").parent();
        $("").sibling(1);
        $("").preceding(1);
        $("").closest("div");
        $("").ancestor("div"); // the same as closest
        $("div:last-child");

        $("div").$("h1").find(byText("abc")).click();

        // very optional
        $(byAttribute("abc", "x")).click();
        $("[abc=x]").click();

        $(byId("mytext")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();
    }

    public void actions_examples() {
        $("").click();
        $("").doubleClick();
        //клик правой клавишой мыши
        $("").contextClick();

        //навести курсор
        $("").hover();

        //очищает поле полностью и вписывает туда текст
        $("").setValue("text");
        //не очищает, а добавляет к уже написанному текст
        $("").append("text");
        //очищают
        $("").clear();
        $("").setValue(""); // clear

        // hotkey c on element
        $("div").sendKeys("c");
        actions().sendKeys("c").perform(); //hotkey c on whole application
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // Ctrl + F
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();


        // complex actions with keybord and mouse, example
        //perform() - выполняет данную команду, без метода не выполнится цепочка
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        // old html actions don't work with many modern frameworks
        $("").selectOption("dropdown_option");
        $("").selectRadio("radio_options");

    }

    public void assertions_examples() {
        //все одинаковые ассерты для того, чтобы писать правильно на англ. языке
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("abc"));
        $("").shouldNotHave(text("abc"));
        $("").should(appear);
        $("").shouldNot(appear);

        //longer timeouts
        $("").shouldBe(visible, Duration.ofSeconds(30));
    }

    public void conditions_examples() {
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc"));
        $("").shouldHave(exactText("abc"));
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").should(matchText("[0-9]abc$"));

        $("").shouldHave(cssClass("red"));
        $("").shouldHave(cssValue("font-size", "12"));

        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        $("").shouldHave(attribute("disabled"));
        $("").shouldHave(attribute("name", "example"));
        $("").shouldHave(attributeMatching("name", "[0-9]abc$"));

        $("").shouldBe(checked); // for checkboxes

        // Warning! Only checks if it is in DOM, not if it is visible! You don't need it in most tests!
        $("").should(exist);

        // Warning! Checks only the "disabled" attribute! Will not work with many modern frameworks
        $("").shouldBe(disabled);
        $("").shouldBe(enabled);
    }

    public void collections_examples() {

        $$("div"); // does nothing!

        // selections
        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1));

        $$("div").first().click();
        elements("div").first().click();
        // $("div").click();
        $$("div").last().click();
        $$("div").get(1).click(); // the second! (start with 0)
        $("div", 1).click(); // same as previous
        $$("div").findBy(text("123")).click(); //  finds first

        // assertions
        $$("").shouldHave(size(0));
        $$("").shouldBe(CollectionCondition.empty); // the same

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma"));
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma"));

        $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa"));
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa"));

        $$("").shouldHave(itemWithText("Gamma")); // only one text

        $$("").shouldHave(sizeGreaterThan(0));
        $$("").shouldHave(sizeGreaterThanOrEqual(1));
        $$("").shouldHave(sizeLessThan(3));
        $$("").shouldHave(sizeLessThanOrEqual(2));


    }

    void file_operation_examples() throws FileNotFoundException {

        File file1 = $("a.fileLink").download(); // only for <a href=".."> links
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // more common options, but may have problems with Grid/Selenoid

        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt");
        // don't forget to submit!
        $("uploadButton").click();
    }

    public void javascript_examples() {
        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7);

    }
}
