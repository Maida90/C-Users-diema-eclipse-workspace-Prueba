package Pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Paginas.PaginaInicio;
import Paginas.PaginaLogin;


public class Laboratorio03_E2 {
	WebDriver driver;
	@BeforeSuite
	public void setUp() {
		
		//Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.gecko.driver","..\\Prueba\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@BeforeTest
	public void irUrl() {
		driver.get("http://automationpractice.com/index.php");
	}
	@BeforeClass 
	public void maxVentana() {
		driver.manage().window().maximize();
	}
	@Test
	public void login() throws IOException {
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\Prueba\\Evidencias\\PaginaInicio.png"));
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sign in')]")));
		
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicSingIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.LlenarFormulario("die87@gmail.com", "12345");
		
		screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\Prueba\\Evidencias\\LlenarFormulario.png"));
		
		
		login.clicSingIn();
		
		screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\Prueba\\Evidencias\\PaginaAbierta.png"));
		
	}
	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de prueba");
	}
	
	@AfterTest 
	public void cierreNavegador() {
		driver.quit();
		
	}
	@AfterSuite
	public void finSuite() {
		System.out.println("Fin Suite");
	}
}