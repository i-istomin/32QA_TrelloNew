package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class BoardDeletion extends TestBase {

    @Test
    public void boardDeletion() throws InterruptedException {
        int boardCountBeforeDeletion = app.getBoard().getBoardCount();
        app.getBoard().clickOnTheFirstBoard();
        app.getBoard().openSideBoardenu();
        app.getBoard().openMore();
        app.getBoard().closeBoard();

        int boardCountAfterDeletion = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterDeletion, boardCountBeforeDeletion - 1);
    }


}
