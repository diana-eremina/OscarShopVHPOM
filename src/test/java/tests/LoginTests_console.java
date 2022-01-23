package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.util.DataProviders;

public class LoginTests_console extends TestBase{
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void initPage(){
        homePage = new HomePage(); // инициализируются настройки для страницы HomePage
        loginPage = new LoginPage(); // для LoginPage
    }

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


}
