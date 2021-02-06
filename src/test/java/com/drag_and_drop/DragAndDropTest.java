package com.drag_and_drop;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    public void swapBlocks() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //$("#column-a").dragAndDropTo($("#column-b"));
        actions()
                .clickAndHold($("#column-a"))
                .moveByOffset(0, 100)
                .moveToElement($("#column-b"), 0, 100)
                .release().build().perform();
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
