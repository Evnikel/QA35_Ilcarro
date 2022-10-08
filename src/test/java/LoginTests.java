import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        logger.info("Start checking authorization");
        if (app.getHelperUser().isLogged()) {
            //if(app.getHelperUser().isElementPresent(By.xpath("//a"))){
            app.getHelperUser().logout();
            logger.info("Test was needed in logout ");
        }else {
            logger.info("Test was not needed in logout ");
        }
    }

    @Test
    public void loginSuccess() {
        logger.info("Test LoginTests start with name ----->loginSuccess");
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm("evnikel@gmail.com", "Elena1234$@");
        logger.info("User login data: email: evnikel@gmail.com & password Elena1234$@");

        app.getHelperUser().submit();
        logger.info("Assert ---> Logged in success ");
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().pause(500);
    }

    @Test
    public void loginSuccessModels() {


        User user = new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@");

        app.getHelperUser().openLoginFormFooter();
        app.getHelperUser().fillLoginForm(user);
        logger.info("Test start loginSuccessModels - run with username and password"   +user.toString());
        app.getHelperUser().submit();
        logger.info("Assert-----> Logged in success");
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }

    @Test
    public void negativeWrongEmail() {

        User user = new User().withEmail("evnikelgmail.com").withPassword("Elena1234$@");

        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        //app.getHelperUser().submit();
        logger.info("Test start negativeWrongEmail - run with username and password"   + user.toString());
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        logger.info("Assert error Message-----> It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert ------> isYallaButtonNotActive");

    }

    @Test
    public void negativeWrongPassword() {
        User user = new User().withEmail("evnikel@gmail.com").withPassword("Ylena1234$@");

        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        logger.info("Test start negativeWrongPassword - run with username and password"   + user.toString());
        app.getHelperUser().submit();
        logger.info("Assert error Message-----> Wrong email or password");
        logger.info("Assert ------> Authorization error");
        Assert.assertEquals(app.getHelperUser().getMessage(),"Wrong email or password");
        Assert.assertEquals(app.getHelperUser().getTitleMessage(), "Authorization error");

        // Assert text message "Authorization error"

    }


   @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }

}
