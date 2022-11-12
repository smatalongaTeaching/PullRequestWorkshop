package workshopTDD.money;

public class ExchangeRate {

	private String desde;
	private String hacia;
	private int valor;

	
	public ExchangeRate(String money1, String money2, int value) {
		super();
		this.desde = money1;
		this.hacia = money2;
		this.valor = value;
	}

	public Money change(Money otraMoneda) {
		if(otraMoneda.getCurrency().equals(desde)){
			return new Money(otraMoneda.getAmmount() * valor, this.hacia);
		}
		else if(otraMoneda.getCurrency().equals(hacia)){
			return new Money(otraMoneda.getAmmount() * (1/valor), this.desde);
		}
		else{
			return null;
		}
	}

}
