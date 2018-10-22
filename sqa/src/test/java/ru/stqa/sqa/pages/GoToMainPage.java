package ru.stqa.sqa.pages;

import org.openqa.selenium.WebDriver;

public class GoToMainPage extends Page {
    public GoToMainPage(WebDriver driver) {
        super(driver);
    }

    public void open () {
        driver.get("http://localhost/litecart/en/");
    }
}
