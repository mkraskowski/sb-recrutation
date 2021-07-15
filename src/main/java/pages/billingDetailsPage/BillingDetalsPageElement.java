package pages.billingDetailsPage;

import org.openqa.selenium.By;
import webElements.Button;
import webElements.ElementList;
import webElements.TextBox;

public class BillingDetalsPageElement {

    public TextBox firstName, lastName, email, phoneNumber, streetAdress, zipCode, townName, countryList, countrySearch, orderProductSubtotalPrice, orderProductTotalPrice, paymentMethod;
    public ElementList orderProduct;
    public Button placeOrder;

    public BillingDetalsPageElement() {
        firstName = new TextBox(By.cssSelector("input[id='billing_first_name']"));
        lastName = new TextBox(By.cssSelector("input[id='billing_last_name']"));
        email = new TextBox(By.cssSelector("input[id='billing_email']"));
        phoneNumber = new TextBox(By.cssSelector("input[id='billing_phone']"));
        streetAdress = new TextBox(By.cssSelector("input[id='billing_address_1']"));
        zipCode = new TextBox(By.cssSelector("input[id='billing_postcode']"));
        townName = new TextBox(By.cssSelector("input[id='billing_city']"));
        countryList = new TextBox(By.id("s2id_billing_country"));
        countrySearch = new TextBox(By.cssSelector("input#s2id_autogen1_search"));
        orderProductSubtotalPrice = new TextBox(By.cssSelector(".cart-subtotal .woocommerce-Price-amount"));
        orderProductTotalPrice = new TextBox(By.cssSelector(".order-total .woocommerce-Price-amount"));
        orderProduct = new ElementList(By.cssSelector("tr.cart_item"));
        paymentMethod = new TextBox(By.cssSelector("label[for='payment_method_bacs']"));
        placeOrder = new Button(By.id("place_order"));
    }

}
