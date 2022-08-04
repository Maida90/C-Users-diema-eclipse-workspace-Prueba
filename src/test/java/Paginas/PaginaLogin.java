package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(xpath ="//input[@id='email']")
	WebElement txtEmail;
	@FindBy(xpath ="//input[@id='passwd']")
	WebElement txtpassword;
	@FindBy(xpath="//span[normalize-space()='Sign in']")
	WebElement btnSingIn;
	
	public   PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void LlenarFormulario(String email, String password) {
		txtEmail.sendKeys(email);
		txtpassword.sendKeys(password);
	}
	public void clicSingIn() {
		btnSingIn.click();
	}
}
