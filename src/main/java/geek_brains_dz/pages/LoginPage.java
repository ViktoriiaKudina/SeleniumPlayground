package geek_brains_dz.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private static final String LOGIN_GEEK_BRAINS = "";
    private static final String PASSWORD_GEEK_BRAINS = "";

    @FindBy(xpath = "//*[@name = 'user[email]']")
    public WebElement loginEmail;

    @FindBy(xpath = "//*[@name = 'user[password]']")
    public WebElement loginPass;

    @FindBy(xpath = "//*[@value='Войти']")
    public WebElement enterButtonGeek;

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getLoginGeekBrains() {
        return LOGIN_GEEK_BRAINS;
    }

    public String getPasswordGeekBrains() {
        return PASSWORD_GEEK_BRAINS;
    }
}
