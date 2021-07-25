package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllPages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {
    static AllPages elements = new AllPages();

    public static void login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("sandboxWeb"));
        elements.loginPage().emailBox.sendKeys(ConfigurationReader.getProperty("testClient"));
        elements.loginPage().passwordBox.sendKeys(ConfigurationReader.getProperty("testPassword"));
        elements.loginPage().loginButton.click();
        waitForVisibility(elements.userPage().refundInfoUnderstoodButton, 5);
        elements.userPage().refundInfoUnderstoodButton.click();
        waitForClickablility(elements.userPage().scenarioInfoCloseButton, 2);
        elements.userPage().scenarioInfoCloseButton.click();
        Assert.assertTrue(elements.userPage().pickupSearchAddressBox.isDisplayed());
    }

    public static void selectSavedPickupAddress() {
        ReusableMethods.waitForVisibility(elements.userPage().pickupSearchAddressBox,3);
        elements.userPage().pickupSearchAddressBox.sendKeys("Eliza");
        waitFor(2);
        elements.userPage().firstLinePickupSavedAddress.click();
    }

    public static void selectSavedDropOffAddress() {
        ReusableMethods.scrollTo(elements.userPage().dropOffSearchAddressBox);
        elements.userPage().dropOffSearchAddressBox.sendKeys("JHU-APL");
        elements.userPage().firstLineDropOffSavedAddress.click();
    }

    public static void addAnotherDropOffAddress() {
        ReusableMethods.clickWithJS(elements.userPage().addDropOffButton);

        ReusableMethods.scrollTo(elements.userPage().secondDropOffSearchAddressBox);
        elements.userPage().secondDropOffSearchAddressBox.sendKeys("RB22");
        elements.userPage().firstLineDropOffSavedAddress2.click();
    }

    public static int findNearestTransportType() {
        ReusableMethods.scrollTo(elements.userPage().selectMotorBikeXL);
        waitFor(2);
        int fastestTime = 50;
        for (WebElement time : elements.userPage().estimatedTransportTimeList) {
            int tempTime = Integer.parseInt(time.getText());
            if (fastestTime > tempTime) {
                fastestTime = tempTime;
            }
        }
        return fastestTime;
    }

    public static double findCheapestTransportType() {
        ReusableMethods.scrollTo(elements.userPage().selectMotorBikeXL);
        waitFor(2);
        double cheapestPrice = 1000;

        for (WebElement price : elements.userPage().transportPriceList) {
            String priceString = price.getText();
            String priceInNumeric = priceString.substring(1);
            double priceInDouble = Double.parseDouble(priceInNumeric);
            if (cheapestPrice > priceInDouble) {
                cheapestPrice = priceInDouble;
            }
        }
        return cheapestPrice;
    }

    public static void selectCheapestTransportType() {
        String cheapestPrice = String.valueOf(findCheapestTransportType());
        for (WebElement price : elements.userPage().transportPriceList) {
            if (price.getText().contains(cheapestPrice)) {
                price.click();
            }
        }
    }

    public static void selectNearestTransportType() {
        String nearestTransport = String.valueOf(findNearestTransportType());
        for (WebElement time : elements.userPage().estimatedTransportTimeList) {
            if (time.getText().equals(nearestTransport)) {
                time.click();
            }
        }
    }

    public static void choiceOfTransportAndRequestDeliveryWith(String choice) {
        if (choice.toLowerCase().equals("nearest")) {
            selectNearestTransportType();
        } else if (choice.toLowerCase().equals("cheapest")) {
            selectCheapestTransportType();
            ReusableMethods.clickWithJS(elements.userPage().scheduleOfDeliveryNowRadioButton);
            ReusableMethods.clickWithJS(elements.userPage().requestButton);
            ReusableMethods.waitForVisibility(elements.deliveryDetailsPage().deliveryID,3);
            Assert.assertTrue(elements.deliveryDetailsPage().deliveryID.isDisplayed());
        }
    }
    public static void deliveryStatusVerification(){
        do{
            waitFor(1);
            if (elements.deliveryDetailsPage().deliveryStatusText.getText().contains("Pick up")){
                System.out.println("Courier is assigned by the system and heading to pick up the item(s).");
            }
        }while(!elements.deliveryDetailsPage().deliveryStatusText.getText().contains("Pick up"));
        do{
           // waitFor(1);
            if (elements.deliveryDetailsPage().deliveryStatusText.getText().contains("Drop off")){
                System.out.println("Courier is picked up the item(s) and heading to location to drop off the item(s).");
            }
        }while(!elements.deliveryDetailsPage().deliveryStatusText.getText().contains("Drop off"));
        do{
           // waitFor(1);
            if (elements.deliveryDetailsPage().deliveryStatusText.getText().contains("Job finish")){
                System.out.println("Job done.");
            }
        }while(!elements.deliveryDetailsPage().deliveryStatusText.getText().contains("Job finish"));
    }
    public static void cancelDelivery(){
        elements.deliveryDetailsPage().cancelDeliveryButton.click();
        ReusableMethods.waitForVisibility(elements.cancellationPage().cancelButton,3);
        elements.cancellationPage().reasonOfCancellation.get(0).click();
        elements.cancellationPage().cancelButton.click();
    }
    public static void anotherDeliveryWhileOtherDeliveryOnProcess(){
        elements.userPage().requestDeliveryTab.click();
        selectSavedDropOffAddress();
        choiceOfTransportAndRequestDeliveryWith("cheapest");
        elements.userPage().scheduleOfDeliveryNowRadioButton.click();
        elements.userPage().requestButton.click();

    }

    //==========
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);

        return target;
    }
}
