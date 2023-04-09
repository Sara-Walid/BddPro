package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
    super(driver);
}

    By loginButtn = By.xpath("//input[@id=\"login-button\"]");
    By usernameText = By.xpath("//input[@id=\"user-name\"]");
    By passwordText = By.xpath("//input[@id=\"password\"]");
    By errorMessage = By.xpath("//div[@class=\"error-message-container error\"]");

    public void enterUsername(String username)
    {
        driver.findElement(usernameText).sendKeys(username);
    }
    public void enterPassword(String password)
    {
        driver.findElement(passwordText).sendKeys(password);
    }
    public void clickOnLoginBtn()
    {
        driver.findElement(loginButtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

}
