package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

//		for(int i = 0; i < 5; i++) {
//			System.out.print("Por favor introduzca un nombre: ");
//			String nombrePersona = sc.nextLine();
//	}

		String nombrePersona;
		boolean parar;

		do {
			System.out.print("Introduce un nombre: ");
			nombrePersona = sc.nextLine();
	
			if(isNumeric(nombrePersona)) {
				parar = false;
			}else {
				parar = true;
			}
			
		} while (parar);
		
		sc.close();
		
	}
	
	 private static boolean isNumeric(String nombrePersona){

	        try {
	            int numeroPersona = Integer.parseInt(nombrePersona);;
	            if(numeroPersona == 0) {
	            return true;
	            }
	        } catch (NumberFormatException nfe){
	            return false;
	        }
	        return false;
	    }

}