package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketTests extends TestBase{
    HomePage homePage;
    BasketPage basketPage;
    CatalogePage catalogePage;
    ProductPage productPage;
    HelperPage helperPage;

    @BeforeMethod // подключаем методы со страниц Главная, Корзина
    @Feature("Basket") // чтобы в allure-отчете была группировка
    public void initPage(){
        homePage = new HomePage();
        basketPage = new BasketPage();
        catalogePage = new CatalogePage();
        productPage = new ProductPage();
        helperPage = new HelperPage();
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

      helperPage.takeScreenShot();

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

        String name = productPage.getName(); // запомнить имя книги
        String priceOnProductPage = productPage.getPrice(); // запоминать цену книги, тк все равно не сможем его использовать
        // System.out.println("First price: " + price); // делать тоже не надо, тк сравнение не срабатывает

        productPage.addToBasket(); // добавить в корзину

        // первое сообщение показывается
        String expectedAddedMessage = productPage.addedToYourBasketMessage();
        Assert.assertEquals(name + " has been added to your basket.", expectedAddedMessage);

        // второе сообщение показывается
        String offerName = productPage.getOfferName(); // получить название оффера в сообщении
        String expectedOfferMessage = new String();
        expectedOfferMessage = "Your basket now qualifies for the Deferred benefit offer offer.";
        Assert.assertEquals("Your basket now qualifies for the " + offerName + " offer.", expectedOfferMessage);

        // третье сообщение показывается
        productPage.BasketTotalMessageIsDisplayed();
        String expectedBasketTotalMessage = new String();
        expectedBasketTotalMessage = "Your basket total is now " + priceOnProductPage;

        String priceInMessage = new String();
        priceInMessage = productPage.getPriceInMessage();

        Assert.assertEquals("Your basket total is now " + priceInMessage, expectedBasketTotalMessage);
    }

    @Test
    public void addingToBasketFromCataloge() {
        homePage.selectMenu("Books"); // переход в меню books

        String nameInCataloge = catalogePage.getNameByIndex(1); // заполнить название книги

        String priceInCataloge = catalogePage.getPriceByIndex(1); // запомнить цену книги

        catalogePage.addToBasketByIndex(1);
        homePage.viewBasket(); // перейти в корзину

        // проверить, что верная цена в корзине
        String priceInBasket = basketPage.getPriceInBasket();
        Assert.assertEquals(priceInCataloge, priceInBasket);

        // проверить, что верное название в корзине
        String nameOnBasketPage = basketPage.getNameInBasket();
        Assert.assertEquals(nameInCataloge, nameOnBasketPage);
    }

    @Test
    public void addingToBasketFromProductPage() {
        homePage.selectMenu("Books"); // переход в меню books

        catalogePage.selectBookByIndex(0); //клик по первой же книжке
        productPage.productInformationIsDisplayed(); // проверка что попали на стр продукта

        String nameOnProductPage = productPage.getName(); // запомнить имя книги
        String priceOnProductPage = productPage.getPrice(); // запомнить цену книги

        productPage.addToBasket(); // добавить в корзину
        homePage.viewBasket(); // перейти в корзину

        // проверить, что верное название книги
        String nameOnBasketPage = basketPage.getNameInBasket();
        Assert.assertEquals(nameOnProductPage, nameOnBasketPage);

        // проверить, что верная цена в корзине
        String priceInBasket = basketPage.getPriceInBasket();
        Assert.assertEquals(priceOnProductPage, priceInBasket);
    }


}
