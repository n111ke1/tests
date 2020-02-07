package Tests;



import Helper.CustomChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver = null;

    public Properties properties;


    @BeforeMethod()
    public void setUp() throws IOException {
        properties.load(new FileReader("src/main/resources/data.properties"));

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


            System.setProperty("webdriver.chrome.driver", properties.getProperty("pathToChromeDriver"));
            driver = new ChromeDriver(options);


//        System.setProperty("webdriver.chrome.logfile", "C:\\Users\\n111k\\IdeaProjects\\tests-new_test\\src\\main\\resources\\chromedriver.log");
//        System.setProperty("webdriver.chrome.verboseLogging", "true");



        String implWait = properties.getProperty("implicitlyWait");

        driver.manage().timeouts().implicitlyWait(Long.parseLong(implWait), TimeUnit.SECONDS);
        driver.get(properties.getProperty("baseUrl"));

    }




    @AfterTest
    public void tearDown() {
        driver.close();
    }



    }



