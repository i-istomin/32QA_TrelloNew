package tests;

import manage.ApplicationManager;
import model.User;
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
        // Thread.sleep(5000);
        app.getUser().isLoginSuccess();

        Assert.assertTrue(app.getUser().isLoginSuccess());

    }

    @Test
    public void loginSuccessModel() throws InterruptedException {

        //User user=new User().withEmail("missira85@gmail.com").withPassword("Irinka777$");
        User user=User
                .builder()
                .email("missira85@gmail.com")
                .password("Irinka777$")
                .build();

        logger.info("Test Login Positive 1"+user.getEmail()+ " "+user.getPassword());
        app.getUser().initLogin();
        app.getUser().fillLoginEmailForm(user);
        app.getUser().submitLogin();
       // Thread.sleep(5000);
        app.getUser().isLoginSuccess();
logger.info("Logged---");
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
