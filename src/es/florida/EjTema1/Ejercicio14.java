package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
	
		System.out.print("Introduce un valor del radio de la circunferencia: ");
		double radio = Double.parseDouble(sc.nextLine());
		
		double diametro = radio*2;
		double area = Math.PI * Math.pow(radio,2);
		
		System.out.println("Dado el valor del radio, que es " + radio + ", el di�metro de la circunferencia es " + String.format("%.3f", diametro));
		
		System.out.println("Dado el valor del radio, que es " + radio + ", el �rea de la circunferencia es " + String.format("%.3f", area));
		
		sc.close();
	}

}
