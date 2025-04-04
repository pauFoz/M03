package vehiculos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Concesionario {
	//Atributos
	private String direccion;
	private TreeSet<Vehiculo> vehiculos;
	private final static int N = 10;
	
	//Constructor
	public Concesionario(String direccion) {
		this.direccion = direccion;
		this.vehiculos = new TreeSet<Vehiculo>();
	}
	
	//Metodos
	/**
	 * Metodo para añadir un vehiculo al concesionario
	 * @param v
	 * @return
	 */
	public boolean añadir(Vehiculo v) {
		if(vehiculos.size() > N) {
			return false;
		}
		
		return vehiculos.add(v);
	}
	/**
	 * Metodo para eliminar un vehiculo al concesionario
	 * @param matricula
	 * @return
	 */
	public boolean eliminar(String matricula) {		
		for(Vehiculo v : vehiculos) {
			if(v.getMatricula().equals(matricula)) {
				vehiculos.remove(v);
				return true;
			}
		}	
			return false;
	}
	/**
	 * Metodo para mostrar la lista de vehiculos del concesionario
	 */
	public void mostrarLista() {
		for(Vehiculo v : vehiculos) {
			System.out.println(v);
		}
	}
	/**
	 * Metodo  para mostrar el numero de vehiculos del concesionario
	 * @return
	 */
	public int numeroVehiculos() {
		return vehiculos.size();
	}
	/**
	 * Metodo para saber la media de kilometros de los vehiculos de la lista
	 * @return
	 * @throws Exception 
	 */

	
	public void leerFichero() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Introduce el nombre de un fichero");
		String nombreArchivo = sc.nextLine();
		File file = new File(nombreArchivo);
		
		String aux[] = new String[5];
		
		String linea;
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			while ((linea = bReader.readLine()) != null) {
				linea.trim();
				aux = linea.split("; ");
				
				if(linea.charAt(0) != '#') {
					if("cotxe".equals(aux[0])) {
						int aux1 = Integer.parseInt(aux[2]);
						boolean aux2 = Boolean.parseBoolean(aux[3]);
						try {
						vehiculos.add(new Coche(aux[1],aux1,aux2));
						}catch(MyException ex) {
							System.out.println(ex.getMessage()); 
						}
					}else if(aux[0].equals("moto")){
						int km = Integer.parseInt(aux[2]);
						int aux2 = Integer.parseInt(aux[3]);
						try {
						vehiculos.add(new Moto(aux[1],km,aux2));
						}catch(MyException ex) {
							System.out.println(ex.getMessage()); 
						}
					}else {
						System.out.println("Este vehiculo no exsiste");
					}
				}
				
		       
			}
		 } catch (FileNotFoundException e) {
	            System.out.println("Fitxer no existeix");
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } 
	}
	
	

	
	//Getters and setters
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public TreeSet<Vehiculo> getVehiuclos() {
		return vehiculos;
	}
	public void setVehiuclos(TreeSet<Vehiculo> vehiuclos) {
		this.vehiculos = vehiuclos;
	}

	@Override
	public String toString() {
		return "Concesionario [direccion=" + direccion + ", vehiculos=" + vehiculos + "]";
	}
	
	
	
}
