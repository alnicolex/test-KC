package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements and functionalities of the Product Detail page
 */
public class ProductPage {

    public By prdTitle = By.id("titleSection");
    public By btnAddCart = By.id("add-to-cart-button");

    private WebDriver driver;
    private GeneralUtils utils;

    /**
     * Constructor
     * @param driver
     */
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        utils = new GeneralUtils(this.driver);
    }

    /**
     * Check page
     * @return check
     */
    public Boolean loadPage(){
        return utils.isDisplayed(prdTitle);
    }


    /**
     * Check availability product
     * @return check
     */
    public Boolean checkAvailability(){
        return utils.isDisplayed(btnAddCart);
    }

    /**
     * Add to the cart
     */
    public void addToCart(){
        utils.click(btnAddCart);

    }
}
