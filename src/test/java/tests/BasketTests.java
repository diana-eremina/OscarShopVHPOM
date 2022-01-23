package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.CatalogePage;
import pages.HomePage;
import pages.ProductPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketTests extends TestBase{
    HomePage homePage;
    BasketPage basketPage;
    CatalogePage catalogePage;
    ProductPage productPage;

    @BeforeMethod // подключаем методы со страниц Главная, Корзина
    public void initPage(){
        homePage = new HomePage();
        basketPage = new BasketPage();
        catalogePage = new CatalogePage();
        productPage = new ProductPage();
    }

   @Test
   public void nameValidation(){
// в идеале надо очищать корзину перед тестом, но она при незалогиненном запуске и так пустая

      homePage.selectMenu("Books"); // переход в меню books
      // параметризованный тест: передаем название пункта меню

      catalogePage.selectBookByIndex(0); //клик по первой же книжке
      productPage.productInformationIsDisplayed(); // проверка что попали на стр продукта

      String nameOnProductPage = productPage.getName(); // запомнить имя книги

      productPage.addToBasket(); // добавить в корзину
      homePage.viewBasket(); // перейти в корзину

      // проверить, что верное название книги в корзине в первом товаре
      String nameOnBasketPage = basketPage.getNameInBasket();
      Assert.assertEquals(nameOnProductPage, nameOnBasketPage);
  }

    @Test
    public void priceValidation(){
        homePage.selectMenu("Books"); // переход в меню books

        catalogePage.selectBookByIndex(0); //клик по первой же книжке
        productPage.productInformationIsDisplayed(); // проверка что попали на стр продукта

        String priceOnProductPage = productPage.getPrice(); // запомнить цену книги

        productPage.addToBasket(); // добавить в корзину
        homePage.viewBasket(); // перейти в корзину

        // проверить, что верная цена в корзине
        String priceInBasket = basketPage.getPriceInBasket();
        Assert.assertEquals(priceOnProductPage, priceInBasket);
    }

    @Test
    public void messageValidation() {
        homePage.selectMenu("Books"); // переход в меню books
        catalogePage.selectBookByIndex(0); //клик по первой же книжке

        productPage.productInformationIsDisplayed(); // проверка что попали на стр продукта

        // String name = productPage.getName(); // запоминать имя книги не надо, тк все равно не сможем его использовать
        // String price = productPage.getPrice(); // запоминать цену книги, тк все равно не сможем его использовать
        // System.out.println("First price: " + price); // делать тоже не надо, тк сравнение не срабатывает

        productPage.addToBasket(); // добавить в корзину

        productPage.addedMessageIsDisplayed(); // первое сообщение показывается

        productPage.DeferredBenefitMessageIsDisplayed(); // второе сообщение показывается

        productPage.BasketTotalMessageIsDisplayed(); // третье сообщение показывается
    }

    @Test
    public void addingToBasketFromCataloge() {
        homePage.selectMenu("Books"); // переход в меню books

        String nameInCataloge = catalogePage.getNameByIndex(1); // заполнить название книги
        System.out.println(nameInCataloge);

        String priceInCataloge = catalogePage.getPriceByIndex(1); // запомнить цену книги
        System.out.println(priceInCataloge);

        catalogePage.addToBasketByIndex(1);

        homePage.viewBasket(); // перейти в корзину

        // проверить, что верная цена в корзине
        String priceInBasket = basketPage.getPriceInBasket();
        Assert.assertEquals(priceInCataloge, priceInBasket);

        // проверить, что верное название в корзине
        String nameOnBasketPage = basketPage.getNameInBasket();
        Assert.assertEquals(nameInCataloge, nameOnBasketPage);

    }


}
