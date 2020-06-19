package br.com.automacao.seubarriga.pages;

import static br.com.automacao.appium.core.DriverCursoFactory.getDriver;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;
import br.com.automacao.appium.core.DriverCursoFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class SBContaPage extends BasePage {

	public void setConta(String numeroConta){
		escrever(By.className("android.widget.EditText"), numeroConta);
	}
	
	public void salvar(){
		clicarPorTexto("SALVAR");
	}
	
	public void excluir(){
		clicarPorTexto("EXCLUIR");
	}
	
	public String obterMensagem(){
		return obterTexto(By.cssSelector("android.widget.TextView"));
	}
	

	public void selecionarConta(String numeroConta){
		new TouchAction(getDriver())
		    .longPress(longPressOptions().withElement(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='"+numeroConta+"']")))))
			.perform();
	}
}
