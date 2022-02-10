package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String getDateForEmail(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());
        String dateForEmail = formatter.format(date);
        return dateForEmail;
    }

}
