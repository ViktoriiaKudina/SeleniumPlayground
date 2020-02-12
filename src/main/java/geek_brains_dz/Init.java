package geek_brains_dz;

import geek_brains_dz.actions.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

public class Init {

    private static final String FIREFOX_TYPE = "firefox";
    private static final String CHROME_TYPE = "chrome";
    private static final String IE_TYPE = "ie";

    private static WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }

    public static void main(String[] args) {
        driver = initChromeDriver();
        setTimeouts(driver);
        try {
            startTests();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/resources/drivers/chrome/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        return new ChromeDriver(options);
    }

    private static void setTimeouts(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Waits.MEDIUM_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Waits.MEDIUM_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Waits.MEDIUM_WAIT, TimeUnit.SECONDS);
    }

    private static void startTests() throws InterruptedException {
        new WebDriverSteps(driver);
//        TestAuto3 tests = new TestAuto3();
//
//        try {
//            tests.testMainPage();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Thread.sleep(500);
//
//        tests.testHeaderCalendar();
//
//        Thread.sleep(500);
//
//        tests.testOptions();
    }

    private static void startFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "C:/resources/drivers/firefox/geckodriver.exe");

        ProfilesIni profile = new ProfilesIni();

        FirefoxProfile geekBrainsProfile = profile.getProfile("selenium");
        geekBrainsProfile.setPreference("browser.download.folderList", 2);
        geekBrainsProfile.setPreference("browser.download.manager.showWhenStarting", false);
        geekBrainsProfile.setPreference("browser.download.dir", "C:/Users/vikka/Desktop/");
        geekBrainsProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-gzip");
        geekBrainsProfile.setPreference("dom.webnotifications.enabled", false);
        geekBrainsProfile.setPreference("plugin.state.java", 2);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(geekBrainsProfile);

        FirefoxDriver driver = new FirefoxDriver(options);

        driver.get("https://geekbrains.ru/");
    }

    private static void startInternetExplorer() {
        System.setProperty("webdriver.ie.driver", "C:/resources/drivers/internet_explorer/IEDriverServer.exe");

        WebDriver driver = new InternetExplorerDriver();

        driver.navigate().to("https://geekbrains.ru/");
    }
}
