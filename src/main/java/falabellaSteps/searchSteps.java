package falabellaSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import falabellaUtiles.Utiles;

public class searchSteps extends Utiles{
	
	@Given("^Ingreso al buscador Google$")
	public void ingreso_al_buscador_Google() throws Throwable {
	    searchPage.inicializaWeb();
	    Thread.sleep(6000);
	}

	@Given("^Realizo la busqueda de \"([^\"]*)\"$")
	public void realizo_la_busqueda_de(String txtBuscar) throws Throwable {
		searchPage.inpBuscador(txtBuscar);
		Thread.sleep(3000);
	    
	}

	@Given("^Ingreso al sitio web de la primera sucursal del resultado de busqueda$")
	public void ingreso_al_sitio_web_de_la_primera_sucursal_del_resultado_de_busqueda() throws Throwable {
	    searchPage.ingWeb();
	    Thread.sleep(7000);
}

	@When("^En sitio web Tottus presionar la opcion Recetas$")
	public void en_sitio_web_Tottus_presionar_la_opci_n_Recetas() throws Throwable {
		searchPage.cerrarEmergente();
	    Thread.sleep(2000);	
	    searchPage.ingRecetas();
	    Thread.sleep(7000);
	}

	@When("^Seleccionamos Dificultad Alta$")
	public void seleccionamos_Dificultad_Alta() throws Throwable {
		searchPage.windowHandle();
		Thread.sleep(2000);
	    searchPage.difAlta();
	    Thread.sleep(3000);
	}

	@Then("^Buscamos la receta para Rollitos de Canela$")
	public void buscamos_la_receta_para_Rollitos_de_Canela() throws Throwable {
	    searchPage.divReceta();
	    Thread.sleep(3000);
	    searchPage.scrollReceta();
	    Thread.sleep(2000);
	}

	@Then("^Validamos que contenga \"([^\"]*)\"$")
	public void validamos_que_contenga(String valIng) throws Throwable {
		searchPage.validaIngrediente(valIng);
	    Thread.sleep(1000);
	}
}
