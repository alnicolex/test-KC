package test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void starTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pageHome = new HomePage(driver);
    }

    @Given("The user accesses amazon.com page")
    public void theUserIsInHomePage(){
        driver.get("https://www.amazon.com/");
    }

    @When("Page appears")
    public void homePage(){
        Assert.assertTrue(pageHome.loadPage(), "Error home page not available");
    }

    @When("User clicks search option and type Alexa")
    public void theUserClickOnSearchOption(){
        pageResult = pageHome.searchItem("Alexa");
    }

    @When("Results page is displayed")
    public void resultPrincipalPageDisplayed(){
        Assert.assertTrue(pageResult.loadPage(), "Error page product not available");
    }

    @When("User navigates to paging")
    public void findPager() {
        pageResult.goToPaginator();
    }

    @When("User clicks on second page")
    public void clickOnPageNumber() {
        pageResult = pageResult.clickNumPage("2");
    }

    @When("Results second page is displayed")
    public void resultPageNumberDisplayed() {
        Assert.assertTrue(pageResult.loadPage(), "Error Second page not available");
    }

    @When("User clicks on the third item")
    public void clickOnItem() {
        pageProduct = pageResult.selectProductByNumber(3);
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
