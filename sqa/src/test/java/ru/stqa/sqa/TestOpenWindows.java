package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class TestOpenWindows {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @Test

    public void testOpenWindow() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//a[contains(.,  'Add New Country')]")).click();
        ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.cssSelector("form [target= _blank]")));
        int x = links.size();
        for (int i = 0; i<x; i++) {
            String mainWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            links.get(i).click();
            wait.until(numberOfWindowsToBe(i+2));
            String newWindow = thereIsWindowOtherThan (oldWindows);
            driver.switchTo().window(newWindow);
            driver.switchTo().window(mainWindow);

            }
        }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestOpenWindows that = (TestOpenWindows) o;
        return Objects.equals(driver, that.driver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(driver);
    }

    public String thereIsWindowOtherThan(Set<String> oldWindows) {
        Set<String> oldWindowsAfter = driver.getWindowHandles();
        for (String window : oldWindowsAfter) {
            if (window.hashCode() != oldWindows.hashCode()){
                return window;
            }
        }
        return null;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


}

