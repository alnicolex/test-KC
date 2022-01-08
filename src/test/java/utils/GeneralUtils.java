package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Selenium web driver overview class
 */
public class GeneralUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Class constructor
     * @param driver
     */
    public GeneralUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    /**
     * Check element
     * @param locator
     * @return
     */
    public Boolean existsElement(By locator){
        WebDriverWait waitClick = new WebDriverWait(this.driver, 10);
        waitClick.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        waitClick.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return this.driver.findElement(locator).isDisplayed();
    }

    /**
     * Enter value
     * @param locator
     * @param inputText
     */
    public void input(By locator, String inputText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }

    /**
     * Click elemento web
     * @param locator
     */
    public void click(By locator) {
        try {
            WebDriverWait waitClick = new WebDriverWait(this.driver, 10);
            waitClick.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            waitClick.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            waitClick.until(ExpectedConditions.elementToBeClickable(locator));
            this.driver.findElement(locator).click();
        } catch (StaleElementReferenceException var4) {
            WebDriverWait waitClick = new WebDriverWait(this.driver, 10);
            waitClick.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            waitClick.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            waitClick.until(ExpectedConditions.elementToBeClickable(locator));
            this.driver.findElement(locator).click();
        }
    }

}
