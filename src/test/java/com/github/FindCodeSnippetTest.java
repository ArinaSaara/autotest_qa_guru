package com.github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindCodeSnippetTest {

    @Test
    public void findJUnit5CodeSnippet() {
        open("https://github.com/selenide/selenide");
        $("h1").shouldHave(text("selenide / selenide"));
        $("[data-content=Wiki]").click();
        $("[data-filterable-for=wiki-pages-filter]").find(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class:"));
    }
}
