package utils;

import enums.WebDriverEnum;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TestContext {
    private WebDriver driver;

    public TestContext() {
        // se inicializa el WebDriver una sola vez
        BasePage basePage = new BasePage(WebDriverEnum.CHROME);
        this.driver = basePage.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}