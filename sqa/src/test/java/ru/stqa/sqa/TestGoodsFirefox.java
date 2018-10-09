package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestGoodsFirefox {
    private WebDriver driver;

    public boolean isElement;


    @Before
    public void start () {
        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new FirefoxDriver(caps);

    }

    @Test
    public void TestGoods() {
        driver.get("http://localhost/litecart/en/");
        WebElement name = driver.findElement(By.cssSelector("div#box-campaigns a:first-child"));
        String text = name.getAttribute("title");
        WebElement price = name.findElement(By.cssSelector(".regular-price"));
        WebElement campaignPrice = name.findElement(By.cssSelector(".campaign-price"));
        String priceValue = price.getAttribute("textContent");
        String priceCampaignValue = campaignPrice.getAttribute("textContent");
        String priceColor = price.getCssValue("color");
        System.out.println(priceColor);
        String priceCampaignColor = campaignPrice.getCssValue("color");
        String priceSize = price.getAttribute("offsetHeight");
        String priceCompaignSize = campaignPrice.getAttribute("offsetHeight");
        testSizeOfPrice(priceSize, priceCompaignSize);
        testGreyColor(priceColor);
        testRedColor(priceCampaignColor);
        String priceDecoration = price.getTagName();
        String priceFont = campaignPrice.getTagName();

        strong(priceFont);
        decoration(priceDecoration);
        name.click();
        String textAfter = driver.findElement(By.cssSelector("h1.title")).getText();
        assertEquals(text, textAfter);
        WebElement priceAfter = driver.findElement(By.cssSelector("s.regular-price"));
        WebElement priceCompaignAfter = driver.findElement(By.cssSelector(".campaign-price"));
        String priceValueAfter = priceAfter.getAttribute("textContent");
        assertEquals(priceValue, priceValueAfter);
        String priceCampaignValueAfter = priceCompaignAfter.getAttribute("textContent");
        assertEquals(priceCampaignValue, priceCampaignValueAfter);
        priceDecoration = priceAfter.getTagName();
        priceFont = driver.findElement(By.cssSelector(".campaign-price")).getTagName();
        strong(priceFont);
        decoration(priceDecoration);
        priceColor = priceAfter.getCssValue("color");
        testGreyColor(priceColor);
        priceCampaignColor = priceCompaignAfter.getCssValue("color");
        testRedColor(priceCampaignColor);
        priceSize =  priceAfter.getAttribute("offsetHeight");
        priceCompaignSize = priceCompaignAfter.getAttribute("offsetHeight");
        testSizeOfPrice(priceSize, priceCompaignSize);
    }

    private void testSizeOfPrice(String priceSize, String priceCompaignSize) {
        int priceSizeInt = Integer.parseInt(priceSize);
        int priceCompaignSizeInt = Integer.parseInt(priceCompaignSize);
        if (priceCompaignSizeInt> priceSizeInt) {
            isElement = true;
        } else isElement = false;
        assertFalse(!isElement);
    }

    private void testRedColor(String priceCampaignColor) {
        String[] colorCompReds  = priceCampaignColor.split("\\)");
        String colorReds = colorCompReds[0];
        String[] compColorPrice = colorReds.split(", ");
        for (int k = 1; k<3; k++) {
            String reds = compColorPrice[k];
            int red = Integer.parseInt(reds);
            if (red == 0) {
                isElement = true;
            } else isElement = false;
            assertFalse(!isElement);
        }
    }

    private void testGreyColor(String priceColor) {
        String[] colorPrice  = priceColor.split("\\(");
        String colorGreys = colorPrice[1];
        String[] colorGrey  = colorGreys.split("\\)");
        String greyColor =  colorGrey[0];
        String[] grey = greyColor.split(", ");
        ArrayList<Integer> rgbaGreys = new ArrayList<>();
        for (int i=0; i<3; i++) {
            String rgbaGrey = grey[i];
            int rgbaGr = Integer.parseInt(rgbaGrey);

            rgbaGreys.add(Integer.valueOf(rgbaGr));

        }
        if (rgbaGreys.get(0) == rgbaGreys.get(1)) {
            isElement = true;
        } else isElement = false;
        if (rgbaGreys.get(0) == rgbaGreys.get(2)) {
            isElement = true;
        } else isElement = false;
        assertFalse(!isElement);
    }

    private void decoration(String priceDecoration) {
        if (priceDecoration.equals("s")) {
            isElement = true;
        } else isElement = false;
        assertFalse(!isElement);
    }

    private void strong(String priceFont) {
        if (priceFont.equals("strong")) {
            isElement = true;
        } else isElement = false;
        assertFalse(!isElement);
    }


    @After
    public void stop () {
        driver.quit();
        driver = null;
    }

}
