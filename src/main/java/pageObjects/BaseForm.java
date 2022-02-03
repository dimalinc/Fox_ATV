package pageObjects;

import elements.BaseElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class BaseForm {
    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger test1Logger = LogManager.getLogger(BaseElement.class);

    BaseElement uniqueElement;
    String pageName;

    public BaseForm(BaseElement uniqueElement, String pageName) {
        test1Logger.info("CREATED page " + pageName);
        this.uniqueElement = uniqueElement;
        this.pageName = pageName;
    }

    public boolean isOpen() {
        return uniqueElement.isDisplayed();
    }
}
