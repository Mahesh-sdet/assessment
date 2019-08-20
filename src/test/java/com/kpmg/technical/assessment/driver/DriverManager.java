package com.kpmg.technical.assessment.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class DriverManager {

    private String url = System.getProperty("url") == null ? "https://www.johnlewis.com/" : System.getProperty("url");
    private String browser = System.getProperty("browser") == null ? "" : System.getProperty("browser");

    protected static WebDriver driver;

    private static WebDriverWait wait;

    public DriverManager() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
    }

    public void navigateToUrl() {
        driver.navigate().to(url);
    }

    public void initialiseExplicitWait() {
        wait = new WebDriverWait(driver, 20);
    }

    public void maximiseBrowser() {
        driver.manage().window().maximize();
    }

    public void handlePrivacyMessage() {
        waitForClickableOfElement(driver.findElement(By.cssSelector("a[class^='privacy-message-close']"))).click();
    }

    public void closeBrower() {
        driver.quit();
    }

    public WebElement waitForVisiblityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForVisiblityOfText(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        return element;
    }

    protected WebElement waitForClickableOfElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This takes screenshot irrespective of test status
     */
    public void takeScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/target/screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException("Problem in taking screen shot.....");
        }
    }

    /**
     * This method will embed screen shot to cucumber.json in target directory
     * <p>
     * This will be used for cucumber UI Reports, and screen shot will be take only when test fails
     *
     * @param scenario
     */
    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        } catch (WebDriverException e) {
            throw new RuntimeException("Problem in taking screenshot" + scenario.getName());
        }
    }
}
