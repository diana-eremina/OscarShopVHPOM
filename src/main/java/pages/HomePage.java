package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    SelenideElement loginLink = $("#login_link");

    @Step
    public void clickOnLoginLink() {
        loginLink.shouldBe(Condition.visible).click();
    }

    @Step
    public void messageIsDisplayed(String message) {
        $(byText(message)).shouldBe(Condition.visible);
    }

    @Step
    public void isItHomePage() {
        Selenide.title().equals("http://selenium1py.pythonanywhere.com/en-gb/");
    }

    // выбор пункта меню по его названию
    @Step // чтобы в allure отчете были степы
    @Story("Selecting item in menu") // чтобы в allure отчете были названия шагов
    public void selectMenu(String value) { // value -- это название пунта, которое будет передаваться
        $(byXpath("//a[contains(text(),'" + value + "')]")).click(); // поиск по value
    }

    // перейти в корзину
    @Step
    public void viewBasket() {
        $(byText("View basket")).shouldBe(Condition.visible).click();
    }
}