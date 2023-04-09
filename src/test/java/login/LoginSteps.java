package login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;



public class LoginSteps {
    LoginPage loginPage;
    WebDriver driver;
    SoftAssert softAssert;

    @Given("navigate to login page")
    public void navigate_to_login_page(){
     driver = RunnerLogin.driver;
     driver.get("https://www.saucedemo.com/");
     driver.manage().window().maximize();
     LoginPage loginPage = new LoginPage(driver);
//     SoftAssert softAssert = new SoftAssert();
    }

    @When("valid username and password are entered")
    public void validUsernameAndPasswordAreEntered() {

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @And("click on submit button")
    public void clickOnSubmitButton() {
        loginPage.clickOnLoginBtn();
    }

    @Then("user's home page is displayed")
    public void userSHomePageIsDisplayed() {
//        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        
    }

    @When("Invalid username and password are entered")
    public void invalidUsernameAndPasswordAreEntered() {
        loginPage.enterUsername("standarduser");
        loginPage.enterPassword("secretsauce");
    }

    @Then("error message will be displayed")
    public void errorMessageWillBeDisplayed() {
    softAssert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
        softAssert.assertAll();;
    }
}