package manage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;   //pravoy klavishey generate construct webdriver
    BoardHelper board;
    CardHelper card;
    ListHelper list;
    AtlassianHelper atlassian;



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
        card=new CardHelper(wd);
        list=new ListHelper(wd);
        atlassian=new AtlassianHelper(wd);
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
    public CardHelper getCard(){
        return card;
    }

    public ListHelper getList(){
        return list;
    }

    public String getUrl() {
        return wd.getCurrentUrl();
    }

    public AtlassianHelper getAtlassian() {
        return atlassian;
    }


}
