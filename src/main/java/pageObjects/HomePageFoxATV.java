package pageObjects;

import elements.BaseElement;
import elements.basicelements.Button;
import elements.basicelements.Image;
import elements.basicelements.SeleniumSelect;
import org.openqa.selenium.By;

public class HomePageFoxATV extends BaseForm{
    public HomePageFoxATV() {
        super(uniqueElement, "HomePageFoxATV");
    }

    private static final BaseElement uniqueElement = new Image(By.xpath("/html/body/div[1]/div/section[1]/div/div[2]/a/img"),"FOX Logo");
    private static final SeleniumSelect YEAR_SELENIUM_SELECT = new SeleniumSelect(By.xpath("//*[@id=\"shockfinder-year\"]"),"Select Year");
    private static final SeleniumSelect MAKE_SELENIUM_SELECT = new SeleniumSelect(By.xpath("//*[@id=\"shockfinder-make\"]"),"Select Make");
    private static final SeleniumSelect MODEL_SELENIUM_SELECT = new SeleniumSelect(By.xpath("//*[@id=\"shockfinder-model\"]"),"Select Model");
    private static final SeleniumSelect POSITION_SELENIUM_SELECT = new SeleniumSelect(By.xpath("//*[@id=\"shockfinder-position\"]"),"Select Position");
    private static final Button acceptCoockies = new Button(By.xpath("//*[@id=\"acceptcookies\"]"),"Button acceptCoockies");


    public static BaseElement getUniqueElement() {
        return uniqueElement;
    }
    public static SeleniumSelect getYearSelect() {
        return YEAR_SELENIUM_SELECT;
    }
    public static SeleniumSelect getMakeSelect() {
        return MAKE_SELENIUM_SELECT;
    }
    public static SeleniumSelect getModelSelect() {
        return MODEL_SELENIUM_SELECT;
    }
    public static SeleniumSelect getPositionSelect() {
        return POSITION_SELENIUM_SELECT;
    }
    public static Button getAcceptCoockies() {
        return acceptCoockies;
    }
}
