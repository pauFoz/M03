package ex5Menu;

import java.util.Objects;

public abstract class Vehiculo implements Comparable<Vehiculo>{
	//Atributos
	protected String matricula;
	protected int km;
	//Constructor
	public Vehiculo(String matricula, int km) throws MyException{
		if(!validarMatricula(matricula)) {
			throw new MyException(matricula);
		}
		this.matricula = matricula;	
		if(validarKm(km)) {
			this.km = km;	
		}
	}
	
	
	
	//validators
	/**
	 * Metodo validador de matricula
	 * @param text
	 * @return
	 */
	public boolean validarMatricula(String text) {
		if(text.matches("^[0-9]{4}-[BCDFGHJKLMNPRSTVWXYZ]{3}$")) {
			return true;
		}else if(text.matches("^[A-Z]{1,2}-[0-9]{4}-[A-Z]{1,2}$")){
			return true;
		}
		return false;
	}
	/**
	 * Metodo validador de kilometros
	 * @param km
	 * @return
	 */
	public boolean validarKm(int km) {
		if((km <0)||(km > 10000000)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	
	@Override
	public boolean equals(Object objeto) {
		if(this == objeto) return true;
		if(objeto == null) return false; 
		if(getClass() != objeto.getClass()) return false;
		Vehiculo other = (Vehiculo) objeto;
		return Objects.equals(matricula, other.matricula);
	}
	
	
	
	
	@Override
	public int compareTo(Vehiculo v) {
		return this.matricula.compareToIgnoreCase(v.matricula);
	}
	

	//Getters and setter
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}

	

	
	
	
}
