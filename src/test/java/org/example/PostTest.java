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
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage")); }

    @Test
    public void postTest() {
        loginPage.inputLogin(ConfProperties.getProperty("webtestsimbirsoft@gmail.com"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("webtestsimbirsoft666"));
        loginPage.clickPasswdBtn();

        driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
        WebElement to = driver.findElement(By.xpath("//textarea[@name='to']"));
        to.sendKeys("webtestsimbirsoft@gmail.com");
        WebElement sub = driver.findElement(By.xpath("//input[@name='subjectbox']"));
        sub.sendKeys("Simbirsoft theme");

        List<WebElement> Theme = driver.findElements(By.xpath("//table/tbody/tr/td/div/div/div/span[@class='bog']/span"));
        int theme = 0;

            for(int i=0; i < Theme.size(); i++) {
                if (Theme.get(i).getText().equals("Simbirsoft theme")) {
                    theme++;
                }
            }

        System.out.println(theme);


        WebElement txt = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"));
        txt.sendKeys("Найдено писем: " + theme);

        driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();
    } }