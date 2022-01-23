package pages;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    // вернуть название первого товара в корзине
    public String getNameInBasket() {
        return $("div h3 a").text();
    }

    public String getPriceInBasket() {
        return $(".basket-items .col-sm-1").text();
    }
}
