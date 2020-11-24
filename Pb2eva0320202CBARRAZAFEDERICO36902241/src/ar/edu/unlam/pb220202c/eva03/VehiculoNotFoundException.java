package ar.edu.unlam.pb220202c.eva03;

public class VehiculoNotFoundException extends Exception {
	public VehiculoNotFoundException() {
		super("Vehiculo no encontrado");
	}

	public VehiculoNotFoundException(String mensaje) {
		super(mensaje);
	}
}
