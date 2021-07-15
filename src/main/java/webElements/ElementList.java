package webElements;

import org.openqa.selenium.By;

public class ElementList extends BaseElement<ElementList> {

    public ElementList(By locator) {
        super(locator);
    }

    public int getListSize() {
        return waitUntilElementsAreVisible().size();
    }

}
