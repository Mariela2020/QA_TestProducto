package Runners;

import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManagerFactory {

    DesiredCapabilities capability=null;

    private DriverManagerFactory() {

    }

    private static DriverManagerFactory instance = new DriverManagerFactory();

    public static DriverManagerFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return null;
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public WebDriver setDriver(DriverType type) throws MalformedURLException {
        DriverManager driverManager = null;
        String osName = System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows";
        String driverPath = System.getProperty("user.dir") + "\\drivers\\";

        switch (type.toString()) {
            case "CHROME":
                if (osName.equals("windows")) {
                    //System.setProperty("webdriver.chrome.driver",driverPath + "chromedriver.exe");
                    capability = DesiredCapabilities.chrome();
                    capability.setBrowserName("chrome");
                    capability.setPlatform(Platform.ANY);

                } else {
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
                }
                //var chromeDriver = new RemoteWebDriver(new URL("http://192.168.42.189:30001"), new ChromeOptions());
                //driver.set(new RemoteWebDriver(new URL("http://172.17.0.7:5555"), new ChromeOptions()));
                driver.set(new RemoteWebDriver(new URL("http://localhost:30001/wd/hub"), capability));
                //driver.set(new ChromeDriver());

                break;

            case "FIREFOX":
                if (osName.equals("windows")) {
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                    //capability = DesiredCapabilities.firefox();
                    //capability.setBrowserName("firefox");
                    //capability.setPlatform(Platform.ANY);
                } else {
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver");
                }
                driver.set(new FirefoxDriver());
                //driver.set(new RemoteWebDriver(new URL("http://192.168.0.6:5567/wd/hub"), capability));
                break;

            case "EXPLORER":
                if (osName.equals("windows")) {
                }
                driver.set(new InternetExplorerDriver());
                break;

            case "EDGER":
                if (osName.equals("windows")) {
                    System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
                }
                driver.set(new EdgeDriver());
                break;

            case "OPERA":
                if (osName.equals("windows")) {
                    System.setProperty("webdriver.opera.driver", driverPath + "operadriver.exe");
                }
                driver.set(new OperaDriver());
                break;

            case "SAFARI":
                if(osName.equals("mac")) {
                    driver.set(new SafariDriver());
                    break;
                }

        }

        int i = 10;

        for (int j = 1; j <= i; i++) {
            try {
                driver.get().manage().window().maximize();
                break;
            } catch (WebDriverException we) {
                driver.set(new ChromeDriver());
                driver.get().manage().window().maximize();
            }
            if (i == j) {
                Assert.fail("Failed to Maximize windows" + j + "times");
            }
        }

        //driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.get();
    }

    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }

}
