package falabellaSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import falabellaUtiles.Utiles;

public class Lanzador extends Utiles{
	
	@Before
	public void setup() {
		driver = getDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}

}
