import manager.DataProviderUser;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {




    @BeforeMethod(alwaysRun = true)
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

    @Test (dataProvider = "datalogin", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {
        logger.info("Test LoginTests start with name ----->email: " +email+ "password" +password);

        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("In assert checked message 'Logged in success' in dialog  ");
        app.getHelperUser().pause(500);
    }

    @Test(dataProvider = "dataModelUser",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelsDP(User user) {

        logger.info("Login scenario success was used data"+user.toString());

        app.getHelperUser().openLoginFormFooter();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }



    @Test(groups = {"smoke"})
    public void loginSuccessModels() {
        User user = new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@");
        logger.info("Login scenario success was used data"+user.toString());
        app.getHelperUser().openLoginFormFooter();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("In assert checked message 'Logged in success' in dialog  ");

    }

    @Test
    public void negativeWrongEmail() {

        User user = new User().withEmail("evnikelgmail.com").withPassword("Elena1234$@");
        logger.info("Login negative scenario with wrong email was used data"+user.toString());
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitWithoutWait();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("In assert checked error message 'It'snot look like email' under name field ");

    }

    @Test
    public void negativeWrongPassword() {
        User user = new User().withEmail("evnikel@gmail.com").withPassword("Ylena1234$@");
        logger.info("Login negative scenario with wrong passeord was used data"+user.toString());
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitWithoutWait();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Wrong email or password");
        Assert.assertEquals(app.getHelperUser().getTitleMessage(), "Authorization error");
        logger.info("In assert checked message 'Authorization error' & 'Wrong email or password' in dialog  ");

        // Assert text message "Authorization error"

    }


   @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }

}
