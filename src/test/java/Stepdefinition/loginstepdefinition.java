package Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginstepdefinition {

    WebDriver driver;
    @Given("^user launch browser$")
    public void LaunchEdgeBrowser(){

        //Invoking browser
        System.setProperty("webdriver.edge.driver", "C:\\Users\\rajas\\Desktop\\Selenium\\microsoft edge\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com");



    }
    @When("^user enter username and password$")
    public void LoginSuccess(){


        WebElement logo= driver.findElement(By.className("login_logo"));
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(logo));
        WebElement username_field= driver.findElement(By.id("user-name"));
        username_field.sendKeys("standard_user");
        WebElement password_field= driver.findElement(By.xpath("//div[@id='login_button_container']/div/form/div[2]/input"));
        password_field.sendKeys("secret_sauce");
        WebElement login_button= driver.findElement(By.name("login-button"));
        login_button.click();

    }

    @Then("^user should be able to login successfully$")

    public void HomeScreen(){
        WebElement logo_homepage= driver.findElement(By.className("app_logo"));
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(logo_homepage));
        driver.quit();





    }



}



