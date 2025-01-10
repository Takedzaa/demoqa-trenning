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

        $("#firstName").setValue("John");
        $("#lastName").setValue("Jones");
        $("#userEmail").setValue("johnj@gmail.com");
        $("#gender-radio-3").parent().click();
        $("#userNumber").setValue("9953422203");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__month").find(byText("21")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src\\test\\resources\\ide-just-start-typing.png"));
        $("#currentAddress").setValue("5th avenue");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $$(".table-responsive").filterBy(text("Student Name")).first().shouldHave(text("John Jones"));
        $$(".table-responsive").filterBy(text("Student Email")).first().shouldHave(text("johnj@gmail.com"));
        $$(".table-responsive").filterBy(text("Gender")).first().shouldHave(text("Other"));
        $$(".table-responsive").filterBy(text("Mobile")).first().shouldHave(text("9953422203"));
        $$(".table-responsive").filterBy(text("Date of Birth")).first().shouldHave(text("21 June,2000"));
        $$(".table-responsive").filterBy(text("Subjects")).first().shouldHave(text("English"));
        $$(".table-responsive").filterBy(text("Hobbies")).first().shouldHave(text("Music, Reading, Sports"));
        $$(".table-responsive").filterBy(text("Picture")).first().shouldHave(text("ide-just-start-typing.png"));
        $$(".table-responsive").filterBy(text("Address")).first().shouldHave(text("5th avenue"));
        $$(".table-responsive").filterBy(text("State and City")).first().shouldHave(text("NCR Noida"));
    }
}
