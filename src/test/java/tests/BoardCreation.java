package tests;

import model.Board;
import org.testng.annotations.Test;
import tests.TestBase;

public class BoardCreation extends TestBase {

    @Test
    public void boardCreation1()throws InterruptedException{
        Board board=new Board().withTitle("TestQa32");

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
       // app.getBoard().scrollDownTheForm(); u menia net scrolla na saite trello
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        app.getBoard().returnToHomePAge();

    }
}
