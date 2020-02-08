package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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




    public long getImplWait(){
        String implWait = properties().getProperty("implicitlyWait");
        return Long.parseLong(implWait);
    }

//    public long getExplWait(){
//
//        String explicitlyWait = properties.getProperty("explicitlyWait");
//        return Long.parseLong(explicitlyWait);
//
//    }

    public WebDriver getChromeDriver(){


        return new ChromeDriver();
    }



    public WebDriver getFireFoxDriver(){



        return new FirefoxDriver();
    }





}
