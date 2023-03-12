package Zadanie2Other;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class Zadanie2OtherTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
    }
    @After
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void shoppItem() throws IOException {
        MainPage mainPage = new MainPage(driver);
        mainPage.signInButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.SignIn("aaaaa.bbbb@ccc.com", "Pass123");
        signInPage.HomePage();

        SignedHomePage signedHomePage = new SignedHomePage(driver);
        signedHomePage.addItem();

        ItemPage itemPage = new ItemPage(driver);
        itemPage.choosingItemSize("M");
        itemPage.choosingQuantity(5);
        itemPage.addToCart();
        itemPage.proceedButton();
        itemPage.proceedButton2();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.confirmAddress();
        orderConfirmationPage.confirmDelivery();
        orderConfirmationPage.paymentOption();
        orderConfirmationPage.conditionsApprove();
        orderConfirmationPage.paymentConfirmation();
        orderConfirmationPage.takeScreenshot(driver, "report/Screenshots/screenshots");
    }


}
