package pages;

import enums.WebDriverEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriverEnum driverType) {
        switch (driverType) {
            case CHROME:
                this.driver = chromeDriverConnection();
                break;
            case FIREFOX:
                this.driver = firefoxDriverConnection();
                break;
            default:
                throw new IllegalArgumentException("Unknown driver type: " + driverType);

       // this.wait = new WebDriverWait(driver,10);
        }
    }

    public WebDriver chromeDriverConnection() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
        return driver;
    }

    public WebDriver firefoxDriverConnection() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        driver = new FirefoxDriver();
        return driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void setInputField(WebElement webElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        clearTextField(webElement);
        webElement.sendKeys(text);
    }

    public void setInputField(By selector, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        WebElement webElement = driver.findElement(selector);
        clearTextField(webElement);
        webElement.sendKeys(text);
    }

    public void clearTextField(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void frameSwitch() {
        driver.switchTo().frame("disneyid-iframe");
    }


    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void enter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }


    public void visit(String url) {
        driver.get(url);
    }

    public void waitForElementToAppear(By find) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(find));
    }
}

