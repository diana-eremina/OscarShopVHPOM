package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    // Показывается текст "Product Information"
    public void productInformationIsDisplayed() {
        $(byText("Product Information")).shouldBe(Condition.visible);
    }

    // Вернуть название товара
    public String getName() {
        return $(byCssSelector(".product_main h1")).text();
    }

    // Вернуть цену товара
    public String getPrice() {
        return $(byCssSelector(".product_main .price_color")).text();
    }

    // Добавить товар в корзину
    public void addToBasket() {
        $(byText("Add to basket")).click();
    }

    // текст первого сообщения
    public String addedToYourBasketMessage() {
        String productName = new String();
        productName = this.getName();
        String addedToYourBasketMessageText = productName + " has been added to your basket.";
        return addedToYourBasketMessageText;
    }

    // Вернуть название оффера в сообщении
    public String getOfferName() {
        return $(byXpath("//strong[contains(text(),'offer')]")).text();
    }

    public String getPriceInMessage() {
        return $(byXpath("//strong[contains(text(),'£')]")).text();
    }

    public void BasketTotalMessageIsDisplayed() {
        // сообщение показывается
        SelenideElement BasketTotalMessage = $(byCssSelector("#messages .alert-info"));
        BasketTotalMessage.shouldBe(Condition.visible);
    }


}
