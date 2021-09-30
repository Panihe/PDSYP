package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
	
		System.out.print("Introduce un valor del radio de la circunferencia: ");
		double radio = Double.parseDouble(sc.nextLine());
		
		double diametro = radio*2;
		double area = Math.PI * Math.pow(radio,2);
		double volumen = 4 * Math.PI * Math.pow(radio, 3) / 3;
		
		System.out.println("Dado el valor del radio, que es " + radio + ", el diámetro de la circunferencia es " + String.format("%.3f", diametro));
		System.out.println("Dado el valor del radio, que es " + radio + ", el área de la circunferencia es " + String.format("%.3f", area));
		System.out.println("Dado el valor del radio, que es " + radio + ", el volumen de la circunferencia es " + String.format("%.3f", volumen));
		
		sc.close();
	}

}
