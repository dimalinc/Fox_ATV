package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverSingletonClass {

    private static DriverSingletonClass instance;

    private  WebDriver driver;

    public WebDriver getDriver() {
        return  driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static void setInstance(DriverSingletonClass instance) {
        DriverSingletonClass.instance = instance;
    }

    private DriverSingletonClass() {
        driver = driverInit();
    }



    public static DriverSingletonClass getInstance() {
        if (instance == null) {
           instance = new DriverSingletonClass();
        }
        return instance;
    }

    private WebDriver driverInit() {
        Properties prop;
        prop = new Properties();
        try {
            FileInputStream fis =
                    new FileInputStream(".\\src\\main\\java\\utils\\params.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browserName = prop.getProperty("browser");

        switch (browserName) {

            case "chrome": {
                int windowHeight = Integer.parseInt(prop.getProperty("windowHeight"));
                int windowWidth = Integer.parseInt(prop.getProperty("windowWidth"));

                //Set up driver
                ChromeOptions options = new ChromeOptions();
                // ToDo: можно было использовать здесь String.format()
                options.addArguments("window-size=" + windowHeight + "," + windowWidth);
                options.setCapability("applicationCacheEnabled", false);
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(options);
            }

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void quitDriver() {
//   log
        driver.quit();
    }


    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


}
