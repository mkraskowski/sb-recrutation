package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends BaseElement<TextBox> {

    public TextBox(By locator) {
        super(locator);
    }

    public void setText(String text) {
        waitUntilElementIsClickable().click();
        waitUntilElementIsClickable().clear();
        //This methods are separate because they not working correctly as one method in firefox
        waitUntilElementIsClickable().sendKeys(text);
        waitUntilElementIsClickable().sendKeys(Keys.TAB);
    }

    public String getText() {
        return waitUntilElementIsVisible().getText();
    }

}
