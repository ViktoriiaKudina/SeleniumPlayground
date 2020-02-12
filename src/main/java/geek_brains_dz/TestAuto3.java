package geek_brains_dz;

import geek_brains_dz.actions.Clicks;
import geek_brains_dz.actions.GetElements;
import geek_brains_dz.actions.Waits;
import geek_brains_dz.blocks.Header;
import geek_brains_dz.blocks.Options;
import geek_brains_dz.pages.LoginPage;
import geek_brains_dz.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestAuto3 {

    public void test1() throws InterruptedException {
        Init init = new Init();
        WebDriver driver = init.getDriver();
        Clicks clicks = new Clicks();
        Locators locators = new Locators();

        Waits waits = new Waits(driver);

        driver.navigate().to("https://geekbrains.ru/");
        WebElement enterButton = init.getDriver().findElement(By.xpath(new Locators().enterButton));
        waits.waits().until(ExpectedConditions.elementToBeClickable(By.xpath(new Locators().enterButton)));
        clicks.click(enterButton, driver);
        waits.waitForPageToLoad();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmail.sendKeys(loginPage.getLoginGeekBrains());
        loginPage.loginPass.sendKeys(loginPage.getPasswordGeekBrains());
        loginPage.enterButtonGeek.click();
        clicks.click(loginPage.enterButtonGeek, driver);
        waits.waitForPageToLoad();
        new GetElements().getWebElement(driver, locators.coursesLink).click();
        waits.waitForPageToLoad();
        new GetElements().getWebElement(driver, locators.qaEngineer).click();
        waits.waitForPageToLoad();
    }

    // TODO wait for load page
    //JavascriptExecutor executor = (JavascriptExecutor) driver;
    // executor.executeScript("document.querySelector('body > header > div.header-top.js-header-top > div > div.header-auth > div > noindex > div.auth__links._logged-out > a.auth__link.js-auth-button._signin').click();");

    //new actions.Waits().waitForPageToLoad();


    public void test2() {
        Init init = new Init();

        WebDriver driver = init.getDriver();

        driver.navigate().to("https://www.championat.com/football/_worldcup/tournament/1589/statistic/player/bombardir/");

        new Waits(driver).waitForPageToLoad();

        try {
            WebElement element = getFirstOneCellByValueFromTable(driver, "Голы", "6");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private WebElement getFirstOneCellByValueFromTable(WebDriver driver, final String columnName, final String value) throws Exception {
        Waits waits = new Waits(driver);
        waits.waitForPageToLoad();
        List<WebElement> headers = waits.waitAndGetWebElements("//tr [@class = 'table-responsive__row']", Waits.MEDIUM_WAIT, Waits.POLLING_TIME);
        List<WebElement> cells = new ArrayList<>();
        for (int i = 1; i <= headers.size(); i++) {
            if (headers.get(i - 1).getText().equals(columnName)) {
                List<WebElement> cellsInColumn = waits.waitAndGetWebElements("//td [@data-label = 'Голы']", Waits.MEDIUM_WAIT, Waits.POLLING_TIME);
                cells = cellsInColumn.stream().filter((element) -> element.getText().equals(value)).collect(Collectors.toList());
                break;
            }
        }

        if (!cells.isEmpty()) {
            return cells.get(0);
        } else {
            throw new Exception("нет нужной ячейки");
        }
    }

    public void testMainPage() throws InterruptedException {
        Init init = new Init();
        WebDriver driver = init.getDriver();
        Locators locators = new Locators();
        Clicks clicks = new Clicks();

        Waits waits = new Waits(driver);

        driver.navigate().to("https://geekbrains.ru/");
        WebElement enterButton = init.getDriver().findElement(By.xpath(new Locators().enterWithGoogle));
        clicks.click(enterButton, driver);
        waits.waitForPageToLoad();
        MainPage mainPage = new MainPage(driver);
        mainPage.emailWithGoogle.sendKeys(mainPage.getLoginGeekBrains());
        mainPage.googleButtonNext.click();
        waits.waitForPageToLoad();
        mainPage.hiddenButtonPassInGoogle.click();
        mainPage.passWithGoogle.sendKeys(mainPage.getPasswordGeekBrains());
        mainPage.googleButtonNext.click();
        waits.waitForPageToLoad();
        new GetElements().getWebElement(driver, locators.whoPassedTest);
        waits.waitForPageToLoad();
        new GetElements().getWebElement(driver, locators.newComment);
        waits.waitForPageToLoad();
    }

    public void testHeaderCalendar() throws InterruptedException {
        Init init = new Init();
        WebDriver driver = init.getDriver();
        Locators locators = new Locators();
        Clicks clicks = new Clicks();

        Waits waits = new Waits(driver);

        driver.navigate().to("https://geekbrains.ru/");
        WebElement enterButton = init.getDriver().findElement(By.xpath(new Locators().enterWithGoogle));
        clicks.click(enterButton, driver);
        waits.waitForPageToLoad();
        MainPage mainPage = new MainPage(driver);
        mainPage.emailWithGoogle.sendKeys(mainPage.getLoginGeekBrains());
        mainPage.googleButtonNext.click();
        waits.waitForPageToLoad();
        mainPage.hiddenButtonPassInGoogle.click();
        mainPage.passWithGoogle.sendKeys(mainPage.getPasswordGeekBrains());
        mainPage.googleButtonNext.click();
        waits.waitForPageToLoad();

        Header header = mainPage.header;
        header.calendar.click();
        waits.waitForPageToLoad();
    }

    public void testOptions() throws InterruptedException {
        Init init = new Init();
        WebDriver driver = init.getDriver();
        Clicks clicks = new Clicks();

        Waits waits = new Waits(driver);

        driver.navigate().to("https://geekbrains.ru/");
        WebElement enterButton = init.getDriver().findElement(By.xpath(new Locators().enterWithGoogle));
        clicks.click(enterButton, driver);
        waits.waitForPageToLoad();
        MainPage mainPage = new MainPage(driver);
        mainPage.emailWithGoogle.sendKeys(mainPage.getLoginGeekBrains());
        mainPage.googleButtonNext.click();
        waits.waitForPageToLoad();
        mainPage.hiddenButtonPassInGoogle.click();
        mainPage.passWithGoogle.sendKeys(mainPage.getPasswordGeekBrains());
        mainPage.googleButtonNext.click();
        waits.waitForPageToLoad();

        Header header = mainPage.header;
        Options options = header.options;
        options.optionsButton.click();waits.waitForPageToLoad();
    }
}


