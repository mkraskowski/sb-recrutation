package pages.orderDetailsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage extends OrderDetailsPageElement{

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getOrderDetailProductName() {
        return bookName.getText();
    }
    public int getOrderDetailProductlist() {
        return orderProduct.getListSize();
    }
    public String getOrderDetailsProductTotalPrice() {
        return orderProductTotalPrice.getText();
    }
    public String getOrderDetailsProductSubtotalPrice() {
        return orderProductSubtotalPrice.getText();
    }
    public String getOrderDetailsPaymentMethod() {
        return paymentMethod.getText();
    }

}
