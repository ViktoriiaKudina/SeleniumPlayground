package geek_brains_dz;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSteps {

    private static final String JAVASCRIPT_READY_STATE = "return document.readyState";
    private static final String JAVASCRIPT_READY_STATE_COMPLETE = "complete";

    private WebDriver driver;

    public WebDriverSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void openMainPage() {
        driver.get("https://geekbrains.ru/");
    }

    @Step
    public void locateEnterButton() {
        WebElement enterButton = driver.findElement(By.xpath(new Locators().enterButton));

        Assert.assertTrue(enterButton.isDisplayed());

        new WebDriverWait(driver, 10)
                .withMessage("Could not load results page")
                .until(driver -> {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    return js.executeScript(JAVASCRIPT_READY_STATE).equals(JAVASCRIPT_READY_STATE_COMPLETE);
                });
    }

    @Attachment
    @Step("Make screen shot of results page")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step
    public void quit() {
        driver.quit();
    }
}