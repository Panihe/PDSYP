package es.florida.EjTema3;

public class Contador implements Runnable {

//	private String nombreHilo;
//	int inicioContador;
//	int limiteContador;
//
//	public Contador(String nombreHilo) {
//		this.nombreHilo = nombreHilo;
//	}
//	
//	public static void main(String[] args) {
//		int NUM_HILOS = 5;
//		Contador op;
//		for (int i = 0; i < NUM_HILOS; i++) {
//			op = new Contador("Op. " + i);
//			Thread hilo = new Thread(op);
//			hilo.start();
//		}
//
//	}
//
//	@Override
//	public void run() {
//		inicioContador = 0;
//		limiteContador = (int) (Math.random() * 6);
//		for (int i = inicioContador; i <= limiteContador; i++) {
//			System.out.println(i);
//		}
//	}
	
	private String nombreHilo;
	int inicioContador, limiteContador;

	Contador(String nombreHilo, int inicioContador, int limiteContador) {
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
		this.nombreHilo = nombreHilo;
	}
	
	public static void main(String[] args) {
		String[] arrayNombresHilos = {"hilo1", "hilo2", "hilo3", "hilo4", "hilo5"};
		int[] arrayInicios = {1,11,21,31,41};
		int[] arrayLimites = {10,20,30,40,50};
		int NUM_HILOS = 5;
		Contador objetoContador;
		Thread hiloContador;
		for(int i = 0; i < NUM_HILOS; i++) {
			objetoContador = new Contador(arrayNombresHilos[i], arrayInicios[i], arrayLimites[i]);
			hiloContador = new Thread(objetoContador);
			hiloContador.start();
		}
	}
	
	@Override
	public void run() {
		for (int i = inicioContador; i <= limiteContador; i++) {
			System.out.println("Contador " + nombreHilo + " (de " + inicioContador + " a " + limiteContador + "): " + i);
		}
	}

}
