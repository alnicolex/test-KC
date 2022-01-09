package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements and functionalities of the search result page
 */
public class ResultPage {

    public By btnOrder = By.id("a-autoid-0-announce");
    public By paginator = By.xpath("//ul[@class=\"a-pagination\"]");

    private WebDriver driver;
    private GeneralUtils utils;


    /**
     * Class constructor
     * @param driver
     */
    public ResultPage(WebDriver driver) {
        this.driver = driver;
        utils = new GeneralUtils(this.driver);
    }


    /**
     * Check page
     * @return
     */
    public Boolean loadPage(){
        return utils.existsElement(btnOrder);
    }


    /**
     * Go to the paginator
     */
    public void goToPaginator(){
        utils.moveToElement(paginator);
    }

    /**
     * Click on page number
     * @param numPage
     * @return
     */
    public ResultPage clickNumPage(String numPage) {
        utils.click(By.xpath("//ul[@class=\"a-pagination\"]/li/a[contains(text(), '" + numPage + "')]"));
        return new ResultPage(driver);
    }


}
