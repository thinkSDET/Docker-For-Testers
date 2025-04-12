import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
// https://www.youtube.com/watch?v=daILiXCLom8&list=PL9ok7C7Yn9A9jiuK3iGfC6lFCQtxxD9sX&index=7
public class TestExecutionInDocker {

    /**
     *  I want to run my this test case in selenium standalone-chrome container.
     */
    @Test
    public void testOne(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(Browser.CHROME.browserName());
        try {
            WebDriver driver = new RemoteWebDriver(URI.create("http://localhost:8888").toURL(), capabilities);
            driver.get("https://demoqa.com/");
            System.out.println("This is my page title ->"+driver.getTitle());
            Thread.sleep(2000);
            driver.quit();
        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testTwo(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(Browser.CHROME.browserName());
        try {
            WebDriver driver = new RemoteWebDriver(URI.create("http://localhost:8888").toURL(), capabilities);
            driver.get("https://demoqa.com/");
            System.out.println("This is my page title ->"+driver.getTitle());
            Thread.sleep(2000);
            driver.quit();
        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
