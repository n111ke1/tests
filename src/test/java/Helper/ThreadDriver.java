package Helper;

import org.openqa.selenium.WebDriver;

public class ThreadDriver {
    public  static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getWebDriver(){
        return threadDriver.get();
    }

    public static void setThreadDriver(WebDriver driver){
        threadDriver.set(driver);
    }

}
