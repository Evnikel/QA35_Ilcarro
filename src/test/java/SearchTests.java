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
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }
    @Test
    public void searchPeriodPast(){
        app.getSearch().searchPeriodPast("Tel Aviv", "09/25/2022", "12/25/2022");
        //Assert.assertTrue(app.getSearch().isYallaButtonNotActive());
        Assert.assertTrue(app.getSearch().isPeriodInPast());


    }

}
