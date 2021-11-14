package es.florida.AE3_multihilo;

public class Ventilador {
	boolean funcionamiento = true;
	int tiempo = 2000;
	
	// M�todo: ventilacion
	// Descripci�n m�todo: Coge el funcionamiento para poder utilizarlo
	// Par�metros de entrada: boolean funcionamiento pasado por par�metros
	// Par�metros de salida: No
	Ventilador(boolean funcionamiento) {
		this.funcionamiento = funcionamiento;
	}
	
	// M�todo: encenderVentilador
	// Descripci�n m�todo: Muestra un mensaje y se espera a que el metodo apagarVentilador acabe
	// Par�metros de entrada: no
	// Par�metros de salida: No
	public void encenderVentilador() {
		while (true) {
			synchronized (this) {
				try {
					while (funcionamiento == false) wait();
					System.out.println(" -> Ventilador encencido durante " + tiempo / 1000 + " segundos");
					Thread.sleep(tiempo);
					funcionamiento = false;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// M�todo: apagarVentilador
	// Descripci�n m�todo: Muestra un mensaje y se espera a que el metodo encendorVentilador acabe
	// Par�metros de entrada: no
	// Par�metros de salida: No
	public void apagarVentilador() {
		while (true) {
			synchronized (this) {
				try {
					while (funcionamiento == true) wait();
					System.err.println(" -> Ventilador apagado durante " + tiempo / 1000 + " segundos");
					Thread.sleep(tiempo);
					funcionamiento = true;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
