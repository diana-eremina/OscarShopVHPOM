package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeMethod(alwaysRun = true)
    public void initTest(){
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//        System.setProperty("selenide.browser", "Chrome");
        Configuration.browserSize = "1920x1080";
        open("http://selenium1py.pythonanywhere.com/en-gb/");
        Configuration.timeout = 10000;
    }

    @AfterMethod(alwaysRun = true)
    public void closeTest(ITestResult result, Method method){
    /*
    // задаем имя для файла
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curDate = formatter.format(date);
        String filePath = "screenshots/screenshot_" + curDate +".png";
    // создаем скриншот с таким именем
        if (!result.isSuccess()){ // делаем скрин при неуспехе
            Selenide.screenshot(filePath);
        }
     */
        closeWebDriver();
    }

/*
    public static byte[] takeScreenShot(Method method) {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
        return decoded;
    }
*/



}