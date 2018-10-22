package ru.stqa.sqa.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.sqa.pages.AddGoodsPage;
import ru.stqa.sqa.pages.DeleteFromBasketPage;
import ru.stqa.sqa.pages.GoToMainPage;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class Application {
    private WebDriver driver;
    private WebDriverWait wait;
    private AddGoodsPage addGoodsPage;
    private DeleteFromBasketPage deleteGoods;
    private GoToMainPage openPage;

    public Application () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        addGoodsPage = new AddGoodsPage(driver);
        deleteGoods = new DeleteFromBasketPage(driver);
        openPage = new GoToMainPage(driver);

    }
    public void quit() {
        driver.quit();
    }




    public void addProductToBasket() {
       openPage.open();
        addGoodsPage.findGoods.click();
        if (addGoodsPage.selectors.size() > 0) {
        addGoodsPage.selectSize();
       }
        WebElement quantityItem = addGoodsPage.count;
        String item = quantityItem.getText();
        int itemInt = Integer.parseInt(item);
        itemInt = itemInt +1;
        String itemNew = Integer.toString(itemInt);

        addGoodsPage.addToCart.click();
        wait.until(textToBePresentInElement(quantityItem, itemNew));
    }

    public void deleteFromBasket() {
       deleteGoods.open();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int j = deleteGoods.goods.size();
        j = j-1;
        for (int k = 0; k < j; k++) {
            List<WebElement> products = deleteGoods.goods;
            deleteGoods.remove.click();
            wait.until(ExpectedConditions.stalenessOf(products.get(1)));
        }
    }


}
