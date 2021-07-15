package pages.orderDetailsPage;

import org.openqa.selenium.By;
import webElements.ElementList;
import webElements.TextBox;

public class OrderDetailsPageElement {

    public TextBox bookName, orderProductSubtotalPrice, orderProductTotalPrice, paymentMethod;
    public ElementList orderProduct;

    public OrderDetailsPageElement(){
        bookName = new TextBox(By.cssSelector(".product-name a"));
        orderProduct = new ElementList(By.cssSelector("tr.order_item"));
        orderProductSubtotalPrice = new TextBox(By.cssSelector("div.woocommerce > table > tfoot > tr:nth-child(1) > td > span"));
        orderProductTotalPrice = new TextBox(By.cssSelector("div.woocommerce > table > tfoot > tr:nth-child(4) > td > span"));
        paymentMethod = new TextBox(By.cssSelector("div.woocommerce > table > tfoot > tr:nth-child(3) > td"));
    }
}
