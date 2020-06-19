package br.com.automacao.teste;

import org.junit.Test;

import br.com.automacao.appium.BaseTeste;
import br.com.automacao.pages.MenuPage;
import br.com.automacao.pages.WebViewPage;

public class WebViewTesteAppHibrido extends BaseTeste{

	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin(){
		// acessar menu
		menu.acessarSBHibrido();
		esperar(1);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("email");
		
	}
}
