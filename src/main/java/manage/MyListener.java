package manage;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);//podkluchili logger

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("The element with locator---->" + by);//uvideli locator
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element with locator---->" + by + "<---- was found");//opredelili locator
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a 'throwable' element---->" + throwable.getMessage());
        logger.info(throwable.fillInStackTrace().toString());//otobrazi nam problemu

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        String myDirectory = "/home/i-istomin/TelRan/SYSTEMS/32QA_TrelloNew/src/test/resources/screenshots/screen" + index + ".png";//k absolutnomu putiu dobavili "screen"

       File tmp=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);// vremennoe hranilishe
       File screen=new File(myDirectory);//zdes skladiruyutsia vremennie screeny

        try {
            Files.copy(tmp,screen); //organizuy nam kopiu iz vremennogo v postoyannuyu
        }
        catch (IOException exc){
            exc.printStackTrace();
        }

    }
}
