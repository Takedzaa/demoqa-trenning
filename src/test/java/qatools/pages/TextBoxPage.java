package qatools.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import qatools.models.UserData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit"),
            nameOutput = $("#output #name"),
            emailOutput = $("#output #email"),
            currentAddressOutput = $("#output #currentAddress"),
            permanentAddressOutput = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage fillUserNameInput(UserData data) {
        userNameInput.setValue(data.getFirstName() + " " + data.getLastName());

        return this;
    }

    public TextBoxPage fillUserEmailInput(UserData data) {
        userEmailInput.setValue(data.getEmailAddress());

        return this;
    }

    public TextBoxPage fillCurrentAddress(UserData data) {
        currentAddressInput.setValue(data.getCurrentAddress());

        return this;
    }


    public TextBoxPage fillPermanentAddress(UserData data) {
        permanentAddressInput.setValue(data.getPermanentAddress());

        return this;
    }

    public TextBoxPage clickSubmit() {
        submit.click();

        return this;
    }

    public TextBoxPage checkResultTextBox(String name, String email, String currentAddress, String permanentAddress) {
        nameOutput.shouldHave(Condition.text(name));
        emailOutput.shouldHave(Condition.text(email));
        currentAddressOutput.shouldHave(Condition.text(currentAddress));
        permanentAddressOutput.shouldHave(Condition.text(permanentAddress));

        return this;
    }
}
