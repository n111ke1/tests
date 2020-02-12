package Tests;


import Helper.Configuration;
import Helper.ThreadDriver;
import Pages.BasePage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNull;


public class BaseTest {


   public static WebDriver driver = Configuration.getChromeDriver();



//    public WebDriver setUp() {
//
//        switch(Configuration.properties().getProperty("Browser"))
//
//    {
//            case "Chrome":
//             Configuration.getChromeDriver();
//            break;
//
//            case "FireFox":
//                Configuration.getFireFoxDriver();
//            break;
//        default:  throw new IllegalArgumentException("Incorrect browse type");
//    }
//    return driver;
//
//}




    public BasePage openPage(){
        driver.manage().timeouts().implicitlyWait(Configuration.getImplWait(), TimeUnit.SECONDS);
        driver.get(Configuration.properties().getProperty("baseUrl"));
        ThreadDriver.setThreadDriver(driver);
        return new BasePage(driver);
    }




    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }




    }



