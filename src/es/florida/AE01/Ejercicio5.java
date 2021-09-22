package es.florida.AE01;

public class Ejercicio5 {
	
	
	public static void main(String[] args) {
		getLargerElement();
	}
	
	public static void getLargerElement() {
		double[] numbers = {7, 10, 11, 17, 21, 9, 8, 24.5};

		// Saca el número mayor del array numbers
		
		double largeElement = numbers[0];
		
		for(int i = 0; i < numbers.length; i++) {
			  System.out.println(numbers[i]);
			  if(numbers[i] > largeElement){ // 
	              largeElement = numbers[i];
	           }
		}
		
		System.out.println("El número mayor es: " + largeElement);
		
		// Saca el número menor del array numbers
		
		double smallElement = numbers[0];
		
		for(int i = 0; i < numbers.length; i++) {
			  if(numbers[i] < smallElement){ // 
	              smallElement = numbers[i];
	           }
		}
		
		// Con String.format le digo que no me devuelva el numero con menor que es un numero entero con decimales
		System.out.println("El número menor es: " + String.format("%.0f", smallElement)); 
		
	}
}
