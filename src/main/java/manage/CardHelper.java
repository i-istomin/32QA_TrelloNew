package manage;

import model.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardHelper extends HelperBase {

    public CardHelper(WebDriver wd) {
        super(wd);
    }

    public void initCardCreation() {
        click(By.cssSelector(".js-add-a-card"));
    }

    public void fillCreationForm(Card card) {
        type(By.cssSelector(".js-card-title"), card.getCardName());
        if (card.getColor()!= null) {
            openCardMenu();
            selectLable();
            click(By.cssSelector("[data-color=" + card.getColor() + "]"));
//vibrali zvet i zamenili zvet na tot kot-y ukazan v modeli (cadcreaion)
        }

    }


    private void selectLable() {
        click(By.cssSelector(".js-label-selector"));
    }

    private void openCardMenu() {
        click(By.cssSelector(".js-cc-menu"));

    }

    public void submitCreation() {
        click(By.cssSelector("input[value='Add card']"));
    }
}
