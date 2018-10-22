package ru.stqa.sqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddGoodsPage extends Page {
    public AddGoodsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div#box-most-popular a:first-child")
    public WebElement findGoods;

    @FindBy(css = "span.quantity")
    public WebElement count;

    @FindBy (xpath = "//button[contains(.,  'Add To Cart')]")
    public  WebElement addToCart;

    @FindBy (css = "select")
    public  WebElement selector;

    @FindBy (css = "option:not([selected]")
    public  WebElement toChoose;

    @FindBy (css = "select")
    public List<WebElement> selectors;

    public void selectSize () {
        driver.findElement(By.cssSelector("select")).click();
        driver.findElement(By.cssSelector("option:not([selected]")).click();
    }



}
