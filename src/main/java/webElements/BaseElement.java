package webElements;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement<T> {

    private WebDriver driver = new DriverManager().getWebDriver();
    private final int TIME_OUT = 50;
    final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement waitUntilElementIsVisible() {
        return waitForVisibleElement();
    }

    public List<WebElement> waitUntilElementsAreVisible() {
        return waitForVisibleElements();
    }

    public WebElement waitUntilElementIsClickable() {
        return waitForClickableElement();
    }

    public void click() {
        waitUntilElementIsClickable().click();
    }

    public void isEnabled() {
        waitUntilElementIsVisible().isEnabled();
    }


    private WebDriverWait getWebDriverWait() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, TIME_OUT);
        return webDriverWait;
    }

    private WebElement waitForVisibleElement() {
        WebDriverWait webDriverWait = getWebDriverWait();
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private List<WebElement> waitForVisibleElements() {
        WebDriverWait webDriverWait = getWebDriverWait();
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    private WebElement waitForClickableElement() {
        WebDriverWait webDriverWait = getWebDriverWait();
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
