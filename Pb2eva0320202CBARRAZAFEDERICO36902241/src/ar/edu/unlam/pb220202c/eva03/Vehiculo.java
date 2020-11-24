package ar.edu.unlam.pb220202c.eva03;

public class Vehiculo implements Imultable, Comparable<Vehiculo> {

	// Se debe crear contructeres getters y Setters y loos que crean convenientes
	private String patente;
	private Integer velocidadActual;
	private Integer limiteVelocidad;

	public Vehiculo(String patente, Integer limiteVelocidad) {
		this.setPatente(patente);
		this.setLimiteVelocidad(limiteVelocidad);
		this.setVelocidadActual(0);
	}

	public void incrementarVelocidad(Integer velocidad) {
		this.setVelocidadActual(velocidad);
	};

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}

	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}

	public Integer getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(Integer velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	@Override
	public boolean equals(Object obj) {
		Vehiculo vehiculo = (Vehiculo) obj;

		if (vehiculo == null) {
			return false;
		}

		return this.getPatente().equalsIgnoreCase(vehiculo.getPatente());
	}

	@Override
	public Boolean enInfraccion() {
		return this.getVelocidadActual() >= this.getLimiteVelocidad();
	}

	@Override
	public int compareTo(Vehiculo o) {
		return this.getPatente().compareTo(o.getPatente());
	}
}
