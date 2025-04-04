package gestionArchivos;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

		public static void leerFichero() throws IOException {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el nombre de un fichero");
			String nombre = sc.nextLine();
			int suma = 0;
			
			
			File file = new File(nombre);
			String linea;
			
			try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
				while ((linea = bReader.readLine()) != null) {
					int numero = Integer.parseInt(linea.trim());
			        suma += numero;
				}
				System.out.println("La suma de los enteros del fichero es: " + suma);
			 } catch (FileNotFoundException e) {
		            System.out.println("Fitxer no existeix");
		        } catch (IOException e) {
		            System.out.println(e.getMessage());
		        } 
		}
	
		public static void escribirFichero() throws IOException {
			Scanner sc = new Scanner(System.in);
			boolean append = false;
			System.out.println("Escribe palabras");
			String input = sc.nextLine();
			int cont = 0;
			
			try (PrintWriter pWriter = new PrintWriter(new FileWriter("nom", append))) {
				do {
					pWriter.println(input);
					if(input.contains(" ")) {
						for(int i = 0;i<input.length();i++) {
							if(Character.isSpace(input.charAt(i))) {
								cont++;
							}
						}
					}
					cont++;
					input = sc.nextLine();
				}while((input.equals("fi")||(!input.isEmpty())));
			} catch (Exception e) {
					System.out.println(e.getMessage());
			} 
			System.out.println("Hay " + cont + " palabras en total.");
		}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
/*

			File file = new File("pepGuardiola");

			try {
				if (file.exists()) {
				    System.out.println("el fitxer existeix");
				} else {
				    System.out.println("el fitxer NO existeix, el creem");
				    file.createNewFile();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("path: " + file.getPath()); // fitxer
			System.out.println("path absolut: " + file.getAbsolutePath()); // {path_to_file}/fitxer
			System.out.println("ultima modificació : " + new Date(file.lastModified()));
			System.out.println("longitud : " + file.length());

			file.setExecutable(true);

			if (file.canExecute()) {
			    System.out.println("execució");
			}
			if (file.canRead()) {
			    System.out.println("lectura");
			}
			if (file.canWrite()) {
			    System.out.println("escriptura");
			}
			if (file.isFile()) {
			    System.out.println("fitxer");
			}
			if (file.isDirectory()) {
			    System.out.println("directori");
			}
			if (file.isHidden()) {
			    System.out.println("ocult");
			}

			File dir = new File("miDirectorio");
			if (dir.exists()) {
			    System.out.println("el directori existeix");
			} else {
			    System.out.println("el directori NO existeix, el creem");
			    dir.mkdir();
			}
			if (dir.isDirectory()) {
			    System.out.println("directori");
			}

			String[] fitxers = dir.list();
			for (int i = 0; i < fitxers.length; i++) {
			    System.out.println("fitxer " + fitxers[i]);
			}
			
			
			leerFichero();
*/
			escribirFichero();
			

	}

}
