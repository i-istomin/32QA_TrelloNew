package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class AtlassianHelper extends HelperBase {
    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }


    public void initChangeAvatar() {
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']")))
                .pause(3).click(wd.findElement(By.cssSelector(".css-1ujqpe8"))).perform();
        click(By.xpath("//*[@role='menuitem'] [1]"));
    }

    public void uploadPhoto() {
        attachFile(By.cssSelector("#image-input"),
                new File("/home/i-istomin/TelRan/SYSTEMS/32QA_TrelloNew/src/test/resources/Screenshot_20220228-222931_ToonMe.jpg"));
        waitForElementAndCklick(By.cssSelector(".css-12eh8h8"), 10);
    }

    public void uploadPhoto2(String image) throws InterruptedException {
        wd.findElement(By.cssSelector("#image-input")).sendKeys(image);
        Thread.sleep(2000);
        click(By.cssSelector(".css-12eh8h8"));
    }

    public void initChangePhoto() {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"))).click().perform();
        pause(3000);
        click(By.xpath("//*[@role='menuitem'][1]"));
    }


}
