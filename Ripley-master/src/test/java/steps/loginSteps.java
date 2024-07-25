package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import utils.TestContext;

public class loginSteps {
    private TestContext testContext;
    private LoginPage login;

    public loginSteps(TestContext context){
        this.testContext = context;
    }

    @Before
    public void setUp(){
        login = new LoginPage(testContext.getDriver());
    }

    @Given("enter the login form")
    public void enter_the_login_form() throws InterruptedException {
        login.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        login.loginSuccessful();

    }
}
