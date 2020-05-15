package CucumberFramework.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	WebDriver driver;

	@Before()
	public void setup() {
		System.setProperty("webdriver.chromedriver", "C:\\Users\\polsource\\Desktop\\CucumberFramework\\CucumberFramework\\src\\test\\java\\CucumberFramework\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
		driver.get("https://stackoverflow.com/");
	}

	@Given("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		driver.findElement(By.xpath("/html/body/header/div/ol[2]/li[2]/a[1]")).click();
	}

	@Given("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("nawrocki90@gmail.com");
	}

	@Given("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Start1234");
	}

	@When("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
	}

	@Then("^user should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		Thread.sleep(3000);
		WebElement askQuestionsButton = driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[1]/div/a"));
		Assert.assertEquals(true, askQuestionsButton.isDisplayed());
	}	
}
