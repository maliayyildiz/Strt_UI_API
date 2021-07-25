package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeliveryDetailsPage {
    public DeliveryDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='_1YY2t9IJ _2PPKVsZZ']")
    public WebElement deliveryID;
    @FindBy(id = "active-link")
    public WebElement ongoingTab;
    @FindBy(id = "scheduled-link")
    public WebElement scheduledTab;
    @FindBy(id = "history-link")
    public WebElement historyTab;
    @FindBy(xpath = "//button[@type='button']")
    public WebElement cancelDeliveryButton;
    @FindBy(xpath = "//div[@class='_2t62N1N_ _3HTt_1k_']")
    public WebElement progressBar;
    @FindBy(xpath = "//div[@class='Gb2jooww']")
    public WebElement deliveryStatusText;
//    @FindBy(xpath = "//div[@class='_2t62N1N_ _3HTt_1k_']")
//    public WebElement progressBarStatus;
}
