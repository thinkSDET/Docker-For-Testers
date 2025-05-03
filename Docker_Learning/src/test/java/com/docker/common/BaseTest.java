package com.docker.common;

import com.docker.util.Config;
import com.docker.util.Constants;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
// Abstract base Test -> but why?
public abstract class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver driver;

    @BeforeSuite
    public void setupConfig(){
        Config.initialize();
    }

    @BeforeTest
    public void setDriver(ITestContext ctx) throws MalformedURLException {
        this.driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
        ctx.setAttribute(Constants.DRIVER, this.driver);
    }

    /**
     * This method is responsible to create a driver for remote driver
     * @return
     * @throws MalformedURLException
     * @throws MalformedURLException
     */
    private WebDriver getRemoteDriver() throws MalformedURLException, MalformedURLException {
        Capabilities capabilities = new ChromeOptions();
        if(Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))){
            capabilities = new FirefoxOptions();
        }
        String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
        String hubHost = Config.get(Constants.GRID_HUB_HOST);
        String url = String.format(urlFormat, hubHost);
        log.info("grid url: {}", url);
        return new RemoteWebDriver(new URL(url), capabilities);
    }

    /**
     * This method is responsible to create a driver for local webDriver
     * @return
     */
    private WebDriver getLocalDriver(){
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }

}
