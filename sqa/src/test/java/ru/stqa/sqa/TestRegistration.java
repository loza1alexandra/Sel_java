package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestRegistration {

    private WebDriver driver;
    private String password;
    private String mail;




    @Before
    public void start () {
        driver = new ChromeDriver();

    }

    public boolean isElementPresent (By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }



    @Test
    public void testRegistration() {

        int m = (int) (Math.random() * 100);
        mail = "mail" + m + "@mail.ru";
        password = "Qwerty1z1";
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("[name = login_form] a")).click();
        driver.findElement(By.cssSelector("[name = firstname]")).sendKeys("Ivan");
        driver.findElement(By.cssSelector("[name = lastname]")).sendKeys("Ivanov");
        driver.findElement(By.cssSelector("[name = address1]")).sendKeys("Blue street, 6");
        driver.findElement(By.cssSelector("[name = postcode]")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name = city]")).sendKeys("New York");
        driver.findElement(By.cssSelector(".select2-selection__rendered")).click();
        driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("United States" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement tdZones = driver.findElement(By.xpath("//td[contains(.,  'Zone/State/Province')]"));
        WebElement selectZones = tdZones.findElement(By.cssSelector("select"));
        Select n = new Select(selectZones);
       int k = (int) (Math.random() * 50);
        n.selectByIndex(k);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[name = email]")).sendKeys(mail);
        driver.findElement(By.cssSelector("[name = phone]")).sendKeys("+1789565622255");
        driver.findElement(By.cssSelector("[name = password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name = confirmed_password]")).sendKeys(password);

        driver.findElement(By.cssSelector("[name = create_account]")).click();
        if (isElementPresent(By.cssSelector(".notice.errors")) == true) {
            generateEmail();
            driver.findElement(By.cssSelector("[name = email]")).sendKeys(mail);
            driver.findElement(By.cssSelector("[name = password]")).sendKeys(password);
            driver.findElement(By.cssSelector("[name = confirmed_password]")).sendKeys(password);
            driver.findElement(By.cssSelector("[name = create_account]")).click();
        }

        driver.findElement(By.xpath("//a[contains(.,  'Logout')]")).click();
        driver.findElement(By.cssSelector("[name = email]")).sendKeys(mail);
        driver.findElement(By.cssSelector("[name = password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name = login]")).click();
        driver.findElement(By.xpath("//a[contains(.,  'Logout')]")).click();

    }

    private void generateEmail() {
        int m = (int) (Math.random() * 100);
        mail = "mail" + m + "mail@.ru";
    }


        @After
        public void stop () {
            driver.quit();
            driver = null;
        }



}
