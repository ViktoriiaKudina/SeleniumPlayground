import io.qameta.allure.Issue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainPageTest {

    private WebDriverSteps steps;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/resources/drivers/chrome/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        steps = new WebDriverSteps(new ChromeDriver(options));
    }

    @Test
    @Issue("ISSUE-1")
    public void searchTest() throws Exception {
        steps.openMainPage();
        steps.locateEnterButton();
        steps.makeScreenShot();
        steps.quit();
    }
}