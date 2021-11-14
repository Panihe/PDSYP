package es.florida.EjTema3;

public class Caracol implements Runnable {
	
	double distancia = 1;
	String nombre;
	double velocidad;

	public Caracol(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}
	
	public static void main(String[] args) {
	String[] arrayNombres = {"Turbo","Rayo","Flash","Viento","Lightspeed"};
	double[] arrayVelocidades = {0.01, 0.011, 0.0099, 0.00999, 0.0105}; // Velocidad en metros por segundo
	int NUM_HILOS = 5;
	Caracol objetoCaracol;
	Thread hiloCaracol;
	for (int i = 0; i < NUM_HILOS; i++) {
		objetoCaracol = new Caracol(arrayNombres[i], arrayVelocidades[i]);
		hiloCaracol = new Thread(objetoCaracol);
		hiloCaracol.start();
	}
}
	
	@Override
	public void run() {
		double avance = 0;
		double porcentaje = 0;
		System.out.println(nombre + " inicia la carrera");
		while(avance < distancia) {
			avance += velocidad * 1; // Asumir una iteración por segundo
			porcentaje = 100 * avance / distancia; 
			System.out.println("Caracol " + nombre + " -> " + String.format("%.0f", porcentaje) + "%");
			try {
				Thread.sleep(200); // Pausa para ver el avance
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" -> ¡¡¡Caracol " + nombre + " ha llegado a la meta!!!");
	}
}
