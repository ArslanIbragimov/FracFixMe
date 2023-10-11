package letscodeguide.FracFixMe.SeleniumTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractTest {


    private void useFirefoxDriver(WebDriver webDriver,String pathtodriver){
        webDriver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver", pathtodriver);

    }
    private void useChromeDriver(WebDriver webDriver, String pathtodriver){
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver",pathtodriver);
    }

    public AbstractTest(WebDriver webDriver, String pathtodriver){

        if(pathtodriver.contains(("chromium"))){
            useChromeDriver(webDriver,pathtodriver);
        } else if (pathtodriver.contains("gecko") || pathtodriver.contains("firefox")) {
            useFirefoxDriver(webDriver,pathtodriver);
        }
    }
    public abstract String outputTextXPath(String xpath);

    public abstract void fillForm();


}
