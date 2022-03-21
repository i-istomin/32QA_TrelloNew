package tests;

import manage.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void loginSuccess() throws InterruptedException {

        app.getUser().initLogin();
        app.getUser().fillLoginEmailForm("missira85@gmail.com", "Irinka777$");
        app.getUser().submitLogin();

        //   Assert.assertTrue(app.getUser().isLoginSuccess());
        app.getUser().isLoginSuccess();

        Assert.assertTrue(app.getUser().isLoginSuccess());

    }
    @Test
    public void loginWithNegativePassword() throws InterruptedException{
        app.getUser().initLogin();
        app.getUser().fillLoginEmailForm("missira85@gmail.com", "missira");
        app.getUser().submitLogin();

    }
    @Test
    public void loginWithEmptyPassword() throws InterruptedException{
        app.getUser().initLogin();
        app.getUser().fillLoginEmailForm("missira85@gmail.com", "");
        app.getUser().submitLogin();
        // Thread.sleep(5000);
    }




}
