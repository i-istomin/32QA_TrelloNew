package manage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click (By locator){
        wd.findElement(locator).click();
    }


    public void type (By locator, String text){
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openTabAndSwitch(){
        ((JavascriptExecutor)wd).executeScript("window.open()");//sozdaem massiv vkladok v massive
        List<String> tabs=new ArrayList<>(wd.getWindowHandles());//webdriver vozvrashaut ruchku chtobi dernut i pereyti
        wd.switchTo().window(tabs.get(1));//otkrit noviy tab
        wd.navigate().to("https://www.google.com/");
    }

    public void attachFile(By locator, File file){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());

    }
    public void  waitForElementAndCklick(By locator,int time){
        new WebDriverWait(wd,time).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

}

