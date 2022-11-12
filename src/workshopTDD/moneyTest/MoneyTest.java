package workshopTDD.moneyTest;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import workshopTDD.money.*;


public class MoneyTest {

	
	@Test
	public void testSumWithDifferentCurrencies(){
		Money oneDolar= new Money(1, "USD");
		Money pesos100= new Money(100, "UYP");
		
		Money expected = new Money(124, "UYP");
		ExchangeRate usToPeso = new ExchangeRate("USD", "UYP", 24);
		
		Money resultado = pesos100.sum(oneDolar, usToPeso);
		
		assertEquals(expected, resultado);
	}
	
	@Test
	public void testSumWithSameCurrency(){
		Money pesos100= new Money(100, "UYP");
		Money pesos150= new Money(150, "UYP");
		
		Money expected = new Money(250, "UYP");
		
		Money resultado = pesos100.sum(pesos150);
		
		assertEquals(expected, resultado);
	}
	
	@Test
	public void testSimpleExchangeRate(){
		ExchangeRate usToUyp = new ExchangeRate("USD", "UYP", 24);
		
		Money dolar = new Money(1, "USD");
		
		Money equivalentPesos = new Money(24, "UYP");
		
		Money transform = usToUyp.change(dolar);
		
		assertEquals(equivalentPesos, transform);
	}
	
	@Test
	public void testSubstractWithDifferentCoins(){
		Money oneDolar= new Money(1, "USD");
		Money pesos100= new Money(100, "UYP");
		
		Money expected = new Money(76, "UYP");
		ExchangeRate usToPeso = new ExchangeRate("USD", "UYP", 24);
		
		Money result = pesos100.substract(oneDolar, usToPeso);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSubstractSameCurrency(){
		Money pesos100= new Money(100, "UYP");
		Money pesos150= new Money(150, "UYP");
		
		Money expected = new Money(50, "UYP");
		
		Money result = pesos150.substract(pesos100);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testMultiply(){
		Money pesos100= new Money(100, "UYP");
		int numero= 3;
		
		Money expected = new Money(300, "UYP");
		
		Money resultado = pesos100.multiply(numero);
		
		assertEquals(expected, resultado);
	}
	
	@Test
	public void testDivide(){
		Money pesos100= new Money(100, "UYP");
		int numero= 2;
		
		Money expected = new Money(50, "UYP");
		
		Money resultado = pesos100.divide(numero);
		
		assertEquals(expected, resultado);
	}
	
		
	@Test
	public void testMultiplByCero(){
		Money pesos100= new Money(100, "UYP");
		int numero= 0;
		
		Money expected = new Money(0, "UYP");
		
		Money result = pesos100.multiply(numero);
		
		assertEquals(expected, result);
	}
	
}
