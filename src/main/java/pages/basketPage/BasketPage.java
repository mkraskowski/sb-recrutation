package pages.basketPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasketPageElement {

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckout.click();
    }

    public int getBasketSize() {
        return productList.getListSize();
    }

    public String getBasketPrice() {
        return totalPrice.getText();
    }
}
