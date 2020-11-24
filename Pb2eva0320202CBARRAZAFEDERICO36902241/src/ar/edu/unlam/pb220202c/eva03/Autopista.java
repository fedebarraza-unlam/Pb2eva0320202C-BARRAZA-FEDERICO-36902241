package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	// Si es necesario Utilice herencia o implemente de Interfaces
	// Se debe crear contructeres getters y Setters y los atributos o metodos que
	// crean convenientes
	private HashMap<Integer, Vehiculo> telepase;
	private HashSet<Vehiculo> vehiculosEnCirculacion;

	public Autopista() {
		this.telepase = new HashMap<Integer, Vehiculo>();
		this.vehiculosEnCirculacion = new HashSet<Vehiculo>();
	}

	public Boolean registrarTelepase(Integer numeroTelpase, Vehiculo vehiculo) {
		this.telepase.put(numeroTelpase, vehiculo);
		return this.telepase.containsKey(numeroTelpase);
	}

	public Boolean ingresarAutopista(Integer numeroTelepase) throws VehiculoNotFoundException {
		// si el telepase no esta registrado lanza una Exceptios del tipo
		// VehiculoNotFounException
		// y no permite ingresar al autopista
		if (!this.telepase.containsKey(numeroTelepase)) {
			throw new VehiculoNotFoundException();
		}

		return this.vehiculosEnCirculacion.add(this.telepase.get(numeroTelepase));
	}

	public void salirAutpista(Vehiculo vehiculo) throws VehiculoNotFoundException {
		// lanza Una exception VehiculoNotFounException si no esta en circulacion
		if (!this.vehiculosEnCirculacion.contains(vehiculo)) {
			throw new VehiculoNotFoundException("El Vehiculo no se encuentra en circulacion");
		}

		this.vehiculosEnCirculacion.remove(vehiculo);
	}

	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente() {
		TreeSet<Vehiculo> vehiculosConExcesosDeVelocidad = new TreeSet<Vehiculo>();
		
		for (Vehiculo vehiculo : this.vehiculosEnCirculacion) {
			if (vehiculo.enInfraccion()) {
				vehiculosConExcesosDeVelocidad.add(vehiculo);
			}
		}

		return vehiculosConExcesosDeVelocidad;
	}

	public Integer cantidadDeVehiculosENCirculacion() {
		return this.vehiculosEnCirculacion.size();
	}
}
