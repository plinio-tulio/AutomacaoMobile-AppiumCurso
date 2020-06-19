package br.com.automacao.teste;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.automacao.appium.BaseTeste;
import br.com.automacao.appium.core.DriverCursoFactory;
import br.com.automacao.pages.FormularioPageCurso;
import br.com.automacao.pages.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste extends BaseTeste {

	private FormularioPageCurso pageFormulario = new FormularioPageCurso();
	private MenuPage pageMenu = new MenuPage();

	@Before
	public void Setup() throws MalformedURLException {
		//driver = DriverCursoFactory.getDriver();
	}

	@After
	public void TearDown() {
		//DriverCursoFactory.killDriver();
		//System.out.println("Finalizando");
	}

	@Test
	public void devePreencherCampoTexto() throws Exception {
		// Selecionar formulario
		List<MobileElement> elementosEncontrados = DriverCursoFactory.getDriver().findElements(By.className("android.widget.TextView"));
		for (MobileElement elemento : elementosEncontrados) {
			System.out.println(elemento.getText());
		}
		elementosEncontrados.get(1).click();

		// Preencher campo com nome
		MobileElement campoNome = DriverCursoFactory.getDriver().findElement(MobileBy.AccessibilityId("nome"));
		// COM DSL
		// dsl.escrever(MobileBy.AccessibilityId("nome"), "Plinio");
		// Preencheno usando page object
		pageFormulario.escreverNome("Plinio");

		// checar o campo nome escrito
		String text = campoNome.getText();
		Assert.assertEquals("Plinio", text);

	}

	@Test
	public void preencherCombo() throws Exception {
		// Selecionar formulario
		DriverCursoFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		// Preencher campo com nome
		MobileElement campoNome = DriverCursoFactory.getDriver().findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Plinio");

		// clicar no combo
		DriverCursoFactory.getDriver().findElement(MobileBy.AccessibilityId("console")).click();

		// selecionar a opcao desejada
		DriverCursoFactory.getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// verificar a opção selecionada
		String valorCombo = DriverCursoFactory.getDriver().findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

		// checar o campo nome escrito
		String text = campoNome.getText();
		Assert.assertEquals("Plinio", text);
		Assert.assertEquals("Nintendo Switch", valorCombo);
	}

	@Test
	public void preencherSwitchECheckBox() throws Exception {

		// Selecionar formulario - Buscar qualquer elemento que tenha o texto
		// formulario
		DriverCursoFactory.getDriver().findElement(By.xpath("//*[@text='Formulário']")).click();

		// Verificar status dos elementos
		MobileElement check = DriverCursoFactory.getDriver().findElement(By.className("android.widget.CheckBox"));
		MobileElement swtc = DriverCursoFactory.getDriver().findElement(MobileBy.AccessibilityId("switch"));

		// clicar nos elementos
		check.getAttribute("checked"); // retorna o atributo checked do elemento
										// true ou false
		swtc.getAttribute("checked");
		System.out.println(check.getAttribute("checked"));
		System.out.println(check.getAttribute("checked"));

		// verificar status alterado
		check.click();
		swtc.click();
	}

}
