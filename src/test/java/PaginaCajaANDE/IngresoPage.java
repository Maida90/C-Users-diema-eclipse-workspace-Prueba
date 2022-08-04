package PaginaCajaANDE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IngresoPage{
	@FindBy(name ="cedula")
	WebElement txtcedula;
	@FindBy(xpath ="password")
	WebElement txtpassword;
	@FindBy(xpath="//paper-button[contains(text(),'Ingresar')]")
	WebElement btnSingIn;
	
	public   IngresoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void LlenarFormularioLogin(String cedula, String password) {
		txtcedula.sendKeys(cedula);
		txtpassword.sendKeys(password);
	}
	public void clicSingIn() {
		btnSingIn.click();
	}
}