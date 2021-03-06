package test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StepsPurchaseTest {

    private WebDriver driver;
    private HomePage pageHome;
    private ResultPage pageResult;
    private ProductPage pageProduct;


    @Before
    /**
     *  Instance Webdriver
     */
    public void starTest(){

        // Chrome
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            pageHome = new HomePage(driver);
            return;
        } catch (NoClassDefFoundError e) { }

        // Safari
        try {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            pageHome = new HomePage(driver);
            return;
        } catch (NoClassDefFoundError e) { }

        // Mozilla
        try {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            pageHome = new HomePage(driver);
            return;
        } catch (NoClassDefFoundError e) { }

        // Edge
        try {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            pageHome = new HomePage(driver);
            return;
        } catch (NoClassDefFoundError e) { }

    }

    @Given("The user accesses amazon.com page")
    public void theUserIsInHomePage(){
        driver.get("https://www.amazon.com/");
    }

    @When("The available page appears")
    public void homePageAvailable(){
        Assert.assertTrue(pageHome.loadPage(), "Error home page not available");
    }

    @When("User clicks search option and type (.*)")
    public void theUserClickOnSearchOption(String product) {
        pageResult = pageHome.searchItem(product);
    }

    @When("Results page is displayed")
    public void resultPrincipalPageDisplayed(){
        Assert.assertTrue(pageResult.loadPage(), "Error page product not available");
    }

    @When("User navigates to paging")
    public void findPager() {
        pageResult.goToPaginator();
    }

    @When("User clicks on (.*) page")
    public void clickOnPageNumber(String pageNumber) {
        pageResult = pageResult.clickNumPage(pageNumber);
    }

    @When("Results second page is displayed")
    public void resultPageNumberDisplayed() {
        Assert.assertTrue(pageResult.loadPage(), "Error Second page not available");
    }

    @When("User clicks on the (.*) item")
    public void clickOnItem(int itemNumber) {
        pageProduct = pageResult.selectProductByNumber(itemNumber);
    }

    @When("Product detail page is displayed")
    public void productPageDisplayed() {
        Assert.assertTrue(pageProduct.loadPage(), "Error Product page not available");

    }

    @Then("Validate if the product is available and add to cart")
    public void validateProduct() {
        Assert.assertTrue(pageProduct.checkAvailability(), "Error Product not available");
        pageProduct.addToCart();
    }

    @After
    public void endTest(){
        driver.close();
    }

}
