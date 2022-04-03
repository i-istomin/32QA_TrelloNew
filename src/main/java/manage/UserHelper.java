package manage;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }


    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }


    //ctrl alt m
    public void fillLoginEmailForm(String email, String password) throws InterruptedException {
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        Thread.sleep(5000);
        type(By.cssSelector("#password"), password);
    }

    public void fillLoginEmailForm(User user) throws InterruptedException {
        type(By.cssSelector("#user"), user.getEmail());
        click(By.cssSelector("#login"));
        Thread.sleep(5000);
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public boolean isLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("[data-test-id='header-member-menu-button']"))));
        return wd.findElement(By.cssSelector("[data-test-id='header-member-menu-button']")).isDisplayed();
    }

    public void logOut() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("#logout-submit"));
    }

    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size() > 0;
    }

    public void login(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        Thread.sleep(5000);
        type(By.name("password"), password);
        click(By.id("login-submit"));
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void openUserProfile() {
        click(By.cssSelector("[data-test-id = 'header-member-menu-profile']"));//[data-test-id = 'header-member-menu-profile'
    }

    public void goToTheAtlassianAccount() {
        click(By.xpath("//a[normalize-space()='Atlassian profile']"));
        //click(By.cssSelector("[href$='manage-profile']"));
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window((tabs.get(1)));
    }
    public void  returnToTrello(){
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.close();
        wd.switchTo().window((tabs.get(0)));
    }
}