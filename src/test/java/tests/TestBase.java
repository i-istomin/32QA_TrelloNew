package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import manage.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


//testbase = roditelskiy klass


public class TestBase {
    // protected static ApplicationManager app = new ApplicationManager();// vizvali obyect
    //zabiram webdriver i perenosim v applicationmaneager

    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite// izmenili beforemethod,esto metoda na suite
    public void setAp() throws InterruptedException {// vmesto init pishem setup//public void init() { //browser+https
        app.init();//obrashaemsia k metodu kotoriy zahodit v browser
    }

    @BeforeMethod
    public void startLogger(Method method) {
        logger.info("Start test-->>" + method.getName());
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void finishLogger() {
        logger.info("******************************************************************");
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