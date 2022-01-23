package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    SelenideElement registerForm = $("#register_form");
    public void registerFormIsVisible(){
        registerForm.shouldBe(Condition.visible);
    }

    public void fillEmail(String email) {
        $("#id_registration-email").setValue(email);
    }

    public void fillPassword1(String password) {
        $("#id_registration-password1").setValue(password);
    }

    public void fillPassword2(String password) {
        $("#id_registration-password2").setValue(password);
    }

    public void clickRegister() {
        $("[name=\"registration_submit\"]").click();
    }

}
