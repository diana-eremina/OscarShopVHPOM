package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogePage {

    // создаем список товаров (картинок) на странице
    ElementsCollection listOfBooks = $$(".product_pod img");

    // кликаем по товару с определенным номером
    public void selectBookByIndex(int i) {
        listOfBooks.get(i).click();
    }

    // создаем список кнопок на странице
    ElementsCollection listOfBooksButtons = $$(".product_pod .btn");

    // добавляем в корзину товар с определенным номером
    public void addToBasketByIndex(int i) {
        listOfBooksButtons.get(i).click();
    }

    // создаем список названий на странице
    ElementsCollection listOfBooksNames = $$(".product_pod [title]");

    // возвращаем название с определенным номером
    public String getNameByIndex(int i) {
        return listOfBooksNames.get(i).text();
    }

    // создаем список цен на странице
    ElementsCollection listOfBooksPrices = $$(".product_pod .price_color");

    public String getPriceByIndex(int i) {
        return listOfBooksPrices.get(i).text();
    }
}
