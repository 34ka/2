package dz;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @Test
    public void checkDragAndDrop() {
        //открыть страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        //проверить, что прямоугольники поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
