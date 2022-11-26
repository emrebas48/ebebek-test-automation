package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OtomationWithCucumber {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public String baseURL;

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        baseURL = "https://www.e-bebek.com/";
    }




    public void OtomationTest() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);
        WebElement searchButton = driver.findElement(By.tagName("input"));
        searchButton.sendKeys("Biberon");
        Thread.sleep(2000);
        searchButton.sendKeys(Keys.RETURN);
        Thread.sleep(8000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js.executeScript("scroll(0, 250);");
        Thread.sleep(2000);
        driver.findElements(By.id("addToCartBtn")).get(0).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("btnShowCart")).click();
        Thread.sleep(4000);
       WebElement control= driver.findElement(By.id("btnGoToShippingAddress"));
       control.isEnabled();
       if(control.isEnabled()){
           System.out.println("Ürün sepete eklendi.");
       }else System.out.println("Ürün sepete eklenmedi.");
    }}




