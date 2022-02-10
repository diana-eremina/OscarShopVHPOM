package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.PageHelper.takeScreenShot;

public class TestBase {

   // Logger logger = LoggerFactory.getLogger(TestBase.class); //для логирования

    @BeforeMethod(alwaysRun = true)
    public void initTest(Method m, Object[] p){

       System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
       System.setProperty("selenide.browser", "Chrome");
       Configuration.browserSize = "1920x1080";

       // чтобы тесты проходили без отрисовки (браузер не будет показываться):
       // Configuration.headless = true;


        open("http://selenium1py.pythonanywhere.com/en-gb/");
        Configuration.timeout = 10000;

        // логирование
        //logger.info("Start test: " + m.getName());
        //if(p.length != 0) {
        //    logger.info(" --> With data: " + Arrays.asList(p));
        //}
    }

    @AfterMethod(alwaysRun = true)
    public void closeTest(ITestResult result, Method method){

    /* скриншот при успехе/неуспехе теста
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
        if(!result.isSuccess()){
            takeScreenShot(method);
        }

        closeWebDriver(); // эта команда д.б. последней, после нее уже не писать!
    }






}