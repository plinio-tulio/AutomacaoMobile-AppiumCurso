package br.com.automacao.seubarriga.pages;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;
import br.com.automacao.appium.core.DriverCursoFactory;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {

	public void excluirMovimentacao(String desc){
		MobileElement el = DriverCursoFactory.getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}
}
