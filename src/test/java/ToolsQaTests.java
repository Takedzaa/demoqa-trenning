import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ToolsQaTests {

    @BeforeAll
    static void beforeAllToolsQaTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void toolsQaRegistrationTest() {
        open("/automation-practice-form");
        $("input#firstName").setValue("John");
        $("input#lastName").setValue("Jones");
        $("input#userEmail").setValue("johnj@gmail.com");
        $("input#gender-radio-3").parent().click();
        $("input#userNumber").setValue("9953422203");
        $("input#dateOfBirthInput").click();
        $(".react-datepicker__year-select").find(byText("2000")).click();
        $(".react-datepicker__month-select").find(byText("June")).click();
        $(".react-datepicker__month").find(byText("21")).click();
        $("input#subjectsInput").setValue("English").pressEnter();
        $("input#hobbies-checkbox-1").parent().click();
        $("input#hobbies-checkbox-2").parent().click();
        $("input#hobbies-checkbox-3").parent().click();
        $("input#uploadPicture").uploadFile(new File("src\\test\\resources\\ide-just-start-typing.png"));
        $("textarea#currentAddress").setValue("5th avenue");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $$(".table-responsive tbody tr").filterBy(text("Student Name")).first().shouldHave(text("John Jones"));
        $$(".table-responsive tbody tr").filterBy(text("Student Email")).first().shouldHave(text("johnj@gmail.com"));
        $$(".table-responsive tbody tr").filterBy(text("Gender")).first().shouldHave(text("Other"));
        $$(".table-responsive tbody tr").filterBy(text("Mobile")).first().shouldHave(text("9953422203"));
        $$(".table-responsive tbody tr").filterBy(text("Date of Birth")).first().shouldHave(text("21 June,2000"));
        $$(".table-responsive tbody tr").filterBy(text("Subjects")).first().shouldHave(text("English"));
        $$(".table-responsive tbody tr").filterBy(text("Hobbies")).first().shouldHave(text("Sports, Reading, Music"));
        $$(".table-responsive tbody tr").filterBy(text("Picture")).first().shouldHave(text("ide-just-start-typing.png"));
        $$(".table-responsive tbody tr").filterBy(text("Address")).first().shouldHave(text("5th avenue"));
        $$(".table-responsive tbody tr").filterBy(text("State and City")).first().shouldHave(text("NCR Noida"));
    }
}
