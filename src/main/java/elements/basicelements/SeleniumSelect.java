package elements.basicelements;

import browser.BrowserFactory;
import elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumSelect extends BaseElement  {
    public SeleniumSelect(By locator, String elementName) {
        super(locator, elementName);
    }

    public void selectOptionByIndex (int index){
        WebElement webElement = BrowserFactory.getDriver().findElement((locator));
        Select seleniumSelect = new Select(webElement);
        seleniumSelect.selectByIndex(index);
    }


}
