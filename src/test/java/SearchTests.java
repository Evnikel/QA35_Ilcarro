import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {
    @Test(groups = {"smoke"})
    public void searchCurrentMonthSuccess() {
        app.getSearch().searchCurrentMonth2("Tel Aviv", "10/25/2022", "10/30/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchNextMonthSuccess() {
        app.getSearch().searchNextMonth("Jerusalem Israel", "11/26/2022", "12/30/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchInPast(){
        app.getSearch().typePeriodInPast("Rehovot Israel","10/5/2022","10/10/2022");
        app.getSearch().submitWithoutWaiting();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed());


    }

    @Test
    public void searchAnePeriod(){
        app.getSearch().selectAnyPeriod("Ashdod Israel", "12/20/2022","1/18/2023");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
        Assert.assertTrue(app.getSearch().isDataCorrect("2/20/2023","6/10/2023"));


    }

    @BeforeMethod (alwaysRun = true)
    public void returnHomePage(){
        app.getSearch().clickLogo();
    }

}
