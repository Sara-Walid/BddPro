package login;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

@CucumberOptions(glue = "login",features = "src/test/java/login/login.feature",plugin = {"pretty","html:tsrget/cucumber-html-report"})
public class RunnerLogin extends AbstractTestNGCucumberTests {


    public static WebDriver driver;
@BeforeClass
    public void start(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
}
}
