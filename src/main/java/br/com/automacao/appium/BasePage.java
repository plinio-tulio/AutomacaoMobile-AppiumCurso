package br.com.automacao.appium;

import static br.com.automacao.appium.core.DriverCursoFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clique(By by) {
		getDriver().findElement(by).click();
	}
	
	public void selecionarCombo(By by, String valor){
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}
	
	public void clicarPorTexto(String texto) {
		clique(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals(true);
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size()>0;
	}

	public void esconderTeclado() {
		if (getDriver().isKeyboardShown()) {
			getDriver().hideKeyboard();
		}
	}
	
	//Clicar em posição específica
	public void tap(int x, int y){
		new TouchAction(getDriver()).tap(PointOption.point(new Point(x,y))).perform();
	}
	
	public void scrollDown(){
		scroll(0.9, 0.1);
	}
	
	public void scrollUp(){
		scroll(0.1, 0.9);
	}
	
	public void swipeDown(){
		swipe(0.9, 0.1);
	}
	
	public void swipeUp(){
		swipe(0.1, 0.9);
	}
	
	//Scrow Dow
	public void scroll(double inicio, double fim){
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width/2;
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		new TouchAction(getDriver())
			.press(PointOption.point(new Point(x,start_y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // aguardar com o primeiro clique pressionado
			.moveTo(PointOption.point(new Point(x,end_y)))
			.release()  //release = soltar a tela
			.perform(); //perform = executar a ação
	}
	
	//Swipe - ação de rolar para o lado
	public void swipe(double inicio, double fim){
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height/2;
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction(getDriver())
			.press(PointOption.point(new Point(start_x,y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))// aguardar com o primeiro clique pressionado
			.moveTo(PointOption.point(new Point(end_x,y)))
			.release()  //release = soltar a tela
			.perform(); //perform = executar a ação
	}
	
	public void swipeElement(MobileElement element,double inicio, double fim){
		Dimension size = getDriver().manage().window().getSize();
		
		int y = element.getLocation().y + (element.getSize().height / 2);
		
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		
		new TouchAction(getDriver())
		    .press(PointOption.point(new Point(start_x,y)))
		    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // aguardar com o primeiro clique pressionado
		    .moveTo(PointOption.point(new Point(end_x,y)))
			.release()  //release = soltar a tela
			.perform(); //perform = executar a ação
	}
}