package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;


public enum DriverType  {

    FIREFOX {
        public FirefoxDriver getDriver() {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            return new FirefoxDriver(capabilities);
        }
    },
    CHROME {
        public ChromeDriver getDriver() {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
            HashMap<String, String> chromePreferences = new HashMap<String, String>();
            chromePreferences.put("profile.password_manager_enabled", "false");
            capabilities.setCapability("chrome.prefs", chromePreferences);
            File chromeDriverFile = new File("./src//main//recources//chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
            return new ChromeDriver(capabilities);
        }
    };

    public abstract WebDriver getDriver();

}