package ru.stqa.sqa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class TestSorting {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();


    }


    @Test
    public void testCountries() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
       int x = driver.findElements(By.cssSelector("tr.row")).size();
        ArrayList<String> countriesBefore = new ArrayList<>();
        ArrayList<String> countriesAfter = new ArrayList<>();
        String countryZonesValue;
        String countryName;
        WebElement country;
        WebElement hrefCountry;


        for (int i = 0; i<x; i++) {
            ArrayList<WebElement> tableCountries = new ArrayList<>(driver.findElements(By.cssSelector("tr.row")));
            WebElement rowCountries = tableCountries.get(i);
            ArrayList<WebElement> rowsCountries = new ArrayList<>(rowCountries.findElements(By.cssSelector("td")));
            WebElement countryZone = rowsCountries.get(5);
            countryZonesValue = countryZone.getText();
            country = rowsCountries.get(4);
            int y = Integer.parseInt(countryZonesValue);



            if (y>0) {
                hrefCountry = country.findElement(By.cssSelector("a"));
                hrefCountry.click();
                WebElement tableZones = driver.findElement(By.cssSelector(".dataTable"));
                ArrayList<WebElement> rowsZones = new ArrayList<>(tableZones.findElements(By.cssSelector(".tr")));
                ArrayList<String> zonesAfter = new ArrayList<>();
                ArrayList<String> zonesBefore = new ArrayList<>();
                for (WebElement zc : rowsZones) {
                    ArrayList<WebElement> zones = new ArrayList<>(zc.findElements(By.cssSelector("td")));
                    WebElement zoneCountry = zones.get(3);
                    String zoneCountryName = zoneCountry.getText();
                    zonesAfter.add(zoneCountryName);
                    zonesBefore.add(zoneCountryName);
                }
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }


            tableCountries = new ArrayList<>(driver.findElements(By.cssSelector("tr.row")));
            rowCountries = tableCountries.get(i);
            rowsCountries = new ArrayList<>(rowCountries.findElements(By.cssSelector("td")));
                country = rowsCountries.get(4);
                countryName = country.getText();
                countriesAfter.add(countryName);
                countriesBefore.add(countryName);

            Collections.sort(countriesAfter);
            Assert.assertEquals(countriesAfter, countriesBefore);
        }

    }

    @Test
    public void testZones () {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        ArrayList<WebElement> geoZones = new ArrayList<>(driver.findElements(By.cssSelector("tr.row")));
        int x = geoZones.size();
        for (int i = 0; i<x; i++) {
            WebElement zonesCountry = geoZones.get(i);
            ArrayList<WebElement> zoneCountry = new ArrayList<>(zonesCountry.findElements(By.cssSelector("td")));
            WebElement countryCell = zoneCountry.get(2);
            WebElement hrefCountry = countryCell.findElement(By.cssSelector("a"));
            hrefCountry.click();

            WebElement Zones = driver.findElement(By.cssSelector(".dataTable"));
            ArrayList<String> zonesAfter = new ArrayList<>();
            ArrayList<String> zonesBefore = new ArrayList<>();
            int a = Zones.findElements(By.cssSelector("tr:not([class=header]")).size();
            a = a-1;
            for (int k = 0; k<a; k++) {
                ArrayList<WebElement> zoneEdit = new ArrayList<>(Zones.findElements(By.cssSelector("tr:not([class=header]")));
                WebElement zon = zoneEdit.get(k);
                ArrayList<WebElement> zones = new ArrayList<>(zon.findElements(By.cssSelector("td")));
                WebElement zoneTd = zones.get(2);
                WebElement zone = zoneTd.findElement(By.cssSelector("[selected = selected]"));
                String zoneName = zone.getAttribute("text");
                zonesAfter.add(zoneName);
                zonesBefore.add(zoneName);
                Collections.sort(zonesAfter);
                Assert.assertEquals(zonesAfter, zonesBefore);

            }
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            geoZones = new ArrayList<>(driver.findElements(By.cssSelector("tr.row")));


        }

    }


    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}
