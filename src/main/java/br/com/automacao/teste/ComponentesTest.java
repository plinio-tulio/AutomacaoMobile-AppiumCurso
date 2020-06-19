package br.com.automacao.teste;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.automacao.appium.BaseTeste;
import br.com.automacao.appium.core.DriverCursoFactory;
import br.com.automacao.pages.AlertaPage;
import br.com.automacao.pages.CliquePage;
import br.com.automacao.pages.DragDropPage;
import br.com.automacao.pages.FormularioPageCurso;
import br.com.automacao.pages.MenuPage;
import br.com.automacao.pages.SwipeListPage;

public class ComponentesTest extends BaseTeste{

	private AlertaPage page = new AlertaPage();
	private MenuPage menu = new MenuPage();
	private FormularioPageCurso pageFormulario = new FormularioPageCurso();
	private CliquePage cliquePage = new CliquePage();
	private SwipeListPage swipePage = new SwipeListPage();
	private DragDropPage dragDropPage = new DragDropPage();
	
	@Test
	public void deveClicarForaAlerta(){
		menu.acessarAlert();
		page.clicarAlertaSimples();
		esperar(1);
		page.clicarForaCaixa();
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no Ok ou fora da caixa para sair"));
	}
	
	@Test
	public void interagirSeekBar(){
		menu.acessarFormulario();
		pageFormulario.clicarSeekBar(0.65);
		pageFormulario.salvar();
	}
	
	@Test
	public void deveRealizarCliqueLongo(){
		menu.acessarCliques();
		cliquePage.cliqueLongo();
		Assert.assertEquals("Clique Longo", cliquePage.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo(){
		menu.acessarCliques();
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		Assert.assertEquals("Duplo Clique", cliquePage.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarScroll(){
		WebDriverWait wait = new WebDriverWait(DriverCursoFactory.getDriver(),10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		System.out.println("Come�ando");
		//scroll dow
		menu.scroll(0.9, 0.1);  //Porcentagem de altura da tela de 90% que seria na parte final inferior at� 10% para parte superior
		
		//clicar menu
		menu.clicarPorTexto("Op��o bem escondida");

		//verificar mensagem
		Assert.assertEquals("Voc� achou essa op��o", menu.obterMensagemAlerta());
		
		//sair
		page.clicarPorTexto("OK");
	}
	
	@Test
	public void deveRealizarSwipe(){
		//acessar menu
		menu.acessarSwipe();
		// verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		//swipe para direita
		menu.swipe(0.9, 0.1);
		
		//verificar texto 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		
		//clicar bot�o direito
		menu.swipe(0.9, 0.1);
		
		// Verificar texto 'Chegar at� o fim!'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar at� o fim!"));
		
		//Swipe esquerda
		menu.swipe(0.1, 0.9);
		
		//clicar bot�o esquerda.
		menu.swipe(0.1, 0.9);
		//menu.clicarPorTexto("<");
		
		// verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
	
	@Test
	public void deveRealizarSwipeDesafio(){
		//acessar menu
		menu.acessarSwipeList();
		
		swipePage.swipeElementRight("Op��o 1");
		
		swipePage.clicarBotaoMais();
		
		Assert.assertTrue(menu.existeElementoPorTexto("Op��o 1 (+)"));
		
		swipePage.swipeElementRight("Op��o 4");
		
		page.clicarPorTexto("(-)");
		
		Assert.assertTrue(menu.existeElementoPorTexto("Op��o 4 (-)"));
		
		swipePage.swipeElementLeft("Op��o 5 (-)");
		Assert.assertTrue(menu.existeElementoPorTexto("Op��o 5"));
		
	}
	
	@Test
	public void deveRealizarDragAndDrop(){
		String[] estadoInicial = 
				new String[]{"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado."};
		String[] estadoIntermediario = 
				new String[]{"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para","Esta", "qualquer local desejado."};
		String[] estadoFinal = 
				new String[]{"Fa�a um clique longo," ,"� uma lista", "Drag em Drop!", "e arraste para","Esta", "qualquer local desejado."};
		
		//acessar menu
		menu.clicarDragNDrop();
		
		//verificar o estado inicial
		esperar(2);
		System.out.println(dragDropPage.obterLista());
		Assert.assertArrayEquals(estadoInicial, dragDropPage.obterLista());
		
		//arrastar "Esta" para "e arraste para"
		dragDropPage.arrastar("Esta", "e arraste para");
		
		//verificar o estado intermediario
		Assert.assertArrayEquals(estadoIntermediario, dragDropPage.obterLista());
		
		//arrastar "Faca um clique longo" para "� uma lista"
		dragDropPage.arrastar( "Fa�a um clique longo,", "� uma lista");
		Assert.assertArrayEquals(estadoFinal, dragDropPage.obterLista());
		
	}
	
	
}