package pages.basketPage;

import org.openqa.selenium.By;
import webElements.Button;
import webElements.ElementList;
import webElements.TextBox;

public class BasketPageElement {

    public Button proceedToCheckout;
    public TextBox totalPrice;
    public ElementList productList;

    public BasketPageElement() {
        proceedToCheckout = new Button(By.cssSelector(".wc-proceed-to-checkout a"));
        totalPrice = new TextBox(By.cssSelector(".cart-subtotal .woocommerce-Price-amount"));
        productList = new ElementList(By.cssSelector(".cart_item"));
    }

}
