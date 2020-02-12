package geek_brains_dz.pages;

import geek_brains_dz.blocks.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private static final String LOGIN_GEEK_BRAINS = "teest@gmail.com";
    private static final String PASSWORD_GEEK_BRAINS = "test";

    @FindBy(xpath = "//*[@type='email']")
    public WebElement emailWithGoogle;

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    public WebElement googleButtonNext;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passWithGoogle;

    @FindBy(xpath = "//*[@class = 'stUf5b']")
    public WebElement hiddenButtonPassInGoogle;

    public Header header;


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLoginGeekBrains() {

        return LOGIN_GEEK_BRAINS;
    }

    public String getPasswordGeekBrains() {

        return PASSWORD_GEEK_BRAINS;
    }
}

