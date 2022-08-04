package Edit.Prueba;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Pelis {
	 
	@Test
	public void lab1_E2(){
		//Propiedades para ejecutar el driver de Firefox	
		System.setProperty("webdriver.chrome.driver","..\\FUNA\\Drivers\\chromedriver.exe");
		//Instancias Driver de Firefox + importar libreria	
		
		WebDriver d= new ChromeDriver();
		d.get("https://www.pelisplus2.io/peliculas/accion/");
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
	}	
}


