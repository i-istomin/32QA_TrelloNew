package manage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;// WebDriver wd;
    UserHelper user;   //pravoy klavishey generate construct webdriver
    BoardHelper board;
    CardHelper card;
    ListHelper list;
    AtlassianHelper atlassian;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws InterruptedException {//zabiraem metod init is tesbase
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests start in ChromeDriver");

        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests start in FirefoxDriver");
        }

        //  ChromeOptions chromeOptions = new ChromeOptions();
        //   WebDriverManager.chromedriver().setup();
        //  wd=new EventFiringWebDriver(new ChromeDriver());// wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/Qa32_Trello/chromedriver");
        logger.info("Test starts");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");

        user = new UserHelper(wd);
        board = new BoardHelper(wd);
        card = new CardHelper(wd);
        list = new ListHelper(wd);
        atlassian = new AtlassianHelper(wd);
        user.login("missira85@gmail.com", "Irinka777$");//obrashaemsia k helperu

        wd.register(new MyListener());
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

    public CardHelper getCard() {
        return card;
    }

    public ListHelper getList() {
        return list;
    }

    public String getUrl() {
        return wd.getCurrentUrl();
    }

    public AtlassianHelper getAtlassian() {
        return atlassian;
    }


}
