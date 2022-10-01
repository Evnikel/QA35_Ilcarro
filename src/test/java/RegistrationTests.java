import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }


    @Test
    public void registrationSuccess() {
        System.out.println(System.currentTimeMillis());
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withName("Lisa").withLastname("Snow").withEmail("lis" + i + "@gmail.com").withPassword("Lis123@12");

        app.getHelperUser().openRegistrationFormHeader();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        app.getHelperUser().pause(2000);
        Assert.assertEquals(app.getHelperUser().getErrorAuthorization(), "Registered");

    }

    @Test
    public void registrationWrongPassword() {
        User user = new User()
                .withName("Lisa")
                .withLastname("Snow")
                .withEmail("lis@gmail.com")
                .withPassword("Yis");
        app.getHelperUser().openRegistrationFormHeader();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
        Assert.assertTrue(app.getHelperUser().isYallaButtoNotActive());
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}
