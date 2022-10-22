import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {
    @Test
    public void searchCurrentMonthSuccess() {
        app.getSearch().searchCurrentMonth2("Tel Aviv", "10/25/2022", "10/30/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchNextMonthSuccess() {
        app.getSearch().searchNextMonth("Tel Aviv", "11/26/2022", "12/30/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchPeriodFuture() { // Если этот метод отработает, думаю его лучше прописать для проверки
        // негативного сценария.
        // указать дату прошлого. Тогда можно Ассерт написать на проверку сообщения об ошибке.
        app.getSearch().searchPeriodFuture("Tel Aviv", "10/25/2022", "12/25/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());

    }

    @Test
    public void searchPeriodFuture2() { // Если этот метод отработает, думаю его лучше прописать для проверки
        // негативного сценария.
        // указать дату прошлого. Тогда можно Ассерт написать на проверку сообщения об ошибке.
        app.getSearch().searchPeriodFuture2("Tel Aviv", "11/25/2022", "12/25/2022");

    }
    @Test
    public void searchInPast(){
        app.getSearch().typePeriodInPast("Tel Aviv","10/5/2022","10/10/2022");
        app.getSearch().submitWithoutWaiting();
        Assert.assertTrue(app.getSearch().isYallaButtonNotActive());
        Assert.assertTrue(app.getSearch().isErrorMessageDisplayed());


    }

    @Test
    public void searchAnePeriod(){
        app.getSearch().selectAnyPeriod("Tel Aviv", "12/20/2022","1/18/2023");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());


    }

}
