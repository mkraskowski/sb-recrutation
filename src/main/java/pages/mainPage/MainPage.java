package pages.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends MainPageElement{

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getBookName() {
        return bookName.getText();
    }

    public void addBookToBasket() {
        addToBasketButton.click();
    }

    public void clickOnBasketButton() {
        confirmationAddedToBasket.isEnabled();
        basketButton.click();
    }
}
