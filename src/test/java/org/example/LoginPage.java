package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//*[contains(@id, 'identifierId')]")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/div[2]")
    private WebElement loginBtn;
    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwdField;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/div[2]")
    private WebElement passwdBtn;

    public void inputLogin(String login) {
        loginField.sendKeys("webtestsimbirsoft@gmail.com"); }
    public void inputPasswd(String passwd) {
        passwdField.sendKeys("webtestsimbirsoft666"); }
    public void clickLoginBtn() {
        loginBtn.click(); }
    public void clickPasswdBtn() {
        passwdBtn.click(); }
}