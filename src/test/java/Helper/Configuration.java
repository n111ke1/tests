package Helper;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.*;
import java.util.Properties;

public class Configuration {



    public static Properties properties() {
        String filePath = "src/test/resources/data.properties";
        Properties prop = null;
        try (InputStream input = new FileInputStream(filePath)) {
            prop = new Properties();
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();

        }

        return prop;
    }



    public static long getImplWait(){
        String implWait = properties().getProperty("implicitlyWait");
        return Long.parseLong(implWait);
    }

    public static long getExplWait(){

        String explicitlyWait = properties().getProperty("explicitlyWait");
        return Long.parseLong(explicitlyWait);

    }

    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", properties().getProperty("pathToChromeDriver"));
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        System.setProperty("webdriver.chrome.logfile", "src/test/resources/Logs.log");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
//        options.addArguments("--headless");
        options.addArguments("--window-size=500,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return new ChromeDriver(options);
    }


//    System.setProperty("webdriver.chrome.logfile", "C:\\Users\\n111k\\IdeaProjects\\tests-new_test\\src\\main\\resources\\Logs.log");
//        System.setProperty("webdriver.chrome.verboseLogging", "true");



    public static WebDriver getFireFoxDriver(){
        System.setProperty("webdriver.gecko.driver", properties().getProperty("pathToFirefoxDriver"));


        return new FirefoxDriver();
    }





}
