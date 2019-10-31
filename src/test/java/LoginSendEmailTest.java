import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginSendEmailTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private InboxPage inboxPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }


    @Test
    public void signInExistingUserTest() {
        loginPage = loginPage.inputUserLogin("autotestqa");
        loginPage = loginPage.pushEnterPasswordButton();
        loginPage = loginPage.inputUserPassword("testing098");
        inboxPage = loginPage.pushSubmitButton();

        inboxPage = inboxPage.pushButtonWriteLetter();
        inboxPage = inboxPage.inputEmailTo("autotestqa@mail.ru");
        inboxPage = inboxPage.inputTopicofLetter("autotestqa");
        inboxPage = inboxPage.writeText("autotestqa");
        inboxPage = inboxPage.pushSendButton();

        assert inboxPage.getEmailSentText();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
