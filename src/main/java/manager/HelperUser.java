package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginForm() {
        WebElement loginTab = wd.findElement(By.xpath("//a[@href='/login?url=%2Fsearch']"));
        loginTab.click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void sabmit() {
        WebElement loginButton = wd.findElement(By.xpath("//*[@type='submit']"));
        loginButton.click();
    }


    public String getText() {
        return wd.findElement(By.xpath("//*[@class='message']")).getText();
    }
}
