package org.karenramirez.automatizacionselenium.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchaseStepDefinitions{

    private final WebDriver driver = new ChromeDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement Espera;


    @Before
    public void setTheStage(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @After
    public void down(){
        driver.quit();
    }

    @Given("^(.*) is authenticated$")
    public void Authenticate() {

        WebElement MENU_LOG_IN = driver.findElement(By.id("login2"));
        MENU_LOG_IN.click();

        Espera = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));

        WebElement INPUT_USERNAME = driver.findElement(By.id("loginusername"));
        INPUT_USERNAME.sendKeys("admin");

        WebElement INPUT_PASSWORD = driver.findElement(By.id("loginpassword"));
        INPUT_PASSWORD.sendKeys("admin");

        WebElement BUTTON_LOGIN = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
        BUTTON_LOGIN.click();
    }

    @Given("^add from (.*) [a-z]{1,2} (.*)$")
    public void addToCart(String category, String product) {
        Espera = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("logout2")));

        WebElement MENU_HOME = driver.findElement(By.xpath("//a[text()='Home ']"));
        MENU_HOME.click();

        WebElement CATEGORY_MENU = driver.findElement(By.xpath("//a[@id='itemc'][text()='"+category+"']"));
        CATEGORY_MENU.click();

        Espera = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'card')]//a[text()='"+product+"']")));

        WebElement PRODUCT_MENU = driver.findElement(By.xpath("//div[contains(@class,'card')]//a[text()='"+product+"']"));
        PRODUCT_MENU.click();

        Espera = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart")));

        WebElement ADD_TO_CART_BUTTON = driver.findElement(By.linkText("Add to cart"));
        ADD_TO_CART_BUTTON.click();
    }

    @When("^[a-zA-Z]{3,40} makes the purchase$")
    public void Purchase() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        Espera = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("cartur")));

        WebElement MENU_CART = driver.findElement(By.id("cartur"));
        MENU_CART.click();

        Espera = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='page-wrapper']/div/div[2]/button")));

        WebElement BUTTON_PLACE_ORDER = driver.findElement(By.xpath("//*[@id='page-wrapper']/div/div[2]/button"));
        BUTTON_PLACE_ORDER.click();

        Espera = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("name")));

        WebElement INPUT_NAME = driver.findElement(By.id("name"));
        INPUT_NAME.sendKeys("Juan");

        WebElement INPUT_COUNTRY = driver.findElement(By.id("country"));
        INPUT_COUNTRY.sendKeys("Colombia");

        WebElement INPUT_CITY = driver.findElement(By.id("city"));
        INPUT_CITY.sendKeys("Medellin");

        WebElement INPUT_CARD = driver.findElement(By.id("card"));
        INPUT_CARD.sendKeys("123456789");

        WebElement INPUT_MONTH = driver.findElement(By.id("month"));
        INPUT_MONTH.sendKeys("05");

        WebElement INPUT_YEAR = driver.findElement(By.id("year"));
        INPUT_YEAR.sendKeys("25");

        WebElement BUTTON_PURCHASE = driver.findElement(By.xpath("//*[@onclick='purchaseOrder()']"));
        BUTTON_PURCHASE.click();
    }
    @Then("should see the message Thank you for your purchase")
    public void shouldSeeTheMessageThankYouForYourPurchase() {
        WebElement BUTTON_VALIDATE = driver.findElement(By.xpath("//button[text()='OK']"));
        BUTTON_VALIDATE.click();

    }


}
