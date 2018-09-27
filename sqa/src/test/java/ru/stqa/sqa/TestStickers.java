package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertFalse;



public class TestStickers {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();


    }

    boolean areElementsPresent;



    @Test
    public void testStickers() {
        driver.get("http://localhost/litecart/");

        for (WebElement d : driver.findElements(By.cssSelector("li.product"))) {

            if (d.findElements(By.cssSelector("div.sticker")).size() == 1) {
                areElementsPresent = true;
            } else {
                areElementsPresent = false;
            }
            assertFalse(!areElementsPresent);
        }
    }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }
    }
