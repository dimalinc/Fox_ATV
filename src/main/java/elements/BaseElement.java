package elements;


import browser.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger test1Logger = LogManager.getLogger(BaseElement.class);

    protected By locator;

    public String getElementName() {
        return elementName;
    }

    protected String elementName;

    public BaseElement(By locator, String elementName) {
        test1Logger.info("created " + elementName);
        this.locator = locator;
        this.elementName = elementName;
    }

    public String getValue() {
        return BrowserFactory.getDriver().findElement(locator).getAttribute("value");
    }

    public By getLocator() {
        return locator;
    }

    protected WebElement findElement() {
        return BrowserFactory.getDriver().findElement(locator);
    }

    public void click() {
        test1Logger.info("clicked " + elementName);
        findElement().click();
    }


    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public String getText() {
        return findElement().getText();
    }

    public void enterText(String text) {
        findElement().sendKeys(text);
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }


}
