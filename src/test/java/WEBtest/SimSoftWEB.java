package com.WEBtest;

public class SimSoftWEB  {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://mycompany.site.com");
        By elementLocator = By.id("#element_id");
        WebElement element = driver.findElement(elementLocator);
        element.click();
        assertEquals("Webpage expected title", driver.getTitle());
        driver.quit();
}