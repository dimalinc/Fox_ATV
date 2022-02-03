package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {

    private static WebDriver driver;
    public static Properties prop;


    public static WebDriver getDriver() {
        if (driver == null)
           driver = initializeDriver();
        return driver;
    }

    public static void initProperties() {
        prop = new Properties();
        try {
            FileInputStream fis =
                    new FileInputStream(".\\src\\main\\java\\utils\\params.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static WebDriver initializeDriver() {

        initProperties();

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

    public static void driverQuit() {
        driver.quit();
    }

    public static void setWebDriverNull() {
        BrowserFactory.driver = null;
    }
}

