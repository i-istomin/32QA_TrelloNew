package manage;

import model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase{

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreationFromHeader() {
        //click(By.cssSelector("[data-test-id='header-create-menu-button']"));  //p[@class='_1N9LJYg3C9x47Y']
        click(By.cssSelector("._1N9LJYg3C9x47Y"));
     //   click(By.cssSelector("[aria-label='BoardIcon']"));//button[@data-test-id='header-create-board-button']////p[contains(text(),'A board is made up of cards ordered on lists. Use ')]
        click(By.cssSelector("button[data-test-id='header-create-board-button']"));
    }


    public void fillBoardCreationForm(Board board) {
     //   type(By.cssSelector("[data-test-id = 'create-board-title-input']"), board.getTitle()); //
        type(By.cssSelector("input[type='text']"), board.getTitle());
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
       click(By.cssSelector("[data-test-id='create-board-submit-button']"));  ////button[contains(text(),'Create')]
        //click(By.cssSelector("._2NEPrwhDnsG_qO._3TTqkG5muwOzqZ._3Ik0JLsERwh6Ui._1Tu9wiuW4Te8Rx"));
       // click(By.xpath("(//button[contains(text(),'Create')])[1]"));
       // Thread.sleep(5000);
    }

    public boolean isCreated() {

            WebDriverWait wait= new WebDriverWait(wd,20);
            wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("//textarea[@aria-label='To Do']"))));
            return wd.findElement(By.cssSelector("//textarea[@aria-label='To Do']")).isDisplayed();
        }

    public void returnToHomePAge() {
                  click(By.cssSelector("._2ft40Nx3NZII2i"));

    }
}

