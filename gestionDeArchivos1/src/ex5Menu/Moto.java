package ex5Menu;

public class Moto extends Vehiculo{
	//Atributos
	private int cilindrada;
	//Cosntructores
	public Moto(String matricula, int km,int cilindrada) throws MyException{
		super(matricula, km);
		if(cilindrada > 0) {
			this.cilindrada = cilindrada;
		}
	}

	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	@Override
	public String toString() {
		return "Moto [cilindrada=" + cilindrada + ", matricula=" + matricula + ", km=" + km + "]";
	}

}
