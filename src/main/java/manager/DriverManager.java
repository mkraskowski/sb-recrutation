package manager;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static WebDriver driver;
    private static BrowserType browserType;
    private static String url;

    public DriverManager() {
        browserType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        url = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public void setInitialConfiguration() {
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().deleteAllCookies();
    }

    public void navigateToPage() {
        getWebDriver().navigate().to(url);
    }

    public void closeDriver() {
        driver.close();
    }

    private static WebDriver createDriver() {
        switch (browserType) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }
        return driver;
    }
}
