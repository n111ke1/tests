package Helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class ElementActions {

    public static void waitElementPresent(WebElement el){
        WebDriverWait wait = new WebDriverWait(ThreadDriver.getWebDriver(),Configuration.getExplWait());
        wait.pollingEvery(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(el));

    }

    public static void waitElementsPresents(List<WebElement> el){
        WebDriverWait wait = new WebDriverWait(ThreadDriver.getWebDriver(),Configuration.getExplWait());
        wait.pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfAllElements(el));

    }

    public static void waitElementInvisible(WebElement el){
        WebDriverWait wait = new WebDriverWait(ThreadDriver.getWebDriver(),Configuration.getExplWait());
        wait.pollingEvery(Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(el));

    }

    public static void waitElementDisappear(WebElement el){
        WebDriverWait wait = new WebDriverWait(ThreadDriver.getWebDriver(),Configuration.getExplWait());
        wait.pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOf(el));

    }

    public static void ElementUnfocus(WebElement el){
        JavascriptExecutor js = (JavascriptExecutor) ThreadDriver.getWebDriver();
        js.executeScript("arguments[0].blur()", el);
    }

    public static void moveMouseToElement(WebElement el){
        waitElementPresent(el);
        Actions builder = new Actions(ThreadDriver.getWebDriver());
        builder.moveToElement(el).perform();

    }




}
