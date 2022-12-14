import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test (groups = {"smoke"})
    public void searchCurrentMonthSuccess(){
        app.getSearch().searchCurrentMonth2("Tel Aviv","10/31/2022","10/31/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test(groups = {"smoke"})
    public void searchNextMonthSuccess(){
        app.getSearch().searchNextMonth("Jerusalem Israel","11/25/2022","11/30/2022");
        // app.getSearch().searchNextMonth("Tel Aviv","11-25-22","11/30/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchAnyPeriod(){
        app.getSearch().selectAnyPeriod("Haifa Israel","2/20/2023","6/10/2023");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
        Assert.assertTrue(app.getSearch().isDataCorrect("2/20/2023","6/10/2023"));
    }
    @Test
    public void searchInPast(){
        app.getSearch().typePeriodInPast("Rehovot Israel","10/5/2022","10/10/2022");
        app.getSearch().submitWithoutWait();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed());  ///You can't pick date before today


    }

    @BeforeMethod  (alwaysRun = true)
    public void returnHomePage(){
        app.getSearch().clickLogo();
    }
}