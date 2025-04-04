package vehiculos;

public class Coche extends Vehiculo{
	//Atributos
	private boolean esClasico;
	//Constructor
	public Coche(String matricula, int km,boolean clasico) throws MyException{
		super(matricula, km);
		this.esClasico = clasico;
	}

	
	public boolean isEsClasico() {
		return esClasico;
	}
	public void setEsClasico(boolean esClasico) {
		this.esClasico = esClasico;
	}


	@Override
	public String toString() {
		return "Coche [esClasico=" + esClasico + ", matricula=" + matricula + ", km=" + km + "]";
	}


}
