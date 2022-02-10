package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.lang.reflect.Method;
import java.util.Base64;

public class PageHelper {
//    public static void takeScreenshot(){
//        //Create new file name
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());
//        String curDate = formatter.format(date);
//        String filePath = "screenshots/screenshot_" + curDate;
//        Selenide.screenshot(filePath);
//    }

    @Attachment(value = "attachment", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenShot(Method method) {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
        return decoded;
    }





}