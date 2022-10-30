import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("The logout was needed ");
        }
    }

    @Test(dataProvider = "regDataValid", dataProviderClass = DataProviderUser.class,enabled = false)
    public void registrationSuccessDP(User user) {
        logger.info("Registration scenario success was used data"+user.toString());

        app.getHelperUser().openRegistrationFormHeader();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        //app.getHelperUser().pause(2000);
        Assert.assertEquals(app.getHelperUser().getTitleMessage(), "Registered");
        logger.info("In assert checked message 'Registered' in dialog  ");


    }


    @Test(description = "Bug Jira 00012",enabled = false)
    public void registrationSuccess() {
        System.out.println(System.currentTimeMillis());
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withName("Lisa").withLastname("Snow").withEmail("lis" + i + "@gmail.com").withPassword("Lis123@12");
        logger.info("Registration  scenario success was used data"+user.toString());
        app.getHelperUser().openRegistrationFormHeader();
        app.getHelperUser().fillRegistrationForm(user);
        logger.info("Tests start registrationSuccess with data----->" +user.toString());
        app.getHelperUser().checkPolicyXY();
        logger.info("Type ---> I agree to the terms of use and privacy policy and Button Yalla");
        app.getHelperUser().submitWithoutWait();
        //app.getHelperUser().submit();
        app.getHelperUser().pause(2000);
        Assert.assertEquals(app.getHelperUser().getTitleMessage(), "Registered");
        logger.info("In assert checked message 'Registered' in dialog  ");


    }

    @Test(groups = {"smoke"})
    public void registrationWrongPassword() {
        User user = new User()
                .withName("Lisa")
                .withLastname("Snow")
                .withEmail("lis@gmail.com")
                .withPassword("Yis");
        app.getHelperUser().openRegistrationFormHeader();
        app.getHelperUser().fillRegistrationForm(user);
        logger.info("Test registrationWrongPassword start- run with" +user.toString());
        app.getHelperUser().checkPolicy();
        //app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submitWithoutWait();
//        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
//        logger.info("Assert Error ---> Password must contain 1 uppercase letter, 1 lowercase letter and one number");
//        Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
//        logger.info("Assert Error ---> Password must contain minimum 8 symbols");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("The Y'alla button was not active");

    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}
