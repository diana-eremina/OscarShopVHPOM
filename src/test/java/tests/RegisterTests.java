package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTests extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    String email = "diana-3@gmail.com";
    String password = "FmaNgaFmaNga";
    String emailInvalid = "diana@gmail.com"; // already existed

    @BeforeMethod
    public void initPage(){
        homePage = new HomePage(); // инициализация настроек для HomePage
        registerPage = new RegisterPage(); // инициализация настроек для RegisterPage
        loginPage = new LoginPage();
    }

    @Test (priority = 1) //
    public void registerPositiveTest() throws InterruptedException {
        homePage.clickOnLoginLink(); // вызываем метод, к-рый описан на стр homePage
        registerPage.registerFormIsVisible(); // вызываем метод, к-рый описан на стр registerPage
        registerPage.fillEmail(email); // тоже
        registerPage.fillPassword1(password);//  тоже
        registerPage.fillPassword2(password);//  тоже
        registerPage.clickRegister(); // тоже
        homePage.isItHomePage();// вызываем метод, к-рый описан на стр HomePage
        homePage.messageIsDisplayed("Thanks for registering!");// тоже
        Thread.sleep(1000); // если удалим ожидание - то убрать из заголовка "throws InterruptedException"
    }


    @Test (priority = 2)
    public void registerNegativeTest(){
        homePage.clickOnLoginLink();
        registerPage.registerFormIsVisible();
        registerPage.fillEmail(emailInvalid); //ввели неверный имейл
        registerPage.fillPassword1(password);
        registerPage.fillPassword2(password);
        registerPage.clickRegister();
        loginPage.isItLoginPage(); // страница ошибки показывается на той же стр что и для неверного логика
        loginPage.messageIsDisplayed("Oops! We found some errors"); // потому используем уже существующие методы со страницы логина

    }







}
