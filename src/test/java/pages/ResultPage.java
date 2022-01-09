package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements and functionalities of the search result page
 */
public class ResultPage {

    public By paginator = By.xpath("//ul[@class=\"a-pagination\"]");
    //public By products = By.xpath("//div[@data-component-type=\"s-search-result\"]");
    public  By products = By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]");



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
        return utils.isDisplayed(products);
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


    /**
     * select product by item number
     * @param item
     * @return
     */
    public ProductPage selectProductByNumber(int item){
        utils.clickOnNumberElement(products, item);
        return new ProductPage(driver);
    }


}
