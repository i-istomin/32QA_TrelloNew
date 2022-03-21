package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import manage.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;


//testbase = roditelskiy klass


public class TestBase {
    // protected static ApplicationManager app = new ApplicationManager();// vizvali obyect
    //zabiram webdriver i perenosim v applicationmaneager

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite// izmenili beforemethod,esto metoda na suite
    public void setAp() throws InterruptedException {// vmesto init pishem setup//public void init() { //browser+https
        app.init();//obrashaemsia k metodu kotoriy zahodit v browser
    }


    @AfterSuite
    public void tearDown() {
        app.stop();
    }


//    public void click(By locator) {
//        wd.findElement(locator).click();
//
//    }

//    public void type(By locator, String text) {
//        if (text != null) {
//            WebElement element = wd.findElement(locator);
//            element.click();
//            element.clear();
//            element.sendKeys(text);
//        }
//    }
}