package br.com.automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.automacao.appium.BasePage;
import br.com.automacao.appium.core.DriverCursoFactory;

public class MenuPage extends BasePage {
	
	public void acessarFormulario(){
		clicarPorTexto("Formulário");	
	}
	
	public void acessarSplash(){
		clicarPorTexto("Splash");
	}
	
	public void acessarAlert(){
		clicarPorTexto("Alertas");
	}
	
	public void acessarCliques(){
		clicarPorTexto("Cliques");
	}
	
	public void acessarSwipe(){
		clicarPorTexto("Swipe");
	}
	
	public void acessarSB(){
		clicarPorTexto("SeuBarriga Nativo");
	}
	
	public void acessarSBHibrido(){
		clicarPorTexto("SeuBarriga Híbrido");
	}
	
	public void acessarSwipeList(){
		WebDriverWait wait = new WebDriverWait(DriverCursoFactory.getDriver(),10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Swipe List");
	}
	
	public void clicarDragNDrop(){
		WebDriverWait wait = new WebDriverWait(DriverCursoFactory.getDriver(),10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Drag and drop");
	}
	
	public String obterMensagemAlerta(){
		return obterTexto(By.id("android:id/message"));
	}
	
	
}
