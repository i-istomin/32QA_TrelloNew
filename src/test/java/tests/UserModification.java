package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserModification extends TestBase {

    @Test
    public void testNewTab() {
        app.getUser().openTabAndSwitch();
        app.getUser().pause(1000);
    }

    @Test
    public void testChangeAvatar(){
        app.getUser().clickOnAvatar();
        app.getUser().pause(2000);
        app.getUser().openUserProfile();
        app.getUser().pause(2000);
        app.getUser().goToTheAtlassianAccount();
        app.getUser().pause(2000);


        String url= app.getUrl();
        Assert.assertEquals(url,"https://id.atlassian.com/manage-profile/profile-and-visibility");

        app.getAtlassian().initChangeAvatar();
        app.getAtlassian().uploadPhoto();
        app.getAtlassian().pause(2000);
        app.getUser().returnToTrello();
        app.getUser().pause(2000);

        String curUrl= app.getUrl();
        Assert.assertEquals(curUrl,"https://trello.com/");
    }


}
