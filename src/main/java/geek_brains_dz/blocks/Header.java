package geek_brains_dz.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    @FindBy(xpath = "//*[@id='icon-schedule']")
    public WebElement calendar;

    public Options options;

    public Header(WebDriver driver) {
        this.options = new Options(driver);
        PageFactory.initElements(driver, this);
    }
}

