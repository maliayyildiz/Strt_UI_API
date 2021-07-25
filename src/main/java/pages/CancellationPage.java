package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;
import utilities.Driver;

import java.util.List;

public class CancellationPage {
    public CancellationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "cancelDeliveriesModalConfirmButton")
    public WebElement cancelButton;
    @FindBy(id = "cancelDeliveriesModalCancelButton")
    public WebElement backButton;
    @FindBy(className = "Qv1htr_V")
    public List<WebElement> reasonOfCancellation;

}
