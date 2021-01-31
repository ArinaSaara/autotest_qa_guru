package com.demoqa.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    private final SelenideElement firstNameInput = $("#firstName"),
            secondNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            mobileNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthOfBirthOption = $(".react-datepicker__month-select"),
            yearOfBirthOption = $(".react-datepicker__year-select"),
            subjectInput = $("#subjectsInput"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            createStudentButton = $("#submit");

    public PracticeForm openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public PracticeForm inputLastName(String userLastName) {
        secondNameInput.setValue(userLastName);
        return this;
    }

    public PracticeForm inputFirstName(String userName) {
        firstNameInput.setValue(userName);
        return this;
    }

    public PracticeForm inputEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeForm selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public PracticeForm selectDateOfBirthday(String month, String year, String day) {
        String daySelector = ".react-datepicker__day--0" + day;
        dateOfBirthInput.click();
        monthOfBirthOption.selectOption(month);
        yearOfBirthOption.selectOption(year);
        $(daySelector).click();
        return this;
    }

    public PracticeForm inputMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
        return this;
    }

    public PracticeForm inputSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeForm inputAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public PracticeForm checkHobby(String hobby) {
        $(Selectors.withText(hobby)).click();
        return this;
    }

    public PracticeForm uploadImage(String imagePath) {
        uploadPictureButton.uploadFile(new File(imagePath));
        return this;
    }

    public PracticeForm selectState(String state, String city) {
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public void clickOnCreateStudentButton() {
        createStudentButton.click();
    }
}
