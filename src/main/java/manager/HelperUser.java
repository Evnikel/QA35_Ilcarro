package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginFormHeader() {

        wd.findElement(By.cssSelector("a[href ^='/login']")).click();
        // //a[text()=' Log in ']
    }
    public void openLoginFormFooter() {
        // a[href ^='/login']
        wd.findElement(By.xpath("//a[text()='Log in']")).click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public String getMessage() {
        //pause(3000);
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));

        return wd.findElement(By.cssSelector("h2.message")).getText();
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        wd.findElement(By.xpath("//a[text()=' Logout ']")).click();
    }

    //public void clickOkButton() {
        //click(By.xpath("//button[text()='Ok']"));
    //}

    public String getError() {
        return wd.findElement(By.xpath("//*[@class='error']")).getText();
    }

    public boolean isYallaButtoNotActive() {
        boolean disabled = wd.findElement(By.cssSelector("button[disabled]")).isDisplayed();
        //boolean enabled = wd.findElement(By.cssSelector("[type='submit']")).isEnabled();

        return disabled;  ///Этот метод можно сделать общим, так как кнопка может быть активной и не активной.
    }


    public String getErrorAuthorization() {
        return wd.findElement(By.xpath("//*[text()='Authorization error']")).getText();

    }


}
