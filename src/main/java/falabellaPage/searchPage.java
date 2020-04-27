package falabellaPage;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import falabellaUtiles.Utiles;



public class searchPage extends Utiles{
	
	
	public @FindBy(name = "q") WebElement inp_Buscador;
	public @FindBy(xpath = "//div[@class='BSaJxc']") WebElement ing_Web;
	public @FindBy(xpath = "//*[@id=\'new_tottus_nav_cliente_recetas\']") WebElement ing_Recetas;
	public @FindBy(xpath = "//*[@id='tottusLoadingPage']/div[6]/div/div[3]/div[2]/button[2]") WebElement cerrar_PopUp;
	public @FindBy(xpath = "//*[@id=\'divRecipes\']/section/div/div[2]/div[2]/div/div[2]/h3") WebElement div_Receta;
	public @FindBy(xpath = "//div[@id='myDIV']/button[4]") WebElement btn_Alta;
	
	
	/****************************************************/
	
	public void inicializaWeb() {
		getDriver().get("http://www.google.com");
	}
	
	public void inpBuscador(String txtBuscar) {
		inp_Buscador.sendKeys(txtBuscar);
		inp_Buscador.sendKeys(Keys.ENTER);
	}
	
	public void ingWeb() {
		ing_Web.click();;
	}
	
	public void cerrarEmergente() {
		cerrar_PopUp.click();
	}
	
	public void ingRecetas() {
		ing_Recetas.click();
	}
	
	public void difAlta() {		
		btn_Alta.click();
	}
	
	public void divReceta() {
		div_Receta.click();
	}
	
	public void windowHandle() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}		
	}
	
	public void scrollReceta() {
		JsPageScroll(0,600);
	}
	
	public void validaIngrediente(String valIng) {
		for(int i=1; i<=8; i++) {			
			WebElement ingrediente = driver.findElement(By.xpath("//div[2]/div[2]/p["+i+"]"));
			String getIngrediente = ingrediente.getText();
			
			if(getIngrediente.contains(valIng)) {
				System.out.println("Receta Contiene " + valIng + " en la posición: " + i + ", de listado de Ingredientes");
				break;
			} else {				
				System.out.println("Aún no se encuentra ingrediente " + valIng + " en Listado");
			}
		}			
	}
}
