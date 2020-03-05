package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class PlanboardPageTO {
    private WebDriver driver;

    public PlanboardPageTO(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//i[@class='material-icons m--icon-middle'][contains(.,'apps')]")
    WebElement mainMenuToggler;
    @FindBy(xpath = "//li[@tabindex='0'][contains(.,'timerPlanboard')]")
    WebElement PlanboardButton;
    @FindBy(css = "#current-app-name")
    WebElement PlanboardTitle;
    @FindBy(xpath = "//a[@aria-haspopup='true'][contains(.,'addNew')]")
    WebElement NewButton;
    @FindBy(xpath = "//button[@aria-haspopup='true'][contains(.,'starTransport order')]")
    WebElement TransportOrderButton;
    @FindBy(xpath = "//button[@class='mat-menu-item ng-star-inserted cdk-focused cdk-mouse-focused'][contains(.,'Default')]")
    WebElement DefaultTO;
    @FindBy(xpath = "//input[contains(@id,'mat-input-11')]")
    WebElement RelationInTO;
    @FindBy(xpath = "//mat-option[@id='mat-option-3']")
    WebElement ClickRelation;
    @FindBy(xpath = "//input[contains(@id,'mat-input-27')]")
    WebElement ClickOnSecondRelation;
    @FindBy(xpath = "//mat-option[contains(@id,'mat-option-307')]")
    WebElement SelectSecondRelation;
    @FindBy(css = "#mat-input-23")
    WebElement FirstTimeslot;
    @FindBy(xpath = "//mat-option[@class='mat-option ng-star-inserted'][contains(.,'12:00 - 16:00')]")
    WebElement EnterFirstTimeslot;
    @FindBy(css = "#mat-input-30")
    WebElement SecondTimeslot;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'06:00 - 08:00')]")
    WebElement EnterSecondTimeslot;
    @FindBy(xpath = "(//input[contains(@id,'reference')])[1]")
    WebElement FirstReference;
    @FindBy(xpath = "(//input[contains(@id,'reference')])[2]")
    WebElement SecondReference;
    @FindBy(xpath = "(//input[contains(@id,'remarks')])[1]")
    WebElement FirstRemarks;
    @FindBy(xpath = "(//input[contains(@id,'remarks')])[2]")
    WebElement SecondRemarks;
    @FindBy(xpath = "//input[contains(@id,'mat-input-33')]")
    WebElement TransportUnit;
    @FindBy(xpath = "//mat-option[contains(@id,'mat-option-453')]")
    WebElement ChooseTransportUnit;
    @FindBy(xpath = "//input[contains(@formcontrolname,'amount')]")
    WebElement AmountField;
    @FindBy(xpath = "//input[contains(@formcontrolname,'colli')]")
    WebElement ColliField;
    @FindBy(xpath = "//input[contains(@formcontrolname,'weight')]")
    WebElement WeightField;
    @FindBy(xpath = "//input[contains(@formcontrolname,'epq')]")
    WebElement EPQField;
    @FindBy(xpath = "//input[contains(@formcontrolname,'loadingMeters')]")
    WebElement LoadingMetersField;
    @FindBy(xpath = "//input[contains(@formcontrolname,'volume')]")
    WebElement VolumeField;
    @FindBy(xpath = "//input[contains(@formcontrolname,'calculatedDistance')]")
    WebElement DistanceField;
    @FindBy(xpath = "//input[contains(@formcontrolname,'remarks')]")
    WebElement WholeRemarks;
    @FindBy(xpath = "//button[@color='primary'][contains(.,'add AddNewFreight')]")
    WebElement AddNewFreight;
    @FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'saveSave')]")
    WebElement SaveButton;


    public PlanboardPageTO clickMainMenuToggler() {
        mainMenuToggler.click();
        return this;
    }

    public PlanboardPageTO clickPlanboardButton() {
        PlanboardButton.click();
        return this;
    }

    public String headerPlanboard() {
        return PlanboardTitle.getText();
    }

    public PlanboardPageTO clickNewBotton() {
        NewButton.click();
        return this;
    }

    public PlanboardPageTO creatingTObyDefault() throws InterruptedException {
        Actions build = new Actions(driver);
        build.moveToElement(TransportOrderButton).build().perform();
        DefaultTO.click();
        Thread.sleep(6000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }

    public PlanboardPageTO enterTransportOrderFields() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        RelationInTO.click();
        ClickRelation.click();
        ClickOnSecondRelation.click();
        SelectSecondRelation.click();
        Thread.sleep(1000);
        FirstTimeslot.click();
        EnterFirstTimeslot.click();
        Thread.sleep(1000);
        SecondTimeslot.click();
        EnterSecondTimeslot.click();
        FirstReference.sendKeys("Reference1");
        SecondReference.sendKeys("Reference2");
        FirstRemarks.sendKeys("Remarks1");
        SecondRemarks.sendKeys("Remarks2");
        TransportUnit.click();
        ChooseTransportUnit.click();
        AmountField.clear();
        AmountField.sendKeys("10");
        ColliField.clear();
        ColliField.sendKeys("20");
        Thread.sleep(1000);
        WeightField.clear();
        WeightField.sendKeys("30");
        EPQField.clear();
        EPQField.sendKeys("40");
        LoadingMetersField.clear();
        LoadingMetersField.sendKeys("50");
        VolumeField.clear();
        VolumeField.sendKeys("60");
        DistanceField.clear();
        DistanceField.sendKeys("70");
        WholeRemarks.clear();
        WholeRemarks.sendKeys("WholeRemarks");
        AddNewFreight.click();
        Thread.sleep(2000);
        return this;
    }
    public PlanboardPageTO clickSaveButton() throws InterruptedException {
        SaveButton.click();
        Thread.sleep(2000);
        return this;
    }


}
