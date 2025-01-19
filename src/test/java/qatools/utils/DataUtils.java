package qatools.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;

public class DataUtils {

    private static final Faker faker = new Faker();

    public static String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public static String generateRandomLastName() {
        return faker.name().lastName();
    }

    public static String generateRandomUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateRandomFullAddress() {
        return faker.address().fullAddress();
    }

    public static String generateRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static LocalDate generateRandomBirthday(int minAge, int maxAge) {
        var birthDay = faker.date().birthday(minAge, maxAge);

        return LocalDate.ofInstant(birthDay.toInstant(), ZoneId.systemDefault());
    }

    public static String generateRandomGender() {

        return faker.options().option("Male", "Female", "Other");
    }

    public static String generateRandomHobbies() {

        return faker.options().option("Music", "Reading", "Sports");
    }
}