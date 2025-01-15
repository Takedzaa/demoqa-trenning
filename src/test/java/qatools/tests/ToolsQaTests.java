package qatools.tests;

import org.junit.jupiter.api.Test;
import qatools.page.RegistrationPage;
import qatools.page.TextBoxPage;

public class ToolsQaTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void toolsQaRegistrationTest() {

        registrationPage.openPage()
                .fillFirstName("John")
                .fillLastNameInput("Jones")
                .fillUserEmailInput("johnj@gmail.com")
                .fillGenderWrapper("Other")
                .fillUserNumberInput("9953422203")
                .fillDateOfBirthInput("21", "June", "2000")
                .fillSubjectsInputInput("English")
                .fillHobbiesWrapper("Music")
                .fillHobbiesWrapper("Reading")
                .fillHobbiesWrapper("Sports")
                .uploadPicture()
                .fillCurrentAddressInput("5th avenue")
                .clickState()
                .fillStateCityWrapper("NCR")
                .clickCity()
                .fillStateCityWrapper("Noida")
                .clickSubmit()
                .checkResult("Student Name", "John Jones")
                .checkResult("Student Email", "johnj@gmail.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9953422203")
                .checkResult("Date of Birth", "21 June,2000")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Music, Reading, Sports")
                .checkResult("Picture", "ide-just-start-typing.png")
                .checkResult("Address", "5th avenue")
                .checkResult("State and City", "NCR Noida");
    }

    @Test
    void toolsQaRegistrationNotFullDataTest() {

        registrationPage.openPage()
                .fillFirstName("John")
                .fillLastNameInput("Jones")
                .fillGenderWrapper("Other")
                .fillUserNumberInput("9953422203")
                .clickSubmit()
                .checkResult("Student Name", "John Jones")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9953422203");
    }

    @Test
    void toolsQaRegistrationNegativeTest() {

        registrationPage.openPage()
                .fillFirstName("John")
                .fillLastNameInput("Jones")
                .fillUserEmailInput("johnj@gmail.com")
                .fillGenderWrapper("Other")
                .fillDateOfBirthInput("21", "June", "2000")
                .fillSubjectsInputInput("English")
                .fillHobbiesWrapper("Music")
                .fillHobbiesWrapper("Reading")
                .fillHobbiesWrapper("Sports")
                .uploadPicture()
                .clickSubmit()
                .checkResultIsNotVisible();
    }

    @Test
    void textBoxTest() {

        textBoxPage.openPage()
                .fillUserNameInput("John Jones")
                .fillUserEmailInput("johnj@gmail.com")
                .fillCurrentAddress("5th avenue")
                .fillPermanentAddress("10th avenue")
                .clickSubmit()
                .checkResultTextBox("Name", "John Jones")
                .checkResultTextBox("Email", "johnj@gmail.com")
                .checkResultTextBox("Current Address", "5th avenue")
                .checkResultTextBox("Permanent Address", "10th avenue");
    }
}
