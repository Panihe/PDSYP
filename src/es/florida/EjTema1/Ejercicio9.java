package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("Introduce un número del 1 al 12: ");
		int number =Integer.parseInt(sc.nextLine());
		
		String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

		switch(number) {
		  case 1:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[0]);
		    break;
		  case 2:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[1]);
		    break;
		  case 3:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[2]);
		    break;
		  case 4:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[3]);
		    break;
		  case 5:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[4]);
		    break;
		  case 6:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[5]);
		    break;
		  case 7:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[6]);
		    break;
		  case 8:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[7]);
		    break;
		  case 9:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[8]);
		    break;
		  case 10:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[9]);
		    break;
		  case 11:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[10]);
		    break;
		  case 12:
			  System.out.println("El número introducido anteriormente corresponde con el mes: " + months[11]);
		    break;
		}
		
		sc.close();
	}

}
