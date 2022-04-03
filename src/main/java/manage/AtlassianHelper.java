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
        attachFile(By.cssSelector("#image-input"), new File("/home/i-istomin/TelRan/SYSTEMS/32QA_TrelloNew/src/test/resources/Screenshot_20220228-222931_ToonMe.jpg"));

        waitForElementAndCklick(By.cssSelector(".css-19r5em7"), 10);
    }



}
