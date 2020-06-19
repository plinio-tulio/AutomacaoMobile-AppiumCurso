package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;

public class EstoquePage extends BasePage {

	public void preencherCampoMotivo() {
		escrever(By.id("br.com.pztec.estoque:id/txt_motivo"), "motivo");
	}

	public void preencherCampoReferencia() {
		escrever(By.id("br.com.pztec.estoque:id/txt_referencia"), "ref");
	}

	public void preencherCampoEntrada(String entrada) {
		escrever(By.id("br.com.pztec.estoque:id/txt_qtdentrada"), entrada);
	}

	public void preencherCampoRetirada(String retirada) {
		escrever(By.id("br.com.pztec.estoque:id/txt_qtdsaida"), retirada);
	}

	public String obterEstoqueAtual() {
		return obterTexto(By.id("br.com.pztec.estoque:id/txt_qtdatual"));
	}

	public void salvar() {
		clique(By.id("br.com.pztec.estoque:id/btn_salvar"));
	}

}