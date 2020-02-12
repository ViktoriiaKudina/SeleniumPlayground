package geek_brains_dz.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Options {

    @FindBy(xpath = "//*[@class='svg-icon icon-more-icon']")
    public WebElement optionsButton;

    public Options(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

