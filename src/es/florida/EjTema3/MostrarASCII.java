package es.florida.EjTema3;

public class MostrarASCII implements Runnable {
	
//	String nombreHilo;
//	int tipo = 2;
//	public MostrarASCII(String nombreHilo) {
//		this.nombreHilo = nombreHilo;
//	}
//	
//	public static void main(String[] args) {
//		int NUM_HILOS = 2;
//		MostrarASCII op;
//		for (int i = 0; i < NUM_HILOS; i++) {
//			op = new MostrarASCII("Op. " + i);
//			Thread hilo = new Thread(op);
//			hilo.start();
//		}
//	}
//
//	@Override
//	public void run() {
//		if (tipo == 2) {
//			int startAscii = 32;
//			int endAscii = 126;
//			for (int i = startAscii; i <= endAscii; i++) {
//				if (i % 2 == 0) {
//					System.out.println("Pares:   " + i + "  =>  " + (char) i);
//				} else {
//					System.out.println("Impares: " + i + "  =>  " + (char) i);
//				}
//			}
//
//		}
//	}
	

	int tipo;
	MostrarASCII(int tipo) {
		this.tipo = tipo;
	}
	
	public static void main(String[] args) {
		MostrarASCII objeto1 = new MostrarASCII(1);
		MostrarASCII objeto2 = new MostrarASCII(2);
		Thread thread1 = new Thread(objeto1);
		Thread thread2 = new Thread(objeto2);
		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		int startAsciiImpar = 1;
		int startAsciiPar = 2;
		int endAscii = 256;
		if (tipo == 1) {
			for (int i = startAsciiImpar; i <= endAscii; i += 2) {
				System.out.println(" Caracter impar nº" + i + ": " + (char)i);
			}
		}else if(tipo == 2) {
			for (int i = startAsciiPar; i <= endAscii; i += 2) {
				System.out.println(" Caracter par nº" + i + ": " + (char)i);
			}
		}
	}


}
