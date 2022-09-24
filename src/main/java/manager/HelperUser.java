package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginForm() {
       wd.findElement(By.xpath("//a[@href ^='/login']")).click();
        //wd.findElement(By.cssSelector("a[href ^='/login']")).click();
        // //a[text()=' Log in ']
    }
    public void openLoginFormFooter() {
        // a[href ^='/login']
        wd.findElement(By.xpath("//a[text()='Log in']")).click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
        //type(By.id("email"),email);
        //type(By.id("password"),password);
    }


    public String getText() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
        return wd.findElement(By.xpath("//*[@class='message']")).getText();
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        wd.findElement(By.xpath("//a[text()=' Logout ']")).click();
    }

    public void clickOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }
}
