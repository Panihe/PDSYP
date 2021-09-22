package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio7 {
	
	
	public static void main(String[] args) {
		experienceLevel();
	}
	
	public static void experienceLevel() {

		Scanner sc = new Scanner(System.in);
	
		System.out.print("Introduce tu nombre: ");
		String name = sc.nextLine();
		
		System.out.print("Introduce tus años de experiencia: ");
		int years = Integer.parseInt(sc.nextLine());
		
		System.out.print(name + " -> ");	
		
		if(years < 1) {
			System.out.println("Desarrollador Junior L1 – 15000-18000");	
		}else if(years >= 1 && years <= 2 ) {
			System.out.println("Desarrollador Junior L2 – 18000-22000");
		}else if(years >= 3 && years < 5 ) {
			System.out.println("Desarrollador Senior L1 – 22000-28000");
		}else if(years >= 5 && years <= 8) {
			System.out.println("Desarrollador Senior L2 – 28000-36000");
		}else if(years > 8) {
			System.out.println("Analista / Arquitecto. Salario a convenir en base a rol");
		}
		
		sc.close();
	}
}
