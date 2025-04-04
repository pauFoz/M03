package vehiculos;

public class MyException extends Exception{

		public MyException(String mensaje) {
			super(mensaje);
		}
		
		public String getMessage() {
			String error = super.getMessage();
			error += " Matricula incorrecta";
			return error;
		}
}
