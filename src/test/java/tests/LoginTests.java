package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.util.DataProviders;

public class LoginTests extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    String email = "olga11@yandex.ru";
    String password = "Qwe123123";

    @BeforeMethod
    @Feature("Login")
    public void initPage(){
        homePage = new HomePage(); // инициализируются настройки для страницы HomePage
        loginPage = new LoginPage(); // для LoginPage
    }

    // данные берутся отсюда же, из этого файла в начале
   @Test (priority = 1, groups = "positive") // одна группа в кавычках
    public void loginPositiveTest(){
       homePage.clickOnLoginLink(); // вызываем метод, к-рый описан на стр homePage
       loginPage.loginFormIsVisible(); // вызываем метод, к-рый описан на стр loginPage
       loginPage.fillEmail(email); // email берется, указанный из этого же класса
       loginPage.fillPassword(password);// password берется, указанный из этого же класса
       loginPage.clickLogIn(); // клик на кнопку
       homePage.isItHomePage();// вызываем метод, к-рый описан на стр HomePage
       homePage.messageIsDisplayed("Welcome back");// вызываем метод, к-рый описан на стр HomePage
   }


/*
// данные возьмутся из консоли
    @Test (priority = 1, groups = "positive")
    @Parameters({"email", "password"})
    public void loginPositiveTest(String email, String password){
        homePage.clickOnLoginLink();
        loginPage.loginFormIsVisible();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.clickLogIn();
        homePage.isItHomePage();
        homePage.messageIsDisplayed("Welcome back");
    }
*/

   /* данные из файла testng
    @Test (priority = 2, groups = {"negative", "ccnc"}, enabled = true)
    // более 1 группы пишется в скобках
    // enabled: если false, то тест не будет запускаться
    @Parameters({"emailInvalid", "passwordInvalid"}) // значения будут браться не из этого класса, а из файла testng
    public void loginNegativeTest(String emailInvalid, String passwordInvalid){
        homePage.clickOnLoginLink();
        loginPage.loginFormIsVisible();
        loginPage.fillEmail(emailInvalid); //ввели неверный имейл
        loginPage.fillPassword(passwordInvalid);
        loginPage.clickLogIn();
        loginPage.isItLoginPage();
        loginPage.messageIsDisplayed("Oops! We found some errors");
   */

    //данные из файла dataproviders
    @Test (priority = 2, groups = {"negative"}, dataProviderClass = DataProviders.class, dataProvider = "loginNegativeUsingFile")

    public void loginNegativeTest(String emailInvalid, String passwordInvalid){ // последовательность дб такая же как в csv файле
        homePage.clickOnLoginLink();
        loginPage.loginFormIsVisible();
        loginPage.fillEmail(emailInvalid);
        loginPage.fillPassword(passwordInvalid);
        loginPage.clickLogIn();
        loginPage.isItLoginPage();
        loginPage.messageIsDisplayed("Oops! We found some errors");
    }

}
