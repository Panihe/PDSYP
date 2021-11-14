package es.florida.EjTema3;

public class Ejercicio6 {

	public static class Semaforos {
		int semaforo = 1;
		int tiempoFuncionamiento = 5000;

		public void encenderSemaforo1() {
			while (true) {
				synchronized (this) {
					try {
						while (semaforo == 2)
							wait();
						System.err.print("Semáforo 2 rojo");
						System.out.println(" -> Semáforo 1 verde durante " + tiempoFuncionamiento / 1000 + " segundos");
						Thread.sleep(tiempoFuncionamiento);
						semaforo = 2;
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		public void encenderSemaforo2() {
			while (true) {
				synchronized (this) {
					try {
						while (semaforo == 1)
							wait();
						System.err.print("Semáforo 1 rojo");
						System.out.println(" -> Semáforo 2 verde durante " + tiempoFuncionamiento / 1000 + " segundos");
						Thread.sleep(tiempoFuncionamiento);
						semaforo = 1;
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Semaforos s = new Semaforos();
		
		// Hilo semaforo 1 encendido
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				s.encenderSemaforo1();
			}
		});
			
		// Hilo semaforo 2 encendido
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				s.encenderSemaforo2();
			}
		});
		t1.start();
		t2.start();
	}

}
