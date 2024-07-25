package steps;

import enums.WebDriverEnum;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.MyInfoPage;
import utils.TestContext;

public class myInfoSteps {
    private TestContext testContext;
    private MyInfoPage info;

    public myInfoSteps(TestContext context){
        this.testContext = context;
    }

    @Given("enter my info form")
    public void enter_my_info_form() throws InterruptedException {
        System.out.println("enter my info");
        info = new MyInfoPage(testContext.getDriver());
        info.enterMyInfo();
    }
}
