import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){

        // open login form
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("evnikel@gmail.com", "Elena1234$@");
        app.getHelperUser().sabmit();
        app.getHelperUser().pause(2000);
        Assert.assertEquals(app.getHelperUser().getText(),"Logged in success");




    }

}
