package es.florida.EjTema3;

public class Ejercicio5 implements Runnable {

	int alitasDisponibles = 100;
	static int alitasConsumidas = 0;

	synchronized public void consumirAlita(String nombre, int alitas) {
	//public void consumirAlita(String nombre, int alitas) {
		if (alitas <= alitasDisponibles) {
			System.out.println(alitas + " alitas se come " + nombre);
			alitasDisponibles = alitasDisponibles - alitas;
			alitasConsumidas = alitasConsumidas + alitas;
		} else {
			System.out.println(nombre + " quiere " + alitas + " alitas, pero no quedan alitas suficientes :(((");
		}
	}

	@Override
	public void run() {
		String nombre = Thread.currentThread().getName();
		int alitas = (int) (Math.random() * 10 + 1);
		consumirAlita(nombre, alitas);
	}

	public static void main(String[] args) {
		Ejercicio5 ej5 = new Ejercicio5();
		Thread t;
		for(int i = 0; i < 30; i++) {
			t = new Thread(ej5);
			t.setName("Amigo " + (i + 1));
			t.start();
		}
		
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Total alitas consumidas: " + alitasConsumidas);
	}
}
