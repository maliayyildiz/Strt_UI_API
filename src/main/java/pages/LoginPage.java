package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(tagName = "h1")
    public WebElement loginText;
    @FindBy(id = "email")
    public WebElement emailBox;
    @FindBy(id = "password")
    public WebElement passwordBox;
    @FindBy(id = "logInButton")
    public WebElement loginButton;
}
