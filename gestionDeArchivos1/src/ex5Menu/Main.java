package ex5Menu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Concesionario c1 = new Concesionario("Direccion");
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("---MENU VEHICULOS---");	
			System.out.println("---1: Salir---");	
			System.out.println("---2: Cargar archivo CSV---");	
			System.out.println("---3: Cargar archivo XML---");	
			System.out.println("---4: Mostrar lista de vehiculos---");
			System.out.println("---5: Añadir un vehiculo---");
			System.out.println("---6: Eliminar un vehiculo---");
			System.out.println("---7: Coche con mas kilometros---");
			System.out.println("---8: Guardar lista de vehiculos en un archivo CSV---");
			System.out.println("---9: Guardar lista de vehiculos en un archivo XML---");
			String op = sc.nextLine();
			opcion = Integer.parseInt(op);
			
			switch(opcion) {
			case 1 :
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				c1.mostrarLista();
				break;
			case 5: //Añadir vehiculo
				System.out.println("El vehiculo es una Moto o un Coche??");
				String ve = sc.nextLine();
				
				if("coche".equals(ve)) {
					System.out.println("Introduce los datos del coche");
					String aux[] = new String [3];
					String vehiculo = sc.nextLine();
					vehiculo.trim();
					aux = vehiculo.split(";");
					int km = Integer.parseInt(aux[1]);
					boolean historico = Boolean.parseBoolean(aux[2]);
					
					try {
						if(c1.añadir(new Coche(aux[0],km,historico))) {
							System.out.println("Coche Introducido correctamente");
						}else {
							System.out.println("Fallo al introducir el coche");
						}
					} catch (MyException e) {
						e.printStackTrace();
					}
				}else if("moto".equals(ve)) {
					System.out.println("Introduce los datos del coche");
					String aux[] = new String [23];
					String vehiculo1 = sc.nextLine();
					vehiculo1.trim();
					aux = vehiculo1.split(";");
					int km = Integer.parseInt(aux[1]);
					int cilindrada = Integer.parseInt(aux[2]);	
					
					try {
						if(c1.añadir(new Moto(aux[0],km,cilindrada))) {
							System.out.println("Moto Introducida correctamente");
						}else {
							System.out.println("Fallo al introducir la moto");
						}		
					} catch (MyException e) {
						e.printStackTrace();
					}
				}
				break;
			case 6:
				System.out.print("Introduce la matricula del vehiculo que quieres eliminar: ");
				String matricula = sc.nextLine();
				if(c1.eliminar(matricula)) {
					System.out.println("El vehiculo con la matricula " + matricula + " se ha eliminado correctamente.");
				}else {
					System.out.println("Ha habido un problema al eliminar el vehiculo");
				}
				
				break;
			case 7:
				System.out.println(c1.masKm()); 
				break;
			case 8:
				break;
			case 9:
				break;
			}
			
		}while(opcion != 1);
		
		
	}
}
