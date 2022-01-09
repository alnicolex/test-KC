package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
    public Boolean isDisplayed(By locator){
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            return this.driver.findElement(locator).isDisplayed();
        } catch (TimeoutException var) {
            return false;
        }
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
        waitForSeconds();
    }

    /**
     * Click elemento web
     * @param locator
     */
    public void click(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.driver.findElement(locator).click();
        waitForSeconds();
    }

    /**
     * Maximize display
     */
    public void maximize() {
        this.driver.manage().window().maximize();
    }


    /**
     * Move until the element is found
     * @param locator
     */
    public void moveToElement(By locator){
        WebElement e = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].scrollIntoView();", e);
        waitForSeconds();
    }

    /**
     * Wait for 2 seconds
     */
    public void waitForSeconds() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 2L, 1L);
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
        }
    }


    /**
     * Click on number of elements
     * @param item
     */
    public void clickOnNumberElement(By locator, int item){
        List<WebElement> products = findElements(locator);
        int n = 1;
        for (WebElement p : products)
        {
            System.out.println("item nro: " + n + "; product: " + p.getText());
            if(n == item){
                p.click();
                break;
            }
            n = n + 1;
        }
    }

    /**
     * Return list of elements
     * @param locator
     * @return
     */
    public List<WebElement> findElements(By locator) {
        return this.driver.findElements(locator);
    }

}
