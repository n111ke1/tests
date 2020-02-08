package Tests;



import Helper.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest extends Configuration {

    public  WebDriver driver ;


    @Before
    public void setUp() {


            ChromeOptions options = new ChromeOptions();
            options.addArguments("enable-automation");
//            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
//            options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess");
//            options.addArguments("disable-features=NetworkService");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);


            System.setProperty("webdriver.chrome.driver", readData().getProperty("pathToChromeDriver"));
            driver = new ChromeDriver(options);


//        System.setProperty("webdriver.chrome.logfile", "C:\\Users\\n111k\\IdeaProjects\\tests-new_test\\src\\main\\resources\\chromedriver.log");
//        System.setProperty("webdriver.chrome.verboseLogging", "true");


        driver.manage().timeouts().implicitlyWait(getImplWait(), TimeUnit.SECONDS);
        driver.get(readData().getProperty("baseUrl"));

    }




    @After
    public void tearDown() {
        driver.close();
    }



    }



