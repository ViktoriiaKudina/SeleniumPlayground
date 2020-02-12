package geek_brains_dz.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Waits {

    public static final int SMALL_WAIT = 3;
    public static final int MEDIUM_WAIT = 10;
    public static final int LARGE_WAIT = 30;
    public static final int POLLING_TIME = 1;

    public static final int MULTIPLIER_FOR_MILLIS = 1_000;

    private static final String JAVASCRIPT_READY_STATE = "return document.readyState";
    private static final String JAVASCRIPT_READY_STATE_COMPLETE = "complete";

    private final WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait waits() {
        return new WebDriverWait(driver, MEDIUM_WAIT);
    }

    public long now() {
        return new Date().getTime();
    }

    public void staticWait(int pollingTime) {
        try {
            Thread.sleep((pollingTime * MULTIPLIER_FOR_MILLIS));
        } catch (InterruptedException inter) {

            System.out.println("проблема с потоком");
        }
    }

    public List<WebElement> waitAndGetWebElements(String xpath, int timeout, int pollingTime) {
        List<WebElement> webElements = new ArrayList<>();
        long startTime = now();
        while (((now() - startTime) / MULTIPLIER_FOR_MILLIS) < timeout) {
            try {
                webElements = driver.findElements(By.xpath(xpath));
            } catch (InvalidSelectorException e) {
                System.err.println("некорректный синтаксис локатора");
                throw e;
            }
            if ((!webElements.isEmpty()) && webElements.get(0).isEnabled()) {
                return webElements;
            }
            staticWait(pollingTime);
        }
        return webElements;
    }

    public void waitForPageToLoad() {
        long startTime = now();
        while (!((now() - startTime) > MEDIUM_WAIT)) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (js.executeScript(JAVASCRIPT_READY_STATE).equals(JAVASCRIPT_READY_STATE_COMPLETE)) {
                break;
            }
            staticWait(POLLING_TIME);
        }
    }
}
