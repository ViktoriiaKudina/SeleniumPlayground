package geek_brains_dz.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetElements {
    public WebElement getWebElement (WebDriver driver, String xpath){
        return new Waits(driver).waitAndGetWebElements(xpath, Waits.MEDIUM_WAIT, Waits.POLLING_TIME).get(0);
    }
}
