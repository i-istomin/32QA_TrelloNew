package tests;

import manage.MyDataProvider;
import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {


    @Test(dataProvider = "boardDataModel", dataProviderClass = MyDataProvider.class)//, enabled = false --->chtobi test ne zapuskalsia
    public void boardCreation1(Board board)  {
       // int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        logger.info(("Test boradcreation 1" + board.getTitle()));
        int boardCountBeforeCreation = app.getBoard().getBoardCount(); //metod kot-y vicheslit kol-vo dosok pered tem kak mi sozdali novuyu
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().pause(2000);
        // app.getBoard().scrollDownTheForm(); u menia net scrolla na saite trello
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        logger.info("Board is created");
        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);


    }

    @Test
    public void boardCreation2() {


        Board board = Board
                .builder()
                .title("TestQa32")
                .build();

        logger.info(("Test boradcreation 2" + board.getTitle()));
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().pause(2000);
        // app.getBoard().scrollDownTheForm(); u menia net scrolla na saite trello
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());


    }

    @Test(dataProvider = "boardData", dataProviderClass = MyDataProvider.class)
    public void boardCreation3(String boardName) {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;

//        Board board = Board
//                .builder()
//                .title("TestQa32" + index)
//                .build();



        int boardCountBeforeCreation = app.getBoard().getBoardCount(); //metod kot-y vicheslit kol-vo dosok pered tem kak mi sozdali novuyu
        logger.info("Test boradcreation 3" + boardName);
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(boardName);
        app.getBoard().pause(2000);
        // app.getBoard().scrollDownTheForm(); u menia net scrolla na saite trello
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        logger.info("Board is created");
       Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);


    }

    @Test (groups = {"logs"},invocationCount = 1)
    public void boardCreation4 ()  {

        Board board = Board.builder().title("testQA32").build();
        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        logger.info("Test boardcreation 4" + board.getTitle());
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
       // app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();
        logger.info("Board is created");

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

    @Test
    public void boardCreation5 ()  {

        Board board = Board.builder().title("testQA32").build();
        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        logger.info("Test boardcreation 5" + board.getTitle());
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
     //   app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();
        logger.info("Board is created");

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }
    @Test
    public void boardCreation22() {


        Board board = Board
                .builder()
                .title("TestQa32")
                .build();

        logger.info(("Test boradcreation 2" + board.getTitle()));
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().pause(2000);
        // app.getBoard().scrollDownTheForm(); u menia net scrolla na saite trello
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());


    }
}
