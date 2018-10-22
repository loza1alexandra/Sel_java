package ru.stqa.sqa.test;

import org.junit.Test;


public class TestBasket extends TestBase {


    @Test
    public void testBasket() {
        for (int i=0; i<3; i++) {
            app.addProductToBasket();
        }
            app.deleteFromBasket();
 }

}
