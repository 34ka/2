package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Alex";
    String lastName = "Egorov";
    String email = "alex@egorov.com";
    String mobileNumber = "1231231230";
    String gender = "Other";
    String day = "30";
    String month = "July";
    String year = "2008";
    String subject = "Math";
    String hobbies = "Sports";
    String file = "1.jpg";
    String currentAddress = "Some address 1";
    String state = "NCR";
    String city = "Noida";

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void successFillTest() {
        //Открыть страницу в браузере и проверить название формы
        registrationPage.openPage().checkStudentRegistrationForm();

        //Заполнить поля формы
        registrationPage
                .setFirstName(firstName).setLastName(lastName).setEmail(email)
                .setGender(gender).setMobileNumber(mobileNumber).setBirthDate(day, month, year)
                .setSubjects(subject).setHobbies(hobbies).uploadFile(file).setCurrentAddress(currentAddress)
                .setSelectState(state).setSelectCity(city);

        //Проверить название формы и введённые данные
        registrationPage.checkThanksForSubmittingTheForm().checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", email).checkForm("Gender", gender).checkForm("Mobile", mobileNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year).checkForm("Subjects", subject)
                .checkForm("Hobbies", hobbies).checkForm("Picture", file).checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);
    }
}