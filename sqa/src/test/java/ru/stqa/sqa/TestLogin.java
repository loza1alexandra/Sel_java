package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start () {
        driver = new ChromeDriver();

    }

    @Test
    public void TestLogin() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("login")).click();

    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}

