package es.florida.AE3_multihilo;

public class Ventilador {
	boolean funcionamiento = true;
	int tiempo = 2000;
	
	// Método: ventilacion
	// Descripción método: Coge el funcionamiento para poder utilizarlo
	// Parámetros de entrada: boolean funcionamiento pasado por parámetros
	// Parámetros de salida: No
	Ventilador(boolean funcionamiento) {
		this.funcionamiento = funcionamiento;
	}
	
	// Método: encenderVentilador
	// Descripción método: Muestra un mensaje y se espera a que el metodo apagarVentilador acabe
	// Parámetros de entrada: no
	// Parámetros de salida: No
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
	
	// Método: apagarVentilador
	// Descripción método: Muestra un mensaje y se espera a que el metodo encendorVentilador acabe
	// Parámetros de entrada: no
	// Parámetros de salida: No
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
