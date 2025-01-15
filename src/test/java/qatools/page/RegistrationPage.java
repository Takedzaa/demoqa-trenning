package qatools.page;

import com.codeborne.selenide.SelenideElement;
import qatools.page.component.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInputInput = $("#subjectsInput"),
            currentAddressInput = $("#currentAddress"),
            calendarInput = $("#dateOfBirthInput"),
            genderWrapper = $("#genterWrapper"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage fillGenderWrapper(String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage clickState() {
        state.click();

        return this;
    }

    public RegistrationPage fillStateCityWrapper(String stateCity) {
        stateCityWrapper.$(byText(stateCity)).click();

        return this;
    }

    public RegistrationPage clickCity() {
        city.click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        submit.click();

        return this;
    }

    public RegistrationPage uploadPicture() {
        uploadPicture.uploadFile(new File("src\\test\\resources\\img\\ide-just-start-typing.png"));

        return this;
    }

    public RegistrationPage fillHobbiesWrapper(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage fillFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage fillLastNameInput(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage fillUserEmailInput(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage fillUserNumberInput(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    public RegistrationPage fillSubjectsInputInput(String subjectsInput) {
        subjectsInputInput.setValue(subjectsInput).pressEnter();

        return this;
    }

    public RegistrationPage fillCurrentAddressInput(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public RegistrationPage fillDateOfBirthInput(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.fillDate(day, month, year);

        return this;
    }

    public RegistrationPage checkResultIsNotVisible() {
        $(".modal-title").shouldNot();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
