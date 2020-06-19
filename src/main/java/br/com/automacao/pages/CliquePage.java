package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;
import br.com.automacao.appium.core.DriverCursoFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class CliquePage extends BasePage {

	public void cliqueLongo(){
		new TouchAction(DriverCursoFactory.getDriver())
			.longPress(PointOption.point(DriverCursoFactory.getDriver()
					.findElement(By.xpath("//*[@text='Clique Longo']")).getCenter()))

			.perform();
	}
	
	public String obterTextoCampo(){
		return DriverCursoFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
