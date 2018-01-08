package stepdefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class YahooLoginTest_StepDef {

	WebDriver webdriver=null;
	
	@Given ("^user opens facebook login page$")
	public void user_opens_facebook_login_page() {
		System.setProperty("webdriver.chrome.driver","/Users/nisum/Downloads/chromedriver");
		//Create prefs map to store all preferences 
//		Map<String, Object> prefs = new HashMap<String, Object>();
//
//		//Put this into prefs map to switch off browser notification
//		prefs.put("profile.default_content_setting_values.notifications", 2);
//
//		//Create chrome options to set this prefs
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", prefs);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		webdriver=new ChromeDriver(options);
		webdriver.get("https://www.facebook.com/");
		webdriver.manage().window().fullscreen();
	}
	
	@Then("^user enters loginId$")
	public void user_enters_loginId() {
		webdriver.findElement(By.xpath("//*[@id='email']")).sendKeys("nagababu.madala@gmail.com");
	}
	@Then("^user enters password$")
	public void user_enters_password() {
		webdriver.findElement(By.xpath("//*[@id='pass']")).sendKeys("9989374982");
	}
	@And("^user clicks on loginbutton$")
	public void user_clicks_on_login_button(){
		webdriver.findElement(By.xpath("//*[@id='loginbutton']")).click();
		
	}
	
	@And("^user clicks on label$")
	public void user_clicks_on_label(){
		webdriver.findElement(By.xpath("//*[@id=\"userNavigationLabel\"]")).click();
	}
	
	
	
	@And("^user clicks on logout$")
	public void user_clicks_on_logout(){
		webdriver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		webdriver.findElement(By.xpath("//li[12]/a/span/span")).click();
	}
	
	@And("^close the browser$")
	public void close_the_browser() {
		webdriver.quit();
	}
}
