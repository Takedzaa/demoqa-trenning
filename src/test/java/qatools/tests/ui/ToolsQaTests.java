package qatools.tests.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import qatools.helpers.Attach;
import qatools.models.UserData;
import qatools.pages.RegistrationPage;
import qatools.pages.TextBoxPage;

import static io.qameta.allure.Allure.step;

public class ToolsQaTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();
    UserData data = new UserData();

    @Test
    @Tag("regUiTest")
    void toolsQaRegistrationTest() {
        step("Открыть страницу", () -> {
            registrationPage.openPage();
        });
        step("Заполнить блок данных", () -> {
            registrationPage.fillFirstName(data)
                    .fillLastName(data)
                    .fillUserEmail(data)
                    .fillGenderWrapper(data)
                    .fillUserPhoneNumber(data)
                    .fillDateOfBirth(data)
                    .fillSubjects(data)
                    .fillHobbiesWrapper(data)
                    .uploadPicture()
                    .fillCurrentAddress(data)
                    .clickState()
                    .fillStateCityWrapper(data)
                    .clickCity()
                    .fillStateCityWrapperSecond(data);
        });
        step("Нажать кнопку 'Подтвердить'", () -> {
            registrationPage.clickSubmit();
        });
        step("Проверки введенных данных", () -> {
            registrationPage.checkResult("Student Name", data.getFirstName() + " " + data.getLastName())
                    .checkResult("Student Email", data.getEmailAddress())
                    .checkResult("Gender", data.getGender())
                    .checkResult("Mobile", data.getPhoneNumber())
                    .checkResult("Date of Birth", registrationPage.formateBirthDate(data))
                    .checkResult("Subjects", data.getSubjects())
                    .checkResult("Hobbies", data.getHobbies())
                    .checkResult("Picture", "ide-just-start-typing.png")
                    .checkResult("Address", data.getCurrentAddress())
                    .checkResult("State and City", data.getCityWrapper() + " " + data.getCityWrapperSecondData());
        });
        Attach.addVideo();
    }

    @Test
    void toolsQaRegistrationNotFullDataTest() {

        step("Открыть главную страницу", () -> {
            registrationPage.openPage();
        });
        step("Заполнить поля ввода", () -> {
            registrationPage.fillLastName(data)
                    .fillGenderWrapper(data)
                    .fillUserPhoneNumber(data);
        });
        step("Нажать кнопку подтвердить", () -> {
            registrationPage.clickSubmit();
        });
        step("Проверки теста", () -> {
            registrationPage.checkResult("Student Name", data.getFirstName() + " " + data.getLastName())
                    .checkResult("Gender", data.getGender())
                    .checkResult("Mobile", data.getPhoneNumber());
        });

    }


    @Test
    void toolsQaRegistrationNegativeTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .fillFirstName(data)
                .fillLastName(data)
                .fillUserEmail(data)
                .fillGenderWrapper(data)
                .fillDateOfBirth(data)
                .fillSubjects(data)
                .fillHobbiesWrapper(data)
                .uploadPicture()
                .clickSubmit()
                .checkResultIsNotVisible();
    }

    @Test
    void textBoxTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        textBoxPage.openPage()
                .fillUserNameInput(data)
                .fillUserEmailInput(data)
                .fillCurrentAddress(data)
                .fillPermanentAddress(data)
                .clickSubmit()
                .checkResultTextBox(data.getFirstName() + " " + data.getLastName(),
                        data.getEmailAddress(), data.getCurrentAddress(), data.getPermanentAddress());

    }
}
