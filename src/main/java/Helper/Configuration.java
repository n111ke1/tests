package Helper;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.Properties;

public class Configuration {



    public static Properties properties() {
        String filePath = "src/main/resources/data.properties";
        Properties prop = null;
        try (InputStream input = new FileInputStream(filePath)) {
            prop = new Properties();
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();

        }

        return prop;
    }




//        InputStream reader = null;
//
//        try {
//            new FileInputStream(filePath);
//
////            reader = new FileReader("src/main/resources/data.properties");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Configuration.properties not found at " + reader);
//        }
//            properties.load(reader);
//




    public static long getImplWait(){
        String implWait = properties().getProperty("implicitlyWait");
        return Long.parseLong(implWait);
    }

//    public long getExplWait(){
//
//        String explicitlyWait = properties.getProperty("explicitlyWait");
//        return Long.parseLong(explicitlyWait);
//
//    }

    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", properties().getProperty("pathToChromeDriver"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);






//        System.setProperty("webdriver.chrome.logfile", "C:\\Users\\n111k\\IdeaProjects\\tests-new_test\\src\\main\\resources\\chromedriver.log");
//        System.setProperty("webdriver.chrome.verboseLogging", "true");


//


        return new ChromeDriver(options);
    }



    public WebDriver getFireFoxDriver(){



        return new FirefoxDriver();
    }





}
