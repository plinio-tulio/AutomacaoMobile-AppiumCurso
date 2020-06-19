package br.com.automacao.teste;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.automacao.appium.BaseTeste;
import br.com.automacao.pages.MenuPage;
import br.com.automacao.seubarriga.pages.SBContaPage;
import br.com.automacao.seubarriga.pages.SBLoginPage;
import br.com.automacao.seubarriga.pages.SBMovimentacaoPage;
import br.com.automacao.seubarriga.pages.SBPrincipalPage;
import br.com.automacao.seubarriga.pages.SBResumoPage;

public class SBTest extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBPrincipalPage principal = new SBPrincipalPage();
	private SBContaPage conta = new SBContaPage();
	private SBMovimentacaoPage movimentacao = new SBMovimentacaoPage();
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void efetuarLogin(){
		menu.acessarSB();
		login.setEmail("email222@email.com");
		login.setSenha("222");
		login.entrar();
	}
	
	@Test
	public void inserirConta(){
		//Clicar no menu/aba contas
		esperar(3);
		principal.acessarConta();
		
		//INSERIR O NUMERO DA CONTA NO CAMPO
		conta.setConta("123456");
		
		//CLICAR EM SAVAR
		conta.salvar();
		
		//VALIDAR MENSAGEM - OBTER MENSAGEM
		Assert.assertTrue(conta.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void excluirConta(){
		//Clicar no menu/aba contas
		esperar(3);
		principal.acessarConta();

		//clique longo na conta número 123456
		conta.selecionarConta("123456");
		
		//clicar botao excluir
		conta.excluir();
		
		//valida mensagem
		Assert.assertTrue(conta.existeElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void incluirMovimentacao(){
		principal.acessarMovimetacao();
		
		movimentacao.salvar();
		Assert.assertTrue(conta.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		movimentacao.setDescricao("descr");
		movimentacao.salvar();
		Assert.assertTrue(conta.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		movimentacao.setInteressado("jose");
		movimentacao.salvar();
		Assert.assertTrue(conta.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		movimentacao.setValor("123");
		movimentacao.salvar();
		Assert.assertTrue(conta.existeElementoPorTexto("Conta é um campo obrigatório"));


		movimentacao.setConta("Conta para alterar");
		movimentacao.salvar();
		Assert.assertTrue(conta.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void excluirMovimentacaoAtualizarSaldo(){
		//verificar saldo "Conta para saldo" = 534.00
		System.out.println(principal.obterSaldo("Conta para saldo"));
		Assert.assertEquals("534.00", principal.obterSaldo("Conta para saldo"));

		
		//ir para resumo
		principal.acessarResumo();
		
		//excluir Movimentacao 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		
		
		//validar mensagem "Movimentação removida com sucesso!"
		Assert.assertTrue(conta.existeElementoPorTexto("Movimentação removida com sucesso!"));
		
		//voltar para o home
		principal.acessarHome();
		
		//atualiza o saldo
		esperar(1);
		principal.scroll(0.2, 0.9);
		
		// validar saldo atualziado após a exclusao = -1534.00
		Assert.assertEquals("-1000.00", principal.obterSaldo("Conta para saldo"));
	}
}
