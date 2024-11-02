package com.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	WebDriver driver;
	SeleniumPageFactory pf;
	SoftAssert sa;
	
	@Given("Open browser")
	public void open_browser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("Go to Para Bank application")
	public void go_to_Para_Bank_application() {
		
		driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	   
	}

	@When("Put valid user")
	public void put_valid_user() {

	    pf = new SeleniumPageFactory(driver);
		pf.getUserName().sendKeys("student");
				
		
		
	}

	@When("Put valid password")
	public void put_valid_password() {
		
		pf.getPassWord().sendKeys("qa1234");
		
	   	}

	@When("Click login button")
	public void click_login_button() {
		
		pf.getLoginBtn().click();
	    
	}

	@Then("Login should pass and should logout button visible")
	public void login_should_pass_and_should_logout_button_visible() {
		
		//condition check = logout_button_should_visible
		
		//driver.findElement(By.xpath("//*[text()='Log Out]"));
		
		pf = new SeleniumPageFactory(driver);
		//pf.getLogOutBtn();
		
		//check visible= is Displayed()
		
		//pf.getLogOutBtn().isDisplayed();
		
		//soft assert
		sa = new SoftAssert();
		sa.assertTrue(pf.getLogOutBtn().isDisplayed());
		sa.assertAll();
		
		driver.quit();
		
	    	}

	@When("Put invalid user")
	public void put_invalid_user() {
		 pf = new SeleniumPageFactory(driver);
		pf.getUserName().sendKeys("jkhda6");
		
	    
	}

	@When("Put invalid password")
	public void put_invalid_password() {
		 pf = new SeleniumPageFactory(driver);
		pf.getPassWord().sendKeys("jhfkuf156");
	    
	}

	@Then("Login should fail and an error msg contain An internal error has occurred and has been logged.")
	public void login_should_fail_and_an_error_msg_contain_An_internal_error_has_occurred_and_has_been_logged() {
	    
		 sa = new SoftAssert();
		sa.assertTrue(pf.getLogOutBtn().isDisplayed());
		sa.assertAll();
		
		driver.quit();
	}

	@When("Put null user")
	public void put_null_user() {
		
		pf = new SeleniumPageFactory(driver);
		pf.getUserName().sendKeys("");
	    
	}

	@When("Put null password")
	public void put_null_password() {
		
		pf.getPassWord().sendKeys("");
	    
	}

	@Then("Login should fail and an error msg contain please enter username and password.")
	public void login_should_fail_and_an_error_msg_contain_please_enter_username_and_password() {
		
		 sa = new SoftAssert();
		sa.assertTrue(pf.getErrorMsgWithNullCredential().isDisplayed());
		sa.assertAll();
		
		driver.quit();
	   
	}



}
