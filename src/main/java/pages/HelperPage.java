package pages;

import com.codeborne.selenide.Selenide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperPage {

    public void takeScreenShot() {
        // задаем имя для файла
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curDate = formatter.format(date);
        String filePath = "screenshots/screenshot_" + curDate +".png";
        // делаем скриншот
        Selenide.screenshot(filePath);
    }


}
