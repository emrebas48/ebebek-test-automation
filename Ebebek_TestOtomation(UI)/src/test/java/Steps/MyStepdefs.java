package Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;



import java.time.Duration;
import java.util.concurrent.TimeUnit;
import tests.OtomationWithCucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class MyStepdefs extends OtomationWithCucumber {

    @Given("Type bottle in the search bar.")
    public void typeBottleInTheSearchBar() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        baseURL = "https://www.e-bebek.com/";
        driver.get(baseURL);
        Thread.sleep(3000);
        WebElement searchButton = driver.findElement(By.tagName("input"));
        searchButton.sendKeys("Biberon");
        Thread.sleep(2000);
        searchButton.sendKeys(Keys.RETURN);
        Thread.sleep(8000);

    }

    @When("The search is done.")
    public void theSearchIsDone() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js.executeScript("scroll(0, 250);");
        Thread.sleep(2000);

    }

    @And("Click the Add to Cart button.")
    public void clickTheAddToCartButton() throws InterruptedException {
        driver.findElements(By.id("addToCartBtn")).get(0).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("Click the View Cart button.")
    public void clickTheViewCartButton() throws InterruptedException {
        driver.findElement(By.id("btnShowCart")).click();
        Thread.sleep(4000);
    }

    @Then("Check that the product has been added to the cart")
    public void checkThatTheProductHasBeenAddedToTheCart() {
        WebElement control= driver.findElement(By.id("btnGoToShippingAddress"));
        control.isEnabled();
        if(control.isEnabled()){
            System.out.println("Ürün sepete eklendi.");
        }else System.out.println("Ürün sepete eklenmedi.");
    }
}
