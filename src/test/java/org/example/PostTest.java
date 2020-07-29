package org.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PostTest {
    public static LoginPage loginPage;
    public static InboxPage inboxPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        inboxPage = new InboxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void postTest() {
        loginPage.inputLogin(ConfProperties.getProperty("webtestsimbirsoft@gmail.com"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("webtestsimbirsoft666"));
        loginPage.clickPasswdBtn();
        inboxPage.clickInboxBtn();
        inboxPage.sendTxtArea();
        inboxPage.sendTxtSub();
        int theme = inboxPage.findInboxMes("Simbirsoft theme");
        inboxPage.sendTxtMes(theme);
        inboxPage.clickLastBtn();
    }
}