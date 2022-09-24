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
        if (app.getHelperUser().isLogged()) {
            //if(app.getHelperUser().isElementPresent(By.xpath("//a"))){
            app.getHelperUser().logout();

            @Test
            public void loginSuccess() {

                // open login form
                app.getHelperUser().openLoginForm();
                app.getHelperUser().fillLoginForm("evnikel@gmail.com", "Elena1234$@");
                app.getHelperUser().submit();
                //app.getHelperUser().pause(2000);
                Assert.assertEquals(app.getHelperUser().getText(), "Logged in success");

            }

            @Test
            public void loginSuccessModels() {

                User user=new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@");
            }


                app.getHelperUser().openLoginForm();
                app.getHelperUser().fillLoginForm(user);
                app.getHelperUser().submit();

                Assert.assertEquals(app.getHelperUser().getText(), "Logged in success");
            }

            @@Test
        public void negativeWrongEmail(){

            User user=new User().withEmail("evnikelgmail.com").withPassword("Elena1234$@");

            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm(user);
            app.getHelperUser().submit();
            // Assert errorMessagge
            // Assert buttonYalla not active
        }
        @Test
        public void negativeWrongPassword(){
            User user=new User().withEmail("evnikel@gmail.com").withPassword("Ylena1234$@");

            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm(user);
            app.getHelperUser().submit();
            // Assert text message "Authorization error"

        }


        @AfterMethod
        public void postCondition(){
            app.getHelperUser().clickOkButton();
        }

    }
