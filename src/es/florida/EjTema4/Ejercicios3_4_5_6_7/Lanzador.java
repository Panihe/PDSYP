package es.florida.EjTema4.Ejercicios3_4_5_6_7;

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
       
       String className = "es.florida.EjTema4.Ejercicios3_4_5_6_7.ServidorObjeto";
       List<String> command = new ArrayList();
       command.add(javaBin);
	   command.add("-cp");
	   command.add(classpath);
	   command.add(className);
	   ProcessBuilder builder = new ProcessBuilder(command);
	   Process process = builder.inheritIO().start();
	   
	   className = "es.florida.EjTema4.Ejercicios3_4_5_6_7.ClienteObjeto";
       command = new ArrayList();
       command.add(javaBin);
	   command.add("-cp");
	   command.add(classpath);
	   command.add(className);
	   builder = new ProcessBuilder(command);
	   process = builder.inheritIO().start();
	   
	   
       
    }

}
