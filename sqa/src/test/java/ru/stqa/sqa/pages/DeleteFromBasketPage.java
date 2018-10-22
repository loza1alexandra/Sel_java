package ru.stqa.sqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeleteFromBasketPage extends Page {

    public DeleteFromBasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openN () {
        driver.get("http://localhost/litecart/en/checkout");
        //return this;
    }
@FindBy (css = ".dataTable .item:not([class=header]")
public List<WebElement> goods;


    @FindBy (xpath = "//button[contains(.,  'Remove')]")
    public WebElement remove;


}
