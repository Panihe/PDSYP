package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int min = 1;
	    int max = 10;
	    
	    int number;
	    do {
	    	System.out.print("Introduce un n�mero del " + min + " al "+ max + ": ");
			number = Integer.parseInt(sc.nextLine());
			if(number < 1) {
				System.out.println("N�mero no v�lido, por favor introduce un valor mayor o igual que 1");
			}
			
			if(number > 10) {
				System.out.println("N�mero no v�lido, por favor introduce un valor menor o igual que 10");
			}
	    }while(!(number > 1 && number < 10));


		int numberRandom = (int)Math.floor(Math.random()* 10) + 1;
		
		
		if(number == numberRandom) {
			System.out.println("El n�mero " + number + " (introducido anteriormente) coincide con el n�mero "+ numberRandom + " (generado aleatoriamente)");
			System.out.println("Enhorabuena!!, has ganado un iphone 12 pro");
		}else {
			System.out.println("El n�mero " + number + " (introducido anteriormente) no coincide con el n�mero "+ numberRandom + " (generado aleatoriamente)");
			System.out.println("Suerte la pr�xima vez!");
		}
		
		sc.close();
	
	}

}
