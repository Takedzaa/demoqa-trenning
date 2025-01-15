package qatools.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));

        return this;
    }

    public TextBoxPage fillUserNameInput(String userName) {
        userNameInput.setValue(userName);

        return this;
    }

    public TextBoxPage fillUserEmailInput(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public TextBoxPage fillCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }


    public TextBoxPage fillPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);

        return this;
    }

    public TextBoxPage clickSubmit() {
        submit.click();

        return this;
    }

    public TextBoxPage checkResultTextBox(String key, String value) {
        $("#output").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
