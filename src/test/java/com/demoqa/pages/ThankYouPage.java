package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class ThankYouPage {

    private final SelenideElement pageTitle = $(".modal-title"),
            tableInfo = $(".table");

    public String getPageTitle() {
        return pageTitle.shouldBe(Condition.visible).getText();
    }

    public Map<String, String> getCreatedStudentDataFromThankYouPage() {
        Map<String, String> dataResult = new HashMap<>();
        int rowSize = tableInfo.findAll("tbody > tr").size();
        for (int i = 1; i <= rowSize; i++) {
            dataResult.put(
                    $("tbody > tr:nth-child(" + i + ") > td:nth-child(1)")
                            .getText()
                            .toLowerCase()
                            .replace(" ", "_"),
                    $("tbody > tr:nth-child(" + i + ") > td:nth-child(2)")
                            .getText());
        }
        return dataResult;
    }
}
