package pages;

import org.openqa.selenium.WebDriver;
import pages.basketPage.BasketPage;
import pages.billingDetailsPage.BillingDetailsPage;
import pages.mainPage.MainPage;
import pages.orderDetailsPage.OrderDetailsPage;

public class PageObjectManager {

    private WebDriver driver;
    private MainPage mainPage;
    private BasketPage basketPage;
    private BillingDetailsPage billingDetailsPage;
    private OrderDetailsPage orderDetailsPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage getMainPage() {
        return (mainPage == null) ? mainPage = new MainPage(driver) : mainPage;
    }

    public BasketPage getBasketPage() {
        return (basketPage == null) ? basketPage = new BasketPage(driver) : basketPage;
    }

    public BillingDetailsPage getBillingDetailsPage() {
        return (billingDetailsPage == null) ? billingDetailsPage = new BillingDetailsPage(driver) : billingDetailsPage;
    }

    public OrderDetailsPage getOrderDetailsPage() {
        return (orderDetailsPage == null) ? orderDetailsPage = new OrderDetailsPage(driver) : orderDetailsPage;
    }

}
