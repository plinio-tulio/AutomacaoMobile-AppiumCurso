package br.com.automacao.teste;

import org.junit.Test;

import br.com.automacao.appium.BaseTeste;
import br.com.automacao.pages.MenuPage;
import br.com.automacao.pages.SplashPage;


public class SplashTest extends BaseTeste {
	
	private SplashPage page = new SplashPage();
	private MenuPage pageMenu = new MenuPage();
	
	@Test
	public void deveAguardarSplashSumir(){
		pageMenu.acessarSplash();
		page.isTelaSplashVisivel();
	}

}
