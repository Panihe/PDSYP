package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 

		double mark = 0;
		
		int matricula = 0;
		int sobresalientes = 0;
		int notables = 0;
		int aprobados = 0;
		int suspensos = 0;
		
		int i = 0;

		do {
			System.out.print("Por favor introduzca una nota: ");
			mark = Double.parseDouble(sc.nextLine());
			
			//comprobarNotas(mark, suspensos, aprobados, notables, sobresalientes, matricula);
			
			if (mark > 10) {
				i--;
				System.out.println("Has introducido una nota que no es válida");
			}
			i++;
		}while (i < 10);
		System.out.println("Tienes: " + matricula + " matriculas, " + sobresalientes + " sobresalientes, " + notables + " notables, " + aprobados + " aprobados, " + suspensos + " suspensos");
		
		sc.close();	
			
	}
	
//	public static int comprobarNotas(double mark, int suspensos, int aprobados, int notables, int sobresalientes, int matricula) {		
//		if(mark < 5) {
//			suspensos += 1;
//		}else if (mark >= 5 && mark < 6) {
//			aprobados += 1;
//		}else if (mark >= 6 && mark < 7) {
//			aprobados += 1;
//		}else if (mark >= 7 && mark < 9) {
//			notables += 1;
//		}else if (mark >= 9 && mark < 10) {
//			sobresalientes += 1;
//		}else if (mark == 10) {
//			matricula += 1;
//		}
//	
//	}

}
