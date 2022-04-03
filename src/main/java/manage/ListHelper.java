package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListHelper extends HelperBase{
    public ListHelper(WebDriver wd) {
        super(wd);
    }

    public void createList(String listName) {
        click(By.cssSelector(".js-add-list"));//icon-sm icon-add
        type(By.cssSelector(".list-name-input"),listName);
        click(By.cssSelector("input[value='Add list']"));

    }
}
