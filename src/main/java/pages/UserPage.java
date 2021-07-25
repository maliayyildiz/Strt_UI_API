package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UserPage {
    public UserPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement refundInfoUnderstoodButton;
    @FindBy(id = "ScenarioTooltipCloseButton")
    public WebElement scenarioInfoCloseButton;
    @FindBy(id = "newRequest-link")
    public WebElement requestDeliveryTab;
    @FindBy(id = "pickUpCard-0-fields-field-address")
    public WebElement pickupSearchAddressBox;
    @FindBy(id = "dropOffCard-0-fields-field-address")
    public WebElement dropOffSearchAddressBox;
    @FindBy(id = "addDropOffButton")
    public WebElement addDropOffButton;
    @FindBy(id = "dropOffCard-1-fields-field-address")
    public WebElement secondDropOffSearchAddressBox;
    @FindBy(id = "transport-bike")
    public WebElement selectBike;
    @FindBy(id = "transport-motorbike")
    public WebElement selectMotorBike;
    @FindBy(id = "transport-van")
    public WebElement selectVan;
    @FindBy(id = "transport-motorbikexl")
    public WebElement selectMotorBikeXL;
    @FindBy(id = "now")
    public WebElement scheduleOfDeliveryNowRadioButton;
    @FindBy(id = "later")
    public WebElement scheduleOfDeliveryLaterRadioButton;
    @FindBy(id = "daySelect")
    public WebElement dateDropDown;
    @FindBy(id = "slotSelect")
    public WebElement timeDropDown;
    @FindBy(id = "requestButton")
    public WebElement requestButton;
    @FindBy(id = "savedPlaceFirstLine-1301418")
    public WebElement firstLinePickupSavedAddress;
    @FindBy(id = "pickUpCard-0-fields-field-firstname")
    public WebElement pickupAddressFirstName;
    @FindBy(id = "savedPlaceFirstLine-1302495")
    public WebElement firstLineDropOffSavedAddress;
    @FindBy(id = "savedPlaceFirstLine-1618999")
    public WebElement firstLineDropOffSavedAddress2;
    @FindBy(xpath = "//strong[@class='_2GUaVkNp']")
    public List<WebElement> transportPriceList;
    @FindBy(xpath = "//td[@class='_27ZkTUCm']")
    public List<WebElement> transportTypeList;
    @FindBy(xpath = "//strong[@class='_1LOUYiKx']")
    public List<WebElement> estimatedTransportTimeList;


}
