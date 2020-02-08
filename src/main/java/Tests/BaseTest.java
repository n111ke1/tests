package Tests;



import Helper.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class BaseTest {

    Properties properties = Configuration.properties();

    WebDriver driver;

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



    @Before
    public void setUp() {
        Configuration timeWait = new Configuration();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
//            options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess");
//            options.addArguments("disable-features=NetworkService");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        System.setProperty("webdriver.chrome.driver", properties.getProperty("pathToChromeDriver"));




//        System.setProperty("webdriver.chrome.logfile", "C:\\Users\\n111k\\IdeaProjects\\tests-new_test\\src\\main\\resources\\chromedriver.log");
//        System.setProperty("webdriver.chrome.verboseLogging", "true");


        driver.manage().timeouts().implicitlyWait(timeWait.getImplWait(), TimeUnit.SECONDS);

    }


    public void openPage(){

        driver.get(Configuration.properties().getProperty("baseUrl"));

    }





    @After
    public void tearDown() {

        driver.close();
    }



    }



