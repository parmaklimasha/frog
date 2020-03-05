package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class PlanboardPageTF {
    private WebDriver driver;


    public PlanboardPageTF(WebDriver driver) {
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
    @FindBy(xpath = "//button[@aria-haspopup='true'][contains(.,'star_halfTransport file')]")
    WebElement TransportFileButton;
    @FindBy(xpath = "//button[@class='mat-menu-item ng-star-inserted cdk-focused cdk-mouse-focused'][contains(.,'Default')]")
    WebElement DefaultTf;
    @FindBy(xpath = "//*[@id=\"toast-container\"]")
    WebElement NotificationSuccessfullyCreated;
    @FindBy(xpath = "//button[@class='mat-menu-item'][contains(.,'Create multiple')]")
    WebElement CreateMultipleTf;
    @FindBy(id = "mat-input-9")
    WebElement FileDate;
    @FindBy(xpath = "//input[contains(@id,'mat-input-15')]")
    WebElement Amount;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Ok')]")
    WebElement ButtonOk;
    @FindBy(xpath = "(//mat-panel-title[@class='mat-expansion-panel-header-title'][contains(.,'Search and sort')])[1]")
    WebElement SearchAndSortPanel;
    @FindBy(xpath = "(//input[contains(@class,'mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored')])[1]")
    WebElement FilterDate;
    @FindBy(xpath = "(//li[@data-range-key='Today'][contains(.,'Today')])[1]")
    WebElement FilterDateToday;
    @FindBy(id = "transport-file-list")
    WebElement TransportFileListToday;


    Random random = new Random();
    int randomNum = random.nextInt(10);
    String val = String.valueOf(randomNum);

    public PlanboardPageTF clickMainMenuToggler() {
        mainMenuToggler.click();
        return this;
    }

    public PlanboardPageTF clickPlanboardButton() {
        PlanboardButton.click();
        return this;
    }

    public String headerPlanboard() {
        return PlanboardTitle.getText();
    }


    public PlanboardPageTF createTFbyDefault() {
        Actions build = new Actions(driver);
        build.moveToElement(TransportFileButton).build().perform();
        DefaultTf.click();
        return this;
    }

    public String assertSuccessfullyCreatedTF() throws InterruptedException {
        Thread.sleep(1000);
        return NotificationSuccessfullyCreated.getText();
    }

    public PlanboardPageTF clickNewBotton() {
        NewButton.click();
        return this;
    }

    public int countElementsBeforeCreatingTF() throws InterruptedException {
        Thread.sleep(1000);
        SearchAndSortPanel.click();
        Thread.sleep(1000);
        FilterDate.click();
        Thread.sleep(1000);
        FilterDateToday.click();
        SearchAndSortPanel.click();
        List<WebElement> transportFilesElements = TransportFileListToday.findElements(By.cssSelector("[class='entry cdk-drag-disabled ng-star-inserted']"));
        int countOfTransportFiles = transportFilesElements.size();
        return countOfTransportFiles;

    }

    public PlanboardPageTF createTFmultiple() {
        Actions build = new Actions(driver);
        build.moveToElement(TransportFileButton).build().perform();
        CreateMultipleTf.click();
        return this;
    }

    public PlanboardPageTF enterFileDate() throws InterruptedException {
        Thread.sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        FileDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        FileDate.sendKeys(date1);
        return this;
    }


    public PlanboardPageTF enterAmountTF() throws InterruptedException {
        Thread.sleep(1000);
        Amount.click();
        Amount.clear();
        Amount.sendKeys(val);
        return this;
    }

    public PlanboardPageTF clickOk() throws InterruptedException {
        Thread.sleep(2000);
        ButtonOk.click();
        Thread.sleep(3000);
        return this;
    }

    public PlanboardPageTF checkCreatedTFbyMultiple() throws InterruptedException {
        SearchAndSortPanel.click();
        FilterDate.click();
        FilterDateToday.click();
        SearchAndSortPanel.click();
        List<WebElement> transportFilesElements = TransportFileListToday.findElements(By.cssSelector("[class='entry cdk-drag-disabled ng-star-inserted']"));
        int countOfTransportFilesAfterCreatingTF = transportFilesElements.size();
        String countOfTransportFilesAfterCreatingTF1 = String.valueOf(countOfTransportFilesAfterCreatingTF);
        int sumOfElements = (countElementsBeforeCreatingTF());
        String sumOfElements1 = String.valueOf(sumOfElements);
        Assert.assertEquals(sumOfElements1, countOfTransportFilesAfterCreatingTF1);
        return this;
    }


}
