package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
    super(wd);
}

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {

        typeCity(city);
        click(By.id("dates"));
        //   "10/25/2022"
        // "aaa/fff/r"   ["aaa"] ["fff"] ["r"]
        String[] from =dataFrom.split("/");  /// ["10"] ["25"] ["2022"]  from[1] ="25"

        // String locator1 ="//div[text()=' 25 ']";
        String locator = "//div[text()=' "+from[1]+" ']";

        ///  "how are you, Dolli?"      names [Dolli] [Molli] [lis]
        //  "how are you, "+names[2]+"?"      how are you, lis?

        click(By.xpath(locator));




        // "10/30/2022"
        String [] to = dataTo.split("/");   /// to[1]
        String locator2 = "//div[text()=' "+to[1]+" ']";

        click(By.xpath(locator2));

    }
    public void searchCurrentMonth2(String city, String dataFrom, String dataTo) {

        typeCity(city);
        click(By.id("dates"));

        String[] from =dataFrom.split("/");


        //String locator = "//div[text()=' "+from[1]+" ']";
        String locator = String.format("//div[text()=' %s ']",from[1]) ;
        click(By.xpath(locator));


        String [] to = dataTo.split("/");

        String locator2 =  String.format("//div[text()=' %s ']",to[1]);

        click(By.xpath(locator2));

    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
        //pause(500);
    }

   public boolean isListOfCarsAppeared() {
       return isElementPresent(By.cssSelector(".cars-container.ng-star-inserted"));
    }

    public void searchNextMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        click(By.id("dates"));
        click(By.xpath("//button[@aria-label='Next month']"));
        logger.info("Click on the button Next month");
        String[] from =dataFrom.split("/");
        String locator = String.format("//div[text()=' %s ']",from[1]) ;
        click(By.xpath(locator));
        String [] to = dataTo.split("/");
        String locator2 =  String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    public void searchPeriodFuture(String city, String dataFrom, String dataTo) {
        typeCity(city);//Первый шаг тайпнуть на строку Город
        clearPeriod();/// Это я указала, так как остаются предыдущие значения и надо очистить.
        // Но так как там надо удалить или все выделив мышью или клавишами, я загуглила. Нашла способ.
        // // Не уверенна, что верный. Проверить не могу.
        type(By.id("dates"),dataFrom dataTo);//<-----Тут не знаю, как склеить датаФром и датаТу );
        // Дальше у нас не клик уже идет, а Тайп и там получается надо сначала указать любой период в месяце,
        // а потом в ручную поменять месяц. Чтоб курсор встал на строку я должна кликнуть на весь контейнер.
        // Его локатор я нашла, ниже указала. Тоже не уверенна, что правильно.
        // Там достаточно сложно было понять.
        click(By.cssSelector(".cdk-overlay-container"));


    }

    private void clearPeriod() {
        WebElement el = wd.findElement(By.id("dates"));
        el.sendKeys(Keys.CONTROL,"a");/// Почитала на этом сайте https://questu.ru/questions/7732125/
        el.sendKeys(Keys.DELETE);

    }
}
