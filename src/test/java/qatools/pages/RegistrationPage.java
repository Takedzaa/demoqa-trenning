package qatools.pages;

import com.codeborne.selenide.SelenideElement;
import qatools.models.UserData;
import qatools.pages.component.CalendarComponent;

import java.io.File;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInputInput = $("#subjectsInput"),
            currentAddressInput = $("#currentAddress"),
            calendarInput = $("#dateOfBirthInput"),
            genderWrapper = $("#genterWrapper"),
            hobbiesWrapper = $(" #hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#stateCity-wrapper").$("#city"),
            submit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        return this;
    }

    public RegistrationPage fillGenderWrapper(UserData data) {
        genderWrapper.$(byText(data.getGender())).parent().click();

        return this;
    }

    public RegistrationPage clickState() {
        state.click();

        return this;
    }

    public RegistrationPage fillStateCityWrapper(UserData data) {
        stateCityWrapper.$(byText(data.getCityWrapper())).click();

        return this;
    }

    public RegistrationPage fillStateCityWrapperSecond(UserData data) {
        stateCityWrapper.$(byText(data.getCityWrapperSecondData())).click();

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

    public RegistrationPage fillHobbiesWrapper(UserData data) {
        hobbiesWrapper.$(byText(data.getHobbies())).click();

        return this;
    }

    public RegistrationPage fillFirstName(UserData data) {
        firstNameInput.setValue(data.getFirstName());

        return this;
    }

    public RegistrationPage fillLastName(UserData data) {
        lastNameInput.setValue(data.getLastName());

        return this;
    }

    public RegistrationPage fillUserEmail(UserData data) {
        userEmailInput.setValue(data.getEmailAddress());

        return this;
    }

    public RegistrationPage fillUserPhoneNumber(UserData data) {
        userNumberInput.setValue(data.getPhoneNumber());

        return this;
    }

    public RegistrationPage fillSubjects(UserData data) {
        subjectsInputInput.setValue(data.getSubjects()).pressEnter();

        return this;
    }

    public RegistrationPage fillCurrentAddress(UserData data) {
        currentAddressInput.setValue(data.getCurrentAddress());

        return this;
    }

    public RegistrationPage fillDateOfBirth(UserData data) {
        calendarInput.click();
        calendarComponent.fillDate(String.format("%02d", data.getBirthday().getDayOfMonth()),
                data.getBirthday().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                String.valueOf(data.getBirthday().getYear()));

        return this;
    }

    public String formateBirthDate(UserData data) {
        String brithDateStr = String.valueOf(data.getBirthday());
        LocalDate date = LocalDate.parse(brithDateStr);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy").withLocale(new Locale("en"));;

        return date.format(formatter);
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
