package UITest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllPages;
import utilities.ReusableMethods;
import utilities.TestBaseFinal;

public class HappyPath extends TestBaseFinal {
    AllPages elements = new AllPages();

    @Test
    public void happyTest(){
        ReusableMethods.login();
        ReusableMethods.selectSavedPickupAddress();
        ReusableMethods.selectSavedDropOffAddress();
        //ReusableMethods.addAnotherDropOffAddress();
        ReusableMethods.choiceOfTransportAndRequestDeliveryWith("cheapest");
       // ReusableMethods.choiceOfTransportAndRequestDeliveryWith("nearest");
        String orderID = elements.deliveryDetailsPage().deliveryID.getText();
        ReusableMethods.deliveryStatusVerification();
        elements.deliveryDetailsPage().historyTab.click();
        Assert.assertEquals(elements.historyPage().orderIDList.get(0).getText(),orderID);
        System.out.println("Delivery is done successfully and validated by system.");
    }
}
