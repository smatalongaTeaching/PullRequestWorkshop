package workshopTDD.money;

public class Money {

	private double ammount;
	private String currency;
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double someAmmount) {
		this.ammount = someAmmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String aCurrency) {
		this.currency = aCurrency;
	}
	public Money(double cantidad, String tipo) {
		super();
		setAmmount(cantidad);
		setCurrency(tipo);
	}
	
	public boolean equals(Object o){
		Money m = (Money)o;
		return this.getAmmount() == m.getAmmount() && this.getCurrency().equalsIgnoreCase(m.getCurrency());
		
	}
	
	public Money sum(Money otherMoney){
		return new Money(this.ammount + otherMoney.getAmmount(), this.getCurrency());
	}
	
	public Money sum(Money otraCurr, ExchangeRate usToPeso) {
		if(otraCurr.getCurrency().equals(this.currency)){
			return this.sum(otraCurr);
		}
		else{
			return this.sum(usToPeso.change(otraCurr));
		}
		
	}
	public Money substract(Money otraMon, ExchangeRate usToPeso) {
		if(otraMon.getCurrency().equals(this.currency))
			return substract(otraMon);
		else
			return this.substract(usToPeso.change(otraMon));
	}
	public Money substract(Money otraMon) {
		return new Money(this.ammount-otraMon.getAmmount(), this.getCurrency());
	}
	public Money multiply(int numero) {
		return new Money(this.ammount * numero, this.getCurrency());
	}
	
	public Money divide(int numero) {
		double res=this.ammount /numero;
		return new Money(res, this.getCurrency());
	} 
		 
	
	
}
