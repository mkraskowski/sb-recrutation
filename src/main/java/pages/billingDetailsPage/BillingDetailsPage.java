package pages.billingDetailsPage;

import data.DataCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BillingDetailsPage extends BillingDetalsPageElement {

    public BillingDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private DataCreator dataCreator = new DataCreator();

    public void setFirstName() {
        firstName.setText(dataCreator.setRandomFirstName());
    }

    public void setLastName() {
        lastName.setText(dataCreator.setRandomLastName());
    }

    public void setEmail() {
        email.setText(dataCreator.setRandomEmail());
    }

    public void setPhoneNumber() {
        phoneNumber.setText(dataCreator.setRandomPhoneNumber());
    }

    public void setStreetAdress() {
        streetAdress.setText(dataCreator.setRandomAdress());
    }

    public void setZipCode() {
        zipCode.setText(dataCreator.setRandomZipcode());
    }

    public void setTown() {
        townName.setText(dataCreator.setRandomTown());
    }

    public void clickOnCountryList() {
        countryList.click();
    }

    public void setCountry(String country) {
        countrySearch.setText(country);
    }

    public int getOrderProductList() {
        return orderProduct.getListSize();
    }

    public String getOrderProductSubtotalPrice() {
        return orderProductSubtotalPrice.getText();
    }

    public String getOrderProductTotalPrice() {
        return orderProductTotalPrice.getText();
    }

    public String getChosenPaymentMethod(){
        return paymentMethod.getText();
    }

    public void clickOnPlaceOrderButton() {
        placeOrder.click();
    }
}
