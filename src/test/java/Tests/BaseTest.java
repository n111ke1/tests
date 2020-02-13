package Tests;

import Helper.Configuration;
import Helper.ThreadDriver;
import Pages.BasePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;



import java.util.concurrent.TimeUnit;


public class BaseTest {

   WebDriver driver = Configuration.getChromeDriver();


//    @BeforeMethod()
//    public WebDriver setUp() {
//        switch(Configuration.properties().getProperty("Browser"))
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




    @AfterTest
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }




    }



