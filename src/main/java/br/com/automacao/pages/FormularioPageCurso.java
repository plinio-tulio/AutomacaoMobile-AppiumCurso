package br.com.automacao.pages;

import br.com.automacao.appium.BasePage;
import br.com.automacao.appium.core.DriverCursoFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPageCurso extends BasePage {


	public void escreverNome(String nome){
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public void salvar(){
		clicarPorTexto("SALVAR");
	}
	
	public void salvarDemorado(){
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	public void clicarSeekBar(double posicao){
		int delta = 50;
		MobileElement seek = DriverCursoFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height/2);
		
		System.out.println(y);
		int xinicial = seek.getLocation().x + delta;
		int x = (int)(xinicial + ((seek.getSize().width -2*delta) * posicao));
		System.out.println(x);
		tap(x,y);
	}
	
	
}
