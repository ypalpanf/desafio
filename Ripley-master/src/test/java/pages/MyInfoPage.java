package pages;

import locator.loginSelector;
import locator.myInfoSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void enterMyInfo() throws InterruptedException {
     //   visit("https://duckduckgo.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myInfoSelector.btnMyInfo));
        driver.findElement(myInfoSelector.btnMyInfo).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myInfoSelector.btnAdmin));
        driver.findElement(myInfoSelector.btnAdmin).click();
        System.out.println("exit method");
    }

}
