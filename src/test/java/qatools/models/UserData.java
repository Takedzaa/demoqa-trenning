package qatools.models;

import lombok.Data;

import java.time.LocalDate;

import static qatools.utils.DataUtils.*;

@Data
public class UserData {
    private String firstName = generateRandomFirstName();
    private String lastName = generateRandomLastName();
    private String emailAddress = generateRandomUserEmail();
    private String currentAddress = generateRandomFullAddress();
    private String permanentAddress = generateRandomFullAddress();
    private String phoneNumber = generateRandomPhoneNumber();
    private LocalDate birthday = generateRandomBirthday(20, 80);
    private String gender = generateRandomGender();
    private String hobbies = generateRandomHobbies();
    private String cityWrapper = "NCR";
    private String cityWrapperSecondData = "Noida";
    private String subjects = "English";
}