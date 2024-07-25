package pages;

import locator.loginSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void loginSuccessful(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSelector.txtUserName));
        driver.findElement(loginSelector.txtUserName).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSelector.txtUserPass));
        driver.findElement(loginSelector.txtUserPass).sendKeys("admin123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSelector.btnIngresar));
        driver.findElement(loginSelector.btnIngresar).click();
    }

    public void visit(String url) {
        driver.get(url);
    }
}
