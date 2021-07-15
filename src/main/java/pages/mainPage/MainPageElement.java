package pages.mainPage;

import org.openqa.selenium.By;
import webElements.Button;
import webElements.TextBox;

public class MainPageElement {

    public Button addToBasketButton, basketButton, confirmationAddedToBasket;
    public TextBox bookName;

    public MainPageElement() {
        addToBasketButton = new Button(By.cssSelector("div#text-22-sub_row_1-0-2-0-0 a[class*=add_to_cart_button]"));
        basketButton = new Button(By.cssSelector(".cartcontents"));
        confirmationAddedToBasket = new Button(By.cssSelector("#text-22-sub_row_1-0-2-0-0 .added"));
        bookName = new TextBox(By.cssSelector("div#text-22-sub_row_1-0-2-0-0 h3"));
    }
}
