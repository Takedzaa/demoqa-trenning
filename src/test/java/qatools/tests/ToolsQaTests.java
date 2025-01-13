package qatools.tests;

import org.junit.jupiter.api.Test;
import qatools.page.RegistrationPage;

public class ToolsQaTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

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
}
