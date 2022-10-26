package tdd;

public class Cuenta {
	
	private double saldo = 0;

	public double getSaldo() {
		return saldo;
	}

	public void ingresar(double cantidad) {
		double roundOff = Math.round(cantidad * 100.0) / 100.0;
		if(roundOff != cantidad || cantidad < 0 || cantidad > 6000) {
			return;
		}
		
		saldo += cantidad;
	}
	
	
}
