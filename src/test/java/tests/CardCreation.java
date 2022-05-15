package tests;

import manage.MyDataProvider;
import model.Card;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CardCreation extends TestBase{



    @Test(dataProvider = "dataCardCSV",dataProviderClass = MyDataProvider.class)

    public void cardCreation(Card card){
//        Card card= Card.builder().cardName("testQa32").color("green").build();
        app.getBoard().clickOnTheFirstBoard();
        app.getList().createList("TestQA32");
        app.getCard().initCardCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCreation();
    }

    @Test(groups = {"board"})
    public void cardCreation2(){
        Card card= Card.builder()
                .cardName("testQa32")
                .color("green")
                .build();
        app.getBoard().clickOnTheFirstBoard();
        app.getList().createList("TestQA32");
        app.getCard().initCardCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCreation();
    }
}
