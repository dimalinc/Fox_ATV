package elements.basicelements;

import browser.BrowserFactory;
import elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumSelect extends BaseElement  {
    public SeleniumSelect(By locator, String elementName) {
        super(locator, elementName);
    }

    public void selectOptionByIndex (int index){
        WebElement webElement = BrowserFactory.getDriver().findElement((locator));
        Select seleniumSelect = new Select(webElement);
        seleniumSelect.selectByIndex(index);
    }

    public List<WebElement> getAllOptionsFromSelect () {
        WebElement webElement = BrowserFactory.getDriver().findElement((locator));
        Select seleniumSelect = new Select(webElement);
        return seleniumSelect.getOptions();
    }

    public WebElement getSelectedOption() {
        WebElement webElement = BrowserFactory.getDriver().findElement((locator));
        Select seleniumSelect = new Select(webElement);
        return seleniumSelect.getFirstSelectedOption();
    }




}
