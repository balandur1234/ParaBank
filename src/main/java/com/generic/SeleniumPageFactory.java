package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	
	
	public SeleniumPageFactory(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}

	//login page
	
    @FindBy(xpath="//*[@name='username']")
	private WebElement UserName;
    @FindBy(xpath="//*[@name='password']")
	private WebElement PassWord;
    @FindBy(xpath="//*[@type='submit']")
	private WebElement LoginBtn;
    @FindBy(xpath="//*[text()='Log Out']")
    private WebElement LogOutBtn;
    
    //*[text()='An internal error has occurred and has been logged.'
    
    @FindBy(xpath=" //*[text()='An internal error has occurred and has been logged.']")
    private WebElement errorMsgWithinvalidCredential;
    @FindBy(xpath=" //*[text()='Please enter a username and password.']")
    private WebElement errorMsgWithNullCredential;
    
	
	
	public WebElement getUserName() {
		return UserName;
	}
	public WebElement getPassWord() {
		return PassWord;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	public WebElement getLogOutBtn() {
		return LogOutBtn;
	}
	public WebElement getErrorMsgWithinvalidCredential() {
		return errorMsgWithinvalidCredential;
	}
	public WebElement getErrorMsgWithNullCredential() {
		return errorMsgWithNullCredential;
	}
	
	
}
