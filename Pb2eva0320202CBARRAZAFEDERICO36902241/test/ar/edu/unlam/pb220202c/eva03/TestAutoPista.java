package ar.edu.unlam.pb220202c.eva03;

import org.junit.Assert;
import org.junit.Test;

public class TestAutoPista {

	@Test
	public void queSePuedaRegistrarTelepase() {
		Autopista accOeste = new Autopista();
		Vehiculo autoFede = new Automovil("MYB507");
		Assert.assertTrue(accOeste.registrarTelepase(12332, autoFede));
	}

	@Test(expected = VehiculoNotFoundException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFoundException {
		Autopista accOeste = new Autopista();
		Vehiculo autoFede = new Automovil("MYB507");

		Assert.assertTrue(accOeste.registrarTelepase(12332, autoFede));

		accOeste.salirAutpista(autoFede);
	}

	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente()
			throws VehiculoNotFoundException {
		Autopista accOeste = new Autopista();
		Vehiculo autoUno = new Automovil("MYB507");
		Vehiculo autoDos = new Automovil("AYB508");
		Vehiculo camionUno = new Camion("ZYB508");
		Vehiculo camionDos = new Camion("AYB508");

		Assert.assertTrue(accOeste.registrarTelepase(12332, camionUno));
		Assert.assertTrue(accOeste.registrarTelepase(12333, autoDos));
		Assert.assertTrue(accOeste.registrarTelepase(12334, autoUno));
		Assert.assertTrue(accOeste.registrarTelepase(99999, camionDos));
		
		Assert.assertTrue(accOeste.ingresarAutopista(12332));
		Assert.assertTrue(accOeste.ingresarAutopista(12333));
		Assert.assertTrue(accOeste.ingresarAutopista(12334));
		Assert.assertTrue(accOeste.ingresarAutopista(99999));

		autoUno.incrementarVelocidad(200);
		autoDos.incrementarVelocidad(70);
		camionUno.incrementarVelocidad(120);
		camionDos.incrementarVelocidad(150);

		
		String listaDeInfractoresOrdenadosPorPatente = "AYB508 MYB507 ZYB508 ";
		String cadenaResultado = "";
		for (Vehiculo v : accOeste.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente()) {
			//System.out.println(v.getPatente() + " " + v.getVelocidadActual());
			cadenaResultado += v.getPatente() + " ";
		}
		
		Assert.assertTrue(accOeste.cantidadDeVehiculosENCirculacion().equals(4));
		Assert.assertTrue(listaDeInfractoresOrdenadosPorPatente.equals(cadenaResultado));
	}

	@Test
	public void generetestAEleccion1() throws VehiculoNotFoundException {
		// Que el vehiculo registrado en telepase pueda ingresar a la autopista
		Autopista accOeste = new Autopista();
		Vehiculo autoFede = new Automovil("MYB507");

		Assert.assertTrue(accOeste.registrarTelepase(12332, autoFede));
		Assert.assertTrue(accOeste.ingresarAutopista(12332));
	}

	@Test(expected = VehiculoNotFoundException.class)
	public void generetestAEleccion2() throws VehiculoNotFoundException {
		// Que un vehiculo no registrado en telepase no pueda ingresar a la autopista
		Autopista accOeste = new Autopista();
		accOeste.ingresarAutopista(9999);
	}

	@Test
	public void vehiculosEnCirculacionEsDos() throws VehiculoNotFoundException {
		// Que el vehiculo registrado en telepase pueda ingresar a la autopista
		Autopista accOeste = new Autopista();
		Vehiculo autoUno = new Automovil("MYB507");
		Vehiculo autoDos = new Automovil("MYB508");

		Assert.assertTrue(accOeste.registrarTelepase(12332, autoUno));
		Assert.assertTrue(accOeste.registrarTelepase(12333, autoDos));
		Assert.assertTrue(accOeste.ingresarAutopista(12332));
		Assert.assertTrue(accOeste.ingresarAutopista(12333));

		Assert.assertTrue(accOeste.cantidadDeVehiculosENCirculacion().equals(2));
	}
}
