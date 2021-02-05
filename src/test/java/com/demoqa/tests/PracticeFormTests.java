package com.demoqa.tests;

import com.demoqa.pages.PracticeForm;
import com.demoqa.pages.ThankYouPage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeFormTests {

    PracticeForm practiceForm = new PracticeForm();
    ThankYouPage thankYouPage = new ThankYouPage();
    String firstName = "test",
            lastName = "test",
            month = "March",
            year = "1990",
            day = "01",
            state = "NCR",
            city = "Delhi",
            subject = "Maths";

    @Test
    void testCanFillPracticeForm() {
        Map<String, String> studentData = createStudentData();

        step("Fill Student Registration Form", () -> {
            practiceForm.openPage()
                    .inputFirstName(firstName)
                    .inputLastName(lastName)
                    .inputEmail(studentData.get("student_email"))
                    .selectGender(studentData.get("gender"))
                    .inputMobileNumber(studentData.get("mobile"))
                    .selectDateOfBirthday(month, year, day)
                    .inputSubject(subject)
                    .checkHobby(studentData.get("hobbies"))
                    .uploadImage("src/test/resources/files/" + studentData.get("picture"))
                    .inputAddress(studentData.get("address"))
                    .selectLocation(state, city)
                    .clickOnCreateStudentButton();
        });

        step("Check Thank You Page", () -> {
            assertEquals(thankYouPage.getPageTitle(), "Thanks for submitting the form");
            Map<String, String> studentDataResult = thankYouPage.getCreatedStudentDataFromThankYouPage();
            assertEquals(studentData, studentDataResult);
        });
    }

    public Map<String, String> createStudentData() {
        return new HashMap<String, String>() {{
            put("student_name", firstName + " " + lastName);
            put("address", "Test address");
            put("gender", "Male");
            put("hobbies", "Sports");
            put("date_of_birth", day + " " + month + "," + year);
            put("subjects", subject);
            put("mobile", "7890000000");
            put("student_email", "test_8089@gmail.com");
            put("state_and_city", state + " " + city);
            put("picture", "image.jpg");
        }};
    }
}
