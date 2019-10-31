import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id=\"mailbox:login\"]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@class=\"o-control\"and @type=\"submit\"]")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@id=\"mailbox:password\"]")
    private WebElement passwodrField;

    public LoginPage inputUserLogin (String login){
        loginField.sendKeys(login);
        return this;
    }
    public LoginPage pushEnterPasswordButton (){
        submitButton.click();
        return this;
    }

    public InboxPage pushSubmitButton (){
        submitButton.click();
        return PageFactory.initElements(driver, InboxPage.class);
    }

    public LoginPage inputUserPassword(String password){
        passwodrField.sendKeys(password);
        return this;
    }
}
