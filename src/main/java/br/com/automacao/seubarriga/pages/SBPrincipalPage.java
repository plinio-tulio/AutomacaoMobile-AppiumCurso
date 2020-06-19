package br.com.automacao.seubarriga.pages;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;

public class SBPrincipalPage extends BasePage {
	
	public void acessarConta(){
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimetacao(){
		clicarPorTexto("MOV...");
	}
	
	public void acessarResumo(){
		clicarPorTexto("RESUMO");
	}
	
	public void acessarHome(){
		clicarPorTexto("HOME");
	}
	
	public String obterSaldo(String conta){
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
		///following-sinbling::android.widget.TextView
	}
}
