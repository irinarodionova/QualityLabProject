import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage {

    WebDriver driver;
    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//span[@class=\"compose-button__wrapper\"]")
    private WebElement buttonWriteLetter;
    @FindBy(xpath = "//div[@class=\"contacts--1ofjA\"]//input")
    private WebElement inputTo;
    @FindBy(xpath = "//div[@class=\"container--3QXHv\"]//input")
    private WebElement inputTopic;
    @FindBy (xpath = "//span[@class=\"button2__txt\" and text() = \"Отправить\"]")
    private WebElement buttonSendLetter;
    @FindBy (xpath = "//*[contains(text(),'отправлено')]")
    private WebElement emailSent;
    String textBoxXpath = "'//div[@role=\"textbox\"]/div/div[1]'";


    public InboxPage pushButtonWriteLetter(){
        buttonWriteLetter.click();
        return this;
    }

    public InboxPage inputEmailTo(String email){
        inputTo.sendKeys(email);
        return this;
    }

    public InboxPage inputTopicofLetter(String topic){
        inputTopic.sendKeys(topic);
        return this;
    }

    public InboxPage writeText (String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.evaluate("+textBoxXpath+", document, null, 9, null).singleNodeValue.innerHTML='"+ text+"'");
        return this;
    }

    public InboxPage pushSendButton(){
        buttonSendLetter.click();
        return this;
    }

    public boolean getEmailSentText(){
        return emailSent.isDisplayed();
    }


}



