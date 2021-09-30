package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("Introduce un número del 1 al 12: ");
		int number =Integer.parseInt(sc.nextLine());
		
		int[] numberMonths = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		if (number == numberMonths[0]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[0]);
		}else if (number == numberMonths[1]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[1]);
		}else if (number == numberMonths[2]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[2]);
		}else if (number == numberMonths[3]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[3]);
		}else if (number == numberMonths[4]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[4]);
		}else if (number == numberMonths[5]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[5]);
		}else if (number == numberMonths[6]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[6]);
		}else if (number == numberMonths[7]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[7]);
		}else if (number == numberMonths[8]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[8]);
		}else if (number == numberMonths[9]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[9]);
		}else if (number == numberMonths[10]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[10]);
		}else if (number == numberMonths[11]) {
			System.out.println("El número introducido anteriormente corresponde con el mes: " + months[11]);
		}
		sc.close();
		
	}

}
