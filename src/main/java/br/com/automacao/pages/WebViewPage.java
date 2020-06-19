package br.com.automacao.pages;

import java.util.Set;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;
import br.com.automacao.appium.core.DriverCursoFactory;

public class WebViewPage extends BasePage {

	
	public void entrarContextoWeb(){
		Set<String>contextHandles = DriverCursoFactory.getDriver().getContextHandles();
		for (String valor : contextHandles) {
			System.out.println(valor);
		}
		DriverCursoFactory.getDriver().context((String) contextHandles.toArray()[1]);
	}
	
	public void setEmail(String valor){
		DriverCursoFactory.getDriver().findElement(By.id("email")).sendKeys(valor);;
	}
	
	public void setSenha(String valor){
		DriverCursoFactory.getDriver().findElement(By.id(""));
	}
	
	public void sairContextoWeb(){
		DriverCursoFactory.getDriver().context((String) DriverCursoFactory.getDriver().getContextHandles().toArray()[0]);
	}
}
