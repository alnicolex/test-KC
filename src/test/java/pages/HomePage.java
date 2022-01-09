package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements and functionalities of the home page
 */
public class HomePage {

    public By txtSearch = By.id("twotabsearchtextbox");
    public By btnSearch = By.id("nav-search-submit-button");
    public By imgHome = By.id("nav-logo-sprites");

    private WebDriver driver;
    private GeneralUtils utils;

    /**
     * Class constructor
     * @param driver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        utils = new GeneralUtils(this.driver);
    }

    /**
     * Check page
     * @return
     */
    public Boolean loadPage(){
        return utils.isDisplayed(imgHome);
    }

    /**
     * Search for item and return search result
     * @param item
     * @return
     */
    public ResultPage searchItem(String item){
        utils.maximize();
        utils.input(txtSearch, item);
        utils.click(btnSearch);
        return new ResultPage(driver);
    }

}
