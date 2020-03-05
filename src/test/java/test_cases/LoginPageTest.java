package test_cases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    static LoginPage loginPage;
    static WebDriver driver;
    static String nodeUrl;
    @Before
    public void setUp() {
        try {
            nodeUrl = "http://192.168.56.1:3181/wd/hub";
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
            driver.get("https://app.opentms.nl/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        loginPage = new LoginPage(driver);
    }

    @Test
    public void signInTest() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.clickTenant();
        loginPage.typeTenantName("Acceptance1");
        loginPage.saveTenantName();
        Thread.sleep(2000);
        loginPage.typeUserNameOrEmailField("maria.parmakli");
        loginPage.typePasswordField("helloworld");
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
    }

    @Test
    public void failSignInTest() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.clickTenant();
        loginPage.typeTenantName("Acceptance1");
        loginPage.saveTenantName();
        Thread.sleep(1000);
        loginPage.typeUserNameOrEmailField("abra");
        loginPage.typePasswordField("helloworld");
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
        loginPage.loginFailedTitle();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
