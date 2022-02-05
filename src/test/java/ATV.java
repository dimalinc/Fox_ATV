import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePageFoxATV;

public class ATV extends BaseTest {

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger test1Logger = LogManager.getLogger(ATV.class);
    static final int delay = 900;


    @Test
    public void test() {
        //debug
        if (rootLogger.isDebugEnabled()) {
            rootLogger.debug("RootLogger: In debug message");
            test1Logger.debug("UserLogger in debug");
        }

        HomePageFoxATV homePage = new HomePageFoxATV();
        Assert.assertTrue(homePage.isOpen(), "HomePageFoxATV has not been opened");
        test1Logger.debug("opening HomePageFoxATV");

        homePage.getAcceptCoockies().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,950)", "");
        test1Logger.debug("scrolled down 950");

       /* homePage.getYearSelect().click();

        System.out.println("YEar selected =" + homePage.getYearSelect().getValue());
        System.out.println("homePage.getYearSelect().getAllOptionsFromSelect(); =");


        Assert.assertTrue(homePage.getMakeSelect().getText().length() > 0, "MakeSelect has no text");


        homePage.getMakeSelect().click();
        Assert.assertTrue(homePage.getModelSelect().getText().length() > 0, "ModelSelect has no text");

        homePage.getModelSelect().click();
        Assert.assertTrue(homePage.getModelSelect().getText().length() > 0, "PositionSelect has no text");

        homePage.getPositionSelect().click();*/



        // System.out.println("+++" + homePage.getYearSelect().getText());
        try {
            for (WebElement webElementYearItemOfList : homePage.getYearSelect().getAllOptionsFromSelect()) {
                webElementYearItemOfList.click();
                System.out.println(webElementYearItemOfList.getText());
                Thread.sleep(delay);
                try {
                    for (WebElement webElementMakeItemOfList : homePage.getMakeSelect().getAllOptionsFromSelect()) {

                        webElementMakeItemOfList.click();
                        System.out.println(webElementMakeItemOfList.getText());
                        Thread.sleep(delay);
                        try {
                            for (WebElement webElementModelItemOfList : homePage.getModelSelect().getAllOptionsFromSelect()) {
                                webElementModelItemOfList.click();
                                System.out.println(webElementModelItemOfList.getText());
                                Thread.sleep(delay);

                                try {
                                    for (WebElement webElementPositionItemOfList : homePage.getPositionSelect().getAllOptionsFromSelect()) {
                                        if (webElementPositionItemOfList.getText().equalsIgnoreCase("ALL")) {
                                            webElementPositionItemOfList.click();
                                       //     System.out.println(webElementPositionItemOfList.getText());
                                            Thread.sleep(delay);
                                            System.out.println(driver.getCurrentUrl());
                                        }
                                    }
                                } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                                    for (WebElement webElementPositionItemOfList : homePage.getPositionSelect().getAllOptionsFromSelect()) {
                                        if (webElementPositionItemOfList.getText().equalsIgnoreCase("ALL")) {
                                            webElementPositionItemOfList.click();
                                         //   System.out.println(webElementPositionItemOfList.getText());
                                            Thread.sleep(delay);
                                            System.out.println(driver.getCurrentUrl());
                                        }
                                    }
                                }
                            /*    try {
                                    homePage.getPositionSelect().getAllOptionsFromSelect().get(1).click();
                                } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                                    homePage.getPositionSelect().getAllOptionsFromSelect().get(1).click();
                                }*/
                            }
                        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                            for (WebElement webElementModelItemOfList : homePage.getModelSelect().getAllOptionsFromSelect()) {
                                webElementModelItemOfList.click();
                                System.out.println(webElementModelItemOfList.getText());
                                Thread.sleep(delay);
                            }
                        }
                    }
                } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                    for (WebElement webElementMakeItemOfList : homePage.getMakeSelect().getAllOptionsFromSelect()) {
                        webElementMakeItemOfList.click();
                        System.out.println(webElementMakeItemOfList.getText());
                        Thread.sleep(delay);
                    }
                }
            }
        } catch (Exception ex) {
            for (WebElement webElementYearItemOfList : homePage.getYearSelect().getAllOptionsFromSelect()) {
                try {
                    webElementYearItemOfList.click();
                    System.out.println(webElementYearItemOfList.getText());
                    Thread.sleep(delay);
                } catch (Exception e) {
                }
            }
        }











      /*  WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(homePage.getYearSelect().getLocator() + "/option[2]")));
*/
      /*  WebElement yearSelectOption1  = driver.findElement(By.xpath(homePage.getYearSelect().getLocator()+"/option[2]"));
        System.out.println( yearSelectOption1.getAttribute("text") );*/

        /*System.out.println("+++ +++" + homePage.getMakeSelect().getText());
        System.out.println("+++ +++ +++" + homePage.getModelSelect().getText());
        System.out.println("+++ +++ +++ +++" + homePage.getPositionSelect().getText());*/


        //   Assert.assertTrue(alertText.length() > 0,"alert text has zero length");


       /* homePage.getButton_alertsFrameAndWindows_alerts_onButtonClickConfirmBoxAppears().click();
        alertText=alert1.getAlert().getText();
        Assert.assertTrue(alertText.length() > 0,"alert text has zero length");
        alert1.getAlert().accept();
        test1Logger.debug(alertText + " click");


        homePage.getAlertsFrameAndWindows_alerts_onButtonClickPROMPTboxAppears().click();
        Assert.assertTrue(alertText.length() > 0,"alert text has zero length");
        alert1.sendRandomKeysToAlert();
        alert1.getAlert().accept();
        test1Logger.debug(alertText + " click");*/

    }


}


