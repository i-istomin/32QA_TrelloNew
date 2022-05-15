package manage;

import model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreationFromHeader() {
          // click(By.cssSelector("._1N9LJYg3C9x47Y"));
       // click(By.cssSelector("button[data-test-id='header-create-board-button']"));
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
       // pause(500);
        click(By.cssSelector("[aria-label='BoardIcon']"));
    }


    public void fillBoardCreationForm(Board board) {
       type(By.cssSelector("input[type='text']"), board.getTitle());
        //type(By.cssSelector("[data-test-id = 'create-board-title-input']"), board.getTitle());

    }

    public void fillBoardCreationForm(String boardName){
      // type(By.cssSelector("input[type='text']"), boardName());
        type(By.cssSelector("[data-test-id = 'create-board-title-input']"), boardName);

    }
    public void scrollDownTheForm() {
//        Actions action = new Actions(wd);
//        WebElement container = wd.findElement(By.cssSelector("[data-test-id='header-create-menu-popover']"));
//        Rectangle rect = container.getRect();
//        int x= rect.getX()+10;
//        int y= rect.getY()+ rect.getHeight()/2;
//        action.moveByOffset(x,y).click().perform(); //x=shirina, y=visota
//
    } // net etogo metoda na saite trello

    public void submitBoardCreation() {
       click(By.cssSelector("[data-test-id='create-board-submit-button']"));
       // click(By.cssSelector("._2NEPrwhDnsG_qO._3TTqkG5muwOzqZ._3Ik0JLsERwh6Ui._1Tu9wiuW4Te8Rx"));

    }

    public boolean isCreated() {

        WebDriverWait wait = new WebDriverWait(wd, 30);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("._2GFX5xx4d2BRju._2HiZ2xVqGDyu2I"))));
        return wd.findElement(By.cssSelector("._2GFX5xx4d2BRju._2HiZ2xVqGDyu2I")).isDisplayed();//._2GFX5xx4d2BRju._2HiZ2xVqGDyu2I
    }

    public void returnToHomePage() {
        click(By.cssSelector("._2ft40Nx3NZII2i"));

    }

    public int getBoardCount() {
        return wd.findElements(By.cssSelector(".boards-page-board-section-list-item")).size() - recentlyViewedBoards();
    }

    public int recentlyViewedBoards() {
        return wd.findElements(By.xpath("//*[contains(@class,'icon-clock')]/../../..//li")).size();//div[class='all-boards'] div:nth-child(2) div:nth-child(1) div:nth-child(2) ul:nth-child(1)

    }

    public void clickOnTheFirstBoard() {
        click(By.cssSelector(".board-tile-details"));//board-tile-fade

    }



    public void openSideBoardenu() {
        click(By.cssSelector(".js-show-sidebar"));
    }


    public void openMore() {
        click(By.cssSelector(".js-open-more"));
    }

    public void closeBoard() throws InterruptedException {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector("[data-test-id='close-board-delete-board-button']"));
        Thread.sleep(5000);
        click(By.cssSelector("[data-test-id='close-board-delete-board-confirm-button']"));


    }
}

