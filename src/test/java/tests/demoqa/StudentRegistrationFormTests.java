package tests.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Disabled
    @Test
    void successfulFillFormTest() {
        String firstName = "Noob",
                lastName = "Noobasov",
                email = "Noob@ththerth.rgw",
                gender = "Female",
                mobile = "1234567890",
                dayOfBirth = "02",
                monthOfBirth = "June",
                yearOfBirth = "1914",
                subject1 = "History",
                subject2 = "English",
                subject3 = "Arts",
                hobbie1 = "Reading",
                hobbie2 = "Music",
                picture = "1.jpg",
                currentAddress = "Lenina, 57, 101",
                state = "Rajasthan",
                city = "Jaiselmer";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").val(mobile);
        //Заполнить дату
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        //Заполнить предметы
        $("#subjectsInput").val(subject1).pressEnter();
        $("#subjectsInput").val(subject2).pressEnter();
        $("#subjectsInput").val(subject3).pressEnter();
        //Заполнить хобби
        $("#hobbiesWrapper").$(byText(hobbie1)).click();
        $("#hobbiesWrapper").$(byText(hobbie2)).click();
        //Загрузить картинку
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));

        $("#currentAddress").val(currentAddress);
        //set state and city
        $(byText("Select State")).scrollTo().click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();

        $("#submit").click();

        //Проверить содержимое с заполненным
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //$(".table-responsive").shouldHave(text(firstName + " " + lastName),
        //text(email), text (gender));
        //тоже самое, что и сверху
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1 + ", " + subject2 + ", " + subject3));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobbie1 + ", " + hobbie2));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
}