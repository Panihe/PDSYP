package es.florida.AE01;

import java.util.ArrayList;

public class Ejercicio2 {

	public static void main(String[] args) {
		partA();
		partB();
	}
	
	// A. Haz que se escriban por la consola en líneas consecutivas
	public static void partA() {
		
		String[] classMates = {"Josep", "Jaume", "Carlos", "Ximo", "Edu", "Nestor"};
		
		for(int i = 0; i < classMates.length; i++) {
			System.out.println(classMates[i]);
		}
		
	}
	
	// B. Haz lo mismo, pero empleando un objeto de tipo lista
	public static void partB() {
		
		ArrayList<String> classMatesList = new ArrayList<String>();
		classMatesList.add("Josep");
		classMatesList.add("Jaume");
		classMatesList.add("Carlos");
		classMatesList.add("Ximo");
		classMatesList.add("Edu");
		classMatesList.add("Nestor");
		System.out.println(classMatesList);
	}
}
