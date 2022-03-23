package manage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;   //pravoy klavishey generate construct webdriver
    BoardHelper board;


    public void init() throws InterruptedException {//zabiraem metod init is tesbase

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/Qa32_Trello/chromedriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");

        user = new UserHelper(wd);
        board=new BoardHelper(wd);
        user.login("missira85@gmail.com", "Irinka777$");//obrashaemsia k helperu
    }

    public BoardHelper getBoard() {
        return board;
    }

    public void stop() {
        //wd.close();
     //   wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }
}
