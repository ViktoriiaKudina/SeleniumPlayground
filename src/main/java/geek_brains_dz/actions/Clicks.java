package geek_brains_dz.actions;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Clicks {

    public void click(WebElement element, WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        boolean isClicked = false;
        Waits waits = new Waits(driver);
        long startTime = waits.now();
        while (((waits.now() - startTime) / Waits.MULTIPLIER_FOR_MILLIS) < Waits.MEDIUM_WAIT) {
            try {
                Assert.assertTrue(element.isDisplayed());
                actions.moveToElement(element).build().perform();
                executor.executeScript("arguments[0].scrollIntoView();", element);
                executor.executeScript("arguments[0].focus();", element);
                executor.executeScript("arguments[0].click();", element);
                isClicked = true;
                break;
            } catch (Exception e) {
                System.out.println("клик не отработал с первого раза - даю повторный клик");
            }
            Thread.sleep(500);
        }
        Assert.assertTrue("клика не было", isClicked);
    }
}
