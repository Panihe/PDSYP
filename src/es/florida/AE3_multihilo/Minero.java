package es.florida.AE3_multihilo;

import es.florida.AE3_multihilo.Mina;

public class Minero implements Runnable {
	int bolsa;
	int tiempoExtraccion = 1000;
	Mina mina;

	// M�todo: Mina
	// Descripci�n m�todo: Coge la bolsa que va ser igual a 0 y el objecte mina para poder utilizarlos
	// Par�metros de entrada: int stock pasado por par�metros
	// Par�metros de salida: No
	Minero(Mina mina) {
		this.bolsa = 0;
		this.mina = mina;
	}

	// M�todo: extraerRecursos
	// Descripci�n m�todo: Mientras el stock de la mina sea diferente a 0, el stock
		// de la mina se resta por el recursos (en este caso es 1 recurso) y la bolsa se
		// suma por el recurso (en este caso es un 1 recurso) . Tambi�n se muestra un
		// mensaje por pantalla que siga que minero x ha extr�do 1 recursos (donde x es
		// el nombre del hilo actual) y en stock de la mina que x recursos (d�nde x es
		// lo queda en el stock de la mina)
	// Par�metros de entrada: No
	// Par�metros de salida: No
	synchronized public void extraerRecurso() {

		while (mina.stock != 0) {
			int recurso = 1;
			System.out.println("El " + Thread.currentThread().getName() + " ha extraido: " + recurso
					+ " recurso y en el stock de la mina queda: " + mina.stock + " recursos");

			mina.stock = mina.stock - recurso;
			bolsa = bolsa + recurso;
			try {
				Thread.sleep(tiempoExtraccion);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	// M�tod0: run
	// Descripci�n m�todo: Llama a extraerRecursos
	// Par�metros de entrada: No
	// Par�metros de salida: No
	@Override
	public void run() {
		extraerRecurso();
	}

}
