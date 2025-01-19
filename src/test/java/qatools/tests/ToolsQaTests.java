package qatools.tests;

import org.junit.jupiter.api.Test;
import qatools.models.UserData;
import qatools.pages.RegistrationPage;
import qatools.pages.TextBoxPage;

public class ToolsQaTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();
    UserData data = new UserData();

    @Test
    void toolsQaRegistrationTest() {

        registrationPage.openPage()
                .fillFirstName(data)
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
                .fillStateCityWrapperSecond(data)
                .clickSubmit()
                .checkResult("Student Name", data.getFirstName() + " " + data.getLastName())
                .checkResult("Student Email", data.getEmailAddress())
                .checkResult("Gender", data.getGender())
                .checkResult("Mobile", data.getPhoneNumber())
                .checkResult("Date of Birth", registrationPage.formateBirthDate(data))
                .checkResult("Subjects", data.getSubjects())
                .checkResult("Hobbies", data.getHobbies())
                .checkResult("Picture", "ide-just-start-typing.png")
                .checkResult("Address", data.getCurrentAddress())
                .checkResult("State and City", data.getCityWrapper() + " " + data.getCityWrapperSecondData());
    }

    @Test
    void toolsQaRegistrationNotFullDataTest() {

        registrationPage.openPage()
                .fillFirstName(data)
                .fillLastName(data)
                .fillGenderWrapper(data)
                .fillUserPhoneNumber(data)
                .clickSubmit()
                .checkResult("Student Name", data.getFirstName() + " " + data.getLastName())
                .checkResult("Gender", data.getGender())
                .checkResult("Mobile", data.getPhoneNumber());
    }

    @Test
    void toolsQaRegistrationNegativeTest() {

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
