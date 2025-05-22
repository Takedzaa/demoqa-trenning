package qatools.models;

import lombok.Getter;

import java.time.LocalDate;

import static qatools.utils.DataUtils.*;

@Getter
public class UserData {
    private final String firstName = generateRandomFirstName();
    private final String lastName = generateRandomLastName();
    private final String emailAddress = generateRandomUserEmail();
    private final String currentAddress = generateRandomFullAddress();
    private final String permanentAddress = generateRandomFullAddress();
    private final String phoneNumber = generateRandomPhoneNumber();
    private final LocalDate birthday = generateRandomBirthday(20, 80);
    private final String gender = generateRandomGender();
    private final String hobbies = generateRandomHobbies();
    private final String cityWrapper = "NCR";
    private final String cityWrapperSecondData = "Noida";
    private final String subjects = "English";

    private final String jsonBody = String.format("{\n" +
            "    \"name\": \"%s\",\n" +
            "    \"job\": \"leader\"\n" +
            "}", firstName);
}