package es.florida.EjTema4.Ejercicio10;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {
	public static void main(String[] args) throws IOException, InterruptedException {
       String javaHome = System.getProperty("java.home");
       String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
       String classpath = System.getProperty("java.class.path");
       
       String className = "es.florida.EjTema4.Ejercicio10.ServidorCalculo";
       List<String> command = new ArrayList();
       command.add(javaBin);
	   command.add("-cp");
	   command.add(classpath);
	   command.add(className);
	   ProcessBuilder builder = new ProcessBuilder(command);
	   Process process = builder.inheritIO().start();
	   
	   className = "es.florida.EjTema4.Ejercicio10.ClienteCalculo";
       command = new ArrayList();
       command.add(javaBin);
	   command.add("-cp");
	   command.add(classpath);
	   command.add(className);
	   command.add("Cliente 1");
	   command.add("+");
	   command.add("96");
	   command.add("69");
	   builder = new ProcessBuilder(command);
	   process = builder.inheritIO().start(); 
	   
	   className = "es.florida.EjTema4.Ejercicio10.ClienteCalculo";
       command = new ArrayList();
       command.add(javaBin);
	   command.add("-cp");
	   command.add(classpath);
	   command.add(className);
	   command.add("Cliente 2");
	   command.add("-");
	   command.add("150");
	   command.add("25");
	   builder = new ProcessBuilder(command);
	   process = builder.inheritIO().start(); 
	   
	   className = "es.florida.EjTema4.Ejercicio10.ClienteCalculo";
       command = new ArrayList();
       command.add(javaBin);
	   command.add("-cp");
	   command.add(classpath);
	   command.add(className);
	   command.add("Cliente 3");
	   command.add("/");
	   command.add("200");
	   command.add("20");
	   builder = new ProcessBuilder(command);
	   process = builder.inheritIO().start(); 
	   
       
    }

}
