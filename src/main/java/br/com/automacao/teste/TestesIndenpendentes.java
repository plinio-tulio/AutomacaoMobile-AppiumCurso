package br.com.automacao.teste;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

public class TestesIndenpendentes {

	@Test
	public void conversao() throws Exception {
			
		Locale Local = new Locale("pt","BR");
		NumberFormat n = NumberFormat.getCurrencyInstance(Local);
		String s = n.format(100);  
		System.out.println(s);

		DecimalFormat df = new DecimalFormat();  
        df.applyPattern("#,##0.0");  
        String st = df.format(100).replace(",", ".");  
        System.out.println(st);
        
        String currency="13,23";
        currency = currency.replace(",", ".");
		BigDecimal bigDecimalCurrency=new BigDecimal("15,00".replace(",", "."));
		System.out.println("Converted String currency to bigDecimalCurrency: "+bigDecimalCurrency);
	}
}
