package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement loginForm = $("#login_form");

    public void loginFormIsVisible(){
        loginForm.shouldBe(Condition.visible);
    }

    public void fillEmail(String email) {
        $("#id_login-username").setValue(email);
    }

    public void fillPassword(String password) {
        $("#id_login-password").setValue(password);
    }

    public void clickLogIn() {
        $("[name=\"login_submit\"]").click();
    }

    public void isItLoginPage() {
        Selenide.title().equals("http://selenium1py.pythonanywhere.com/en-gb/accounts/login/");
    }

    public void messageIsDisplayed(String message) {
        $(byText(message)).shouldBe(Condition.visible);
    }



}
