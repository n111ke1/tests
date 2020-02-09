package Tests;



import Helper.Configuration;
import Helper.ThreadDriver;
import Pages.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class BaseTest {

    static WebDriver driver = Configuration.getChromeDriver();


    static private String browserType = System.getProperty("Browser");




//    public void setUp() {
//
//    switch(browserType)
//
//    {
//        case "Chrome":
//
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




    public BasePage openPage(){
        driver.manage().timeouts().implicitlyWait(Configuration.getImplWait(), TimeUnit.MILLISECONDS);
        driver.get(Configuration.properties().getProperty("baseUrl"));
        ThreadDriver.setThreadDriver(driver);
        return new BasePage(driver);
    }





    @AfterEach
    public void tearDown() {
        driver.close();
    }



    }



