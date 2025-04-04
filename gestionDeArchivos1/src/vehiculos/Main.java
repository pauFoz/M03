package vehiculos;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		
		Concesionario c = new Concesionario("direccion");
		
		c.leerFichero();
		c.mostrarLista();
		
		
		
	}

}
