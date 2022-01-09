package test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.ResultPage;


public class StepsPurchaseTest {


    private WebDriver driver;
    private HomePage pageHome;
    private ResultPage pageResult;


    @Given("The user accesses amazon.com page")
    public void theUserIsInHomePage(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        pageHome = new HomePage(driver);
        driver.get("https://www.amazon.com/");
    }

    @When("Page appears")
    public void homePage(){
        Assert.assertTrue(pageHome.loadPage(), "Error home page");
    }

    @When("User clicks search option and type Alexa")
    public void theUserClickOnSearchOption(){
        pageResult = pageHome.searchItem("Alexa");
    }

    @When("Results page is displayed")
    public void resultPrincipalPageDisplayed(){
        Assert.assertTrue(pageResult.loadPage(), "Error page result");
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
        Assert.assertTrue(pageResult.loadPage(), "Error page result");
    }

    @When("User clicks on the third item")
    public void clickOnItem() {
        pageResult.selectProductByNumber(3);
    }

    @When("Product detail page is displayed")
    public void productPageDisplayed() {

    }

    @Then("Validate if the product is available")
    public void validateProduct() {
        driver.close();
    }

}
