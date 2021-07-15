package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import enums.Context;
import org.junit.Assert;
import pages.basketPage.BasketPage;
import pages.billingDetailsPage.BillingDetailsPage;
import pages.mainPage.MainPage;
import pages.orderDetailsPage.OrderDetailsPage;

public class TestSteps {

    private TestContext testContext;
    private MainPage mainPage;
    private BasketPage basketPage;
    private BillingDetailsPage billingPage;
    private OrderDetailsPage orderDetailsPage;

    public TestSteps(TestContext context) {
        testContext = context;
        mainPage = testContext.getPageObjectManager().getMainPage();
        basketPage = testContext.getPageObjectManager().getBasketPage();
        billingPage = testContext.getPageObjectManager().getBillingDetailsPage();
        orderDetailsPage = testContext.getPageObjectManager().getOrderDetailsPage();
    }

    @Before
    public void beforeTest() {
        testContext.getDriverManager().setInitialConfiguration();
        testContext.getDriverManager().navigateToPage();
    }

    @After
    public void afterTest(){
        testContext.getDriverManager().closeDriver();
    }

    @Given("^User choose book and proceeding purchase operation$")
    public void stepsToBuyBook() {
        mainPage.addBookToBasket();
        testContext.getScenarioContext().setContext(Context.BASKET_PRODUCT_NAME, mainPage.getBookName());
        mainPage.clickOnBasketButton();
        testContext.getScenarioContext().setContext(Context.BASKET_SIZE, basketPage.getBasketSize());
        testContext.getScenarioContext().setContext(Context.BASKET_PRODUCT_SUBTOTAL_PRICE, basketPage.getBasketPrice());
        basketPage.clickOnProceedToCheckoutButton();
        billingPage.setFirstName();
        billingPage.setLastName();
        billingPage.setEmail();
        billingPage.setPhoneNumber();
        billingPage.clickOnCountryList();
        billingPage.setCountry("United Kingdom");
        billingPage.setStreetAdress();
        billingPage.setZipCode();
        billingPage.setTown();
        testContext.getScenarioContext().setContext(Context.ORDER_PRODUCT_SUBTOTAL_PRICE, billingPage.getOrderProductSubtotalPrice());
        testContext.getScenarioContext().setContext(Context.ORDER_PRODUCT_TOTAL_PRICE, billingPage.getOrderProductTotalPrice());
        testContext.getScenarioContext().setContext(Context.CHOSEN_PAYMENT_METHOD, billingPage.getChosenPaymentMethod());
        Assert.assertEquals("Basket size in basket page is different than in billing page", testContext.getScenarioContext().getContext(Context.BASKET_SIZE), billingPage.getOrderProductList());
        Assert.assertEquals("Basket subtotal price in basket page is different than in billing page", testContext.getScenarioContext().getContext(Context.BASKET_PRODUCT_SUBTOTAL_PRICE), testContext.getScenarioContext().getContext(Context.ORDER_PRODUCT_SUBTOTAL_PRICE));

    }

    @When("^Click on place order button$")
    public void stepToCreateOrder() {
        billingPage.clickOnPlaceOrderButton();
    }

    @Then("^Order details are correct$")
    public void assertOrderDetailFields(){
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.BASKET_SIZE), orderDetailsPage.getOrderDetailProductlist());
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.BASKET_PRODUCT_NAME), orderDetailsPage.getOrderDetailProductName());
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.ORDER_PRODUCT_SUBTOTAL_PRICE), orderDetailsPage.getOrderDetailsProductSubtotalPrice());
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.CHOSEN_PAYMENT_METHOD), orderDetailsPage.getOrderDetailsPaymentMethod());
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.ORDER_PRODUCT_TOTAL_PRICE), orderDetailsPage.getOrderDetailsProductTotalPrice());
    }
}
