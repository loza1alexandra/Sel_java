package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

        private WebDriver driver;
        private WebDriverWait wait;

        @Before
        public void start () {
            FirefoxOptions options = new FirefoxOptions().setLegacy(false);
            options.setProfile(new FirefoxProfile());
            options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
            driver = new FirefoxDriver(options);
            //caps.setCapability(FirefoxDriver.MARIONETTE, true);
            driver = new FirefoxDriver(options);
            wait = new WebDriverWait(driver, 10);
        }

    @Test
        public void myFirstTest() {
            driver.get ("https://www.google.ru/");
            driver.findElement(By.name("q")).sendKeys("webinar");
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
            wait.until(titleIs("webinar - Поиск в Google"));
        }

        @After
        public void stop () {
            driver.quit();
            driver = null;
        }
    }

