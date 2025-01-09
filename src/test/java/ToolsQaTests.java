import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ToolsQaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void toolsQa() {
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
    }
}
