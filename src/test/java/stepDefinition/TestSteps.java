package stepDefinition;

import cucumber.api.Scenario;
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
    private Scenario scenario;

    public TestSteps(TestContext context) {
        testContext = context;
        mainPage = testContext.getPageObjectManager().getMainPage();
        basketPage = testContext.getPageObjectManager().getBasketPage();
        billingPage = testContext.getPageObjectManager().getBillingDetailsPage();
        orderDetailsPage = testContext.getPageObjectManager().getOrderDetailsPage();
    }

    @Before
    public void beforeTest(Scenario scenario) {
        this.scenario = scenario;
        testContext.getDriverManager().setInitialConfiguration();
        testContext.getDriverManager().navigateToPage();
    }

    @After
    public void afterTest(){
        testContext.getDriverManager().closeDriver();
    }

    @Given("^User choose book and proceeding purchase operation$")
    public void stepsToBuyBook() {
        scenario.write("Add new book to basket");
        mainPage.addBookToBasket();
        testContext.getScenarioContext().setContext(Context.BASKET_PRODUCT_NAME, mainPage.getBookName());
        scenario.write("Go to basket page");
        mainPage.clickOnBasketButton();
        testContext.getScenarioContext().setContext(Context.BASKET_SIZE, basketPage.getBasketSize());
        testContext.getScenarioContext().setContext(Context.BASKET_PRODUCT_SUBTOTAL_PRICE, basketPage.getBasketPrice());
        scenario.write("Confirm basket");
        basketPage.clickOnProceedToCheckoutButton();
        scenario.write("Set order information");
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
        scenario.write("Assert that products list form basket page is equals in billing page");
        Assert.assertEquals("Basket size in basket page is different than in billing page", testContext.getScenarioContext().getContext(Context.BASKET_SIZE), billingPage.getOrderProductList());
        Assert.assertEquals("Basket subtotal price in basket page is different than in billing page", testContext.getScenarioContext().getContext(Context.BASKET_PRODUCT_SUBTOTAL_PRICE), testContext.getScenarioContext().getContext(Context.ORDER_PRODUCT_SUBTOTAL_PRICE));

    }

    @When("^Click on place order button$")
    public void stepToCreateOrder() {
        scenario.write("Set order information");
        billingPage.clickOnPlaceOrderButton();
    }

    @Then("^Order details are correct$")
    public void assertOrderDetailFields(){
        scenario.write("Assert basket size");
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.BASKET_SIZE), orderDetailsPage.getOrderDetailProductlist());
        scenario.write("Assert order book name");
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.BASKET_PRODUCT_NAME), orderDetailsPage.getOrderDetailProductName());
        scenario.write("Assert subtotal price");
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.ORDER_PRODUCT_SUBTOTAL_PRICE), orderDetailsPage.getOrderDetailsProductSubtotalPrice());
        scenario.write("Assert payment method");
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.CHOSEN_PAYMENT_METHOD), orderDetailsPage.getOrderDetailsPaymentMethod());
        scenario.write("Assert total price");
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.ORDER_PRODUCT_TOTAL_PRICE), orderDetailsPage.getOrderDetailsProductTotalPrice());
    }
}
