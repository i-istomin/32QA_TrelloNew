package tests;

import model.Board;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class BoardCreation extends TestBase {



    @Test
    public void boardCreation1() throws InterruptedException {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        //    Board board=new Board().withTitle("TestQa32"+index);

        Board board = Board
                .builder()
                .title("TestQa32" + index)
                .build();
        logger.info(("Test boradcreation 1" + board.getTitle()));
        int boardCountBeforeCreation = app.getBoard().getBoardCount(); //metod kot-y vicheslit kol-vo dosok pered tem kak mi sozdali novuyu
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().pause(2000);
        // app.getBoard().scrollDownTheForm(); u menia net scrolla na saite trello
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePAge();

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        logger.info("Board is created");
        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);


    }

    @Test
    public void boardCreation2() throws InterruptedException {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;


        Board board = Board
                .builder()
                .title("TestQa32" + index)
                .build();

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().pause(2000);
        // app.getBoard().scrollDownTheForm(); u menia net scrolla na saite trello
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());


    }
}
