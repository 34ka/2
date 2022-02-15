package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    //компоненты
    private CalendarComponent calendarComponent = new CalendarComponent();

    //url
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    //локатор поля "First Name"
    SelenideElement firstNameInput = $("#firstName");
    //локатор поля "Last Name"
    SelenideElement lastNameInput = $("#lastName");
    //локатор поля "Email"
    SelenideElement emailInput = $("#userEmail");
    //локатор радиокнопок "Gender"
    SelenideElement genderSelect = $("#genterWrapper");
    //локатор поля "Mobile Number"
    SelenideElement mobileNumberInput = $("#userNumber");
    //локатор поля "Subjects"
    SelenideElement subjectsInput = $("#subjectsInput");
    //локатор поля "Hobbies"
    SelenideElement hobbiesSelect = $("#hobbiesWrapper");
    //локатор поля "Выберите файл"
    SelenideElement choiceFile = $("#uploadPicture");
    //локатор поля "Current Address"
    SelenideElement currentAddressInput = $("#currentAddress");
    //локатор выпадающего списка "Select State"
    SelenideElement dropdownListSelectState = $("#state");
    //локатор элементов из выпадающего списка "Select State"
    SelenideElement elementsDropdownListSelectState = $("#stateCity-wrapper");
    //локатор выпадающего списка "Select City"
    SelenideElement dropdownListSelectCity = $("#city");
    //локатор элементов из выпадающего списка "Select City"
    SelenideElement elementsDropdownListSelectCity = $("#stateCity-wrapper");
    //локатор кнопки "Submit"
    SelenideElement submitButton = $("#submit");


    //локатор названия формы "Student Registration Form"
    SelenideElement studentRegistrationForm = $(".practice-form-wrapper");
    //локатор названия формы "Thanks for submitting the form"
    SelenideElement thanksForSubmittingTheForm = $("#example-modal-sizes-title-lg");
    //локатор всей таблицы "Thanks for submitting the form"
    SelenideElement resultsTable = $(".table-responsive");


    //метод заполнения поля "First Name"
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    //метод заполнения поля "Last Name"
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    //метод заполнения поля "Email"
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    //метод клика на пол "Other"
    public RegistrationPage setGender(String gender) {
        genderSelect.$(byText(gender)).click();
        return this;
    }
    //метод заполнения поля "Mobile Number"
    public RegistrationPage setMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
        return this;
    }
    //метод выбора даты рождения
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").scrollTo().click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    //метод заполнения поля "Subjects"
    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }
    //метод заполнения поля "Hobbies"
    public RegistrationPage setHobbies(String hobbies) {
        hobbiesSelect.$(byText(hobbies)).click();
        return this;
    }
    //метод загрузки файла
    public RegistrationPage uploadFile(String file) {
        choiceFile.uploadFromClasspath(file);
        return this;
    }
    //метод заполнения поля "Current Address"
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }
    //метод нажатия на выпадающий список "Select State" и выбор штата
    public RegistrationPage setSelectState(String state) {
        dropdownListSelectState.click();
        elementsDropdownListSelectState.$(byText(state)).click();
        return this;
    }
    //метод нажатия на выпадающий список "Select City", выбор штата и нажатие на кнопку "Submit"
    public RegistrationPage setSelectCity(String city) {
        dropdownListSelectCity.click();
        elementsDropdownListSelectCity.$(byText(city)).click();
        submitButton.click();
        return this;
    }


    //метод проверки названия формы "Student Registration Form"
    public RegistrationPage checkStudentRegistrationForm() {
        studentRegistrationForm.shouldHave(text("Student Registration Form"));
        return this;
    }
    //метод проверки названия формы "Thanks for submitting the form"
    public RegistrationPage checkThanksForSubmittingTheForm() {
        thanksForSubmittingTheForm.shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    //метод проверки формы заполненных данных
    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}