package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo {
	
	// Si es necesario Utilice herencia o implemente de Interfaces
	// Se debe crear contructeres getters y Setters y los que crean conveniente
	private Integer cantidadDeEjes;
	
	// el Limite de velociadad para autos es de 80km
	// en caso que supere dicho limite el este sera multado	
	private static Integer LIMITE_VELOCIDAD = 80;

	public Camion(String patente) {
		super(patente, LIMITE_VELOCIDAD);
	}

	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}

	public void setCantidadDeEjes(Integer cantidadDeEjes) {
		this.cantidadDeEjes = cantidadDeEjes;
	}
}
