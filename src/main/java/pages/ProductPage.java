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

    // проверка что первое сообщение показывается
    public void addedMessageIsDisplayed() {
        SelenideElement addedMessage = $(byCssSelector("#messages .alert.alert-safe.alert-noicon.alert-success.fade.in"));
        //создали переменную для сообщения "The shellcoder's handbook has been added to your basket."
        //это плохой локатор, он не по тексту. но по тексту хз как сделать

        //  локатор, который содержит название книги в переменной, is not a valid XPath expression (потому что в названии книги есть кавычка)
        // SelenideElement addedMessage = $(byXpath("//strong[contains(text(),'" + name + "')]"));

        // а этот - без переменной - работает (но нет смысла хардкодить точное название)
        // SelenideElement addedMessage = $(byXpath("//strong[contains(text(),'The shellcoder')]"));

        addedMessage.shouldBe(Condition.visible);
        // проверка что это  сообщение показывается
    }

    // проверка, что второе сообщение показывается
    public void DeferredBenefitMessageIsDisplayed() {
        SelenideElement DeferredBenefitMessage = $(byXpath("//strong[contains(text(),'Deferred benefit offer')]"));
        // это плохой локатор, котому что ищет текст "Deferred benefit offer", вне зависимости оттого, включен ли оффер для юзера или нет
        // проверить включенность нельзя, тк поиск по остальным словам сообщения не работает, никакакого особого класса у сообщения тоже нет.

        DeferredBenefitMessage.shouldBe(Condition.visible);
    }

    public void BasketTotalMessageIsDisplayed() {
        // сообщение показывается
        SelenideElement BasketTotalMessage = $(byCssSelector("#messages .alert-info"));
        BasketTotalMessage.shouldBe(Condition.visible);

        // Проверить цену внутри сообщения не получается, потому что:
        // String priceTemporary = ("<strong>" + price + "</strong>"); // взяли верную цену товара и добавили к нему теги <strong>
        // SelenideElement priceInMessage = $(byXpath("//strong[contains(text(),'£')]")); //получили цену из сообщения
        // Assert.assertEquals(priceTemporary, priceInMessage); // строки иденичны, но сравнение падает

        // Можно было бы убедиться, что в сообщении показывается цена £9.99, но это еще не значит что цена верная (вдруг там £999.9?)
        SelenideElement priceInMessage = $(byXpath("//strong[contains(text(),'£')]"));
        priceInMessage.shouldBe(Condition.visible);
    }
}
