package es.florida.AE3_multihilo;

import java.util.ArrayList;

import es.florida.AE3_multihilo.Mina;
import es.florida.AE3_multihilo.Minero;

public class App {

	// Método: main
	// Descripción método: Crea un objeto mina con un limite (en este caso es 50),
		// crea un objeto minero con 10 mineros y lo pasa a los hilos y alterna entre
		// encenderVentilador y apagarVentilador. També recoge la cantidad de recursos
		// que han recogido los mineros y los suma, y muestra 2 mensajes uno que indica
		// el estado actual de la mina y otro estado actual de la bolsa.
	// Parámetros de entrada: String[] args pasado por parámetro
	// Parámetros de salida: No
	public static void main(String[] args) {
		ArrayList<Minero> mineros = new ArrayList();
		Mina objetoMina = new Mina(50);

		for (int i = 0; i < 10; i++) {
			Minero objetoMinero = new Minero(objetoMina);
			mineros.add(objetoMinero);
			Thread hiloMinero = new Thread(objetoMinero);
			hiloMinero.setName("minero " + (i + 1));
			hiloMinero.start();
		}
		Ventilador objetoVentilador = new Ventilador(false);
		// Hilo ventilación encendida
		Thread ventiladorEncendido = new Thread(new Runnable() {
			@Override
			public void run() {
				objetoVentilador.encenderVentilador();
			}
		});

		// Hilo ventilación apagada
		Thread ventiladorApagado = new Thread(new Runnable() {
			@Override
			public void run() {
				objetoVentilador.apagarVentilador();
			}
		});
		ventiladorEncendido.start();
		ventiladorApagado.start();

		try {
			Thread.sleep(12500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int suma = 0;
		for (int i = 0; i < mineros.size(); i++) {
			suma += mineros.get(i).bolsa;
			// System.out.println(mineros.get(i).bolsa);
		}
		System.out.println("Estado actual de la mina: " + objetoMina.stock + " oros");
		System.out.println("Estado actual de la bolsa: " + suma + " oros");
	}

}
