package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='javascript:;']")
    WebElement tenant;
    @FindBy(xpath = "//input[contains(@name,'TenancyName')]")
    WebElement tenantName;
    @FindBy(xpath = "//button[@class='btn btn-primary save-button'][contains(.,'Save')]")
    WebElement saveTenant;
    @FindBy(xpath = "//input[contains(@placeholder,'User name or email *')]")
    WebElement userNameOrEmailField;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;
    @FindBy(xpath = "//span[@class='ng-tns-c1-0']")
    WebElement rememberMe;
    @FindBy(xpath = "//button[@class='btn btn-primary m-btn m-btn--pill m-btn--custom m-btn--air'][contains(.,'Log in')]")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='swal-title'][contains(.,'Login failed!')]")
    WebElement loginFailed;


    public LoginPage clickTenant() {
        tenant.click();
        return this;
    }

    public LoginPage typeTenantName(String nameOfTenant) {
        tenantName.sendKeys(nameOfTenant);
        return this;
    }

    public LoginPage saveTenantName() {
        saveTenant.click();
        return this;
    }

    public LoginPage typeUserNameOrEmailField(String userName) {
        userNameOrEmailField.sendKeys(userName);
        return this;
    }


    public LoginPage typePasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickRememberMe() {
        rememberMe.click();
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPage loginFailedTitle() {
        loginFailed.click();
        return this;
    }


}










