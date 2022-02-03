import browser.BrowserFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import static browser.BrowserFactory.setWebDriverNull;

public class BaseTest {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver();
        driver.get(BrowserFactory.prop.getProperty("url"));
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        //convert json file content to json string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),
                StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            BrowserFactory.driverQuit();
        }
        setWebDriverNull();
        // DriverSingletonClass.setInstance(null);
    }

}
