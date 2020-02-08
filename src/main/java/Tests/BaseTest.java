package Tests;



import Helper.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class BaseTest {

    WebDriver driver = Configuration.getChromeDriver();


    static private String browserType = System.getProperty("Browser");




//    public void setUp() {
//
//    switch(browserType)
//
//    {
//        case "Chrome":
//            System.setProperty("webdriver.chrome.driver", properties.getProperty("pathToChromeDriver"));
//            break;
//
//            case "FireFox":
//
//
//            break;
//        default:  throw new IllegalArgumentException("Incorrect browse type");
//    }
//
//
//}





    public void openPage(){
        driver.manage().timeouts().implicitlyWait(Configuration.getImplWait(), TimeUnit.MILLISECONDS);
        driver.get(Configuration.properties().getProperty("baseUrl"));

    }





    @After
    public void tearDown() {

        driver.close();
    }



    }



