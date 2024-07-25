package locator;

import org.openqa.selenium.By;

public class loginSelector {
    public static By txtUserName = By.xpath("//input[@placeholder='Username']");
    public static By txtUserPass = By.xpath("//input[@placeholder='Password']");
    public static By btnIngresar = By.xpath("//button[text()=' Login ']");
}
