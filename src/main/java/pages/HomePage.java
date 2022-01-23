package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    SelenideElement loginLink = $("#login_link");

    public void clickOnLoginLink() {
        loginLink.shouldBe(Condition.visible).click();
    }

    public void messageIsDisplayed(String message) {
        $(byText(message)).shouldBe(Condition.visible);
    }

    public void isItHomePage() {
        Selenide.title().equals("http://selenium1py.pythonanywhere.com/en-gb/");
    }

    // выбор пункта меню по его названию
    public void selectMenu(String value) { // value -- это название пунта, которое будет передаваться
        $(byXpath("//a[contains(text(),'" + value + "')]")).click(); // поиск по value
    }

    // перейти в корзину
    public void viewBasket() {
        $(byText("View basket")).shouldBe(Condition.visible).click();
    }
}