package ar.unlam.edu.ar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.TreeSet;

import org.junit.Test;

public class TestComaniaTransporte {

	@Test
	public void queSePuedaRegistrarUnViaje() {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Boolean valorObtenido = empresa.getViajes().containsValue(viaje);
		assertTrue(valorObtenido);

	}

	@Test
	public void queSePuedaRegistrarUnTicketDePasajeroAUnViaje() {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);

		// Completar Test

		try {
			empresa.registrarTicketPasajero(numeroViaje, pasajero);
		} catch (TipoTicketInvalidoExcption | CantidadPasajeroSobrepasadaException | NoSeEncontroUnViajePorElNumeroDeViaje e) {
			e.printStackTrace();
		}
		
		for (Ticket ticket : empresa.getTickets()) {
			assertEquals(ticket.getId(), numeroViaje);
			
			TicketPasajero ticketPasajero = (TicketPasajero) ticket;
			assertEquals(ticketPasajero.getPasajero().getDni(), dni);
		}
	}

//	ME FALTA HACER A PARTIR DE ACA
	
	@Test (expected = TipoTicketInvalidoExcption.class)
	public void queAlRegistrarUnTicketDePasajeroAUnViajeConMedioDeTransporteDeCargaLanceUnaException() throws TipoTicketInvalidoExcption {

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);

		// Completar test
		try {
			empresa.registrarTicketPasajero(numeroViaje, pasajero);
		} catch (CantidadPasajeroSobrepasadaException| NoSeEncontroUnViajePorElNumeroDeViaje e) {
			e.printStackTrace();
		}

	}

	@Test
	public void queSePuedaRegistrarUnTicketDeCargaAUnViaje() {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		
		Integer numeroViaje = 1;
		
		// Completar Test
		
		empresa.registrarViaje(viaje);
		try {
			empresa.registrarTicketcarga(numeroViaje, new Carga(1, 10.0));
		} catch (TipoTicketInvalidoExcption | CapacidadExcedidaException | NoSeEncontroUnViajePorElNumeroDeViaje e) {
			e.printStackTrace();
		}
		
		for (Ticket ticket : empresa.getTickets()) {
			assertEquals(numeroViaje, ticket.getId());
			
			TicketCarga ticketDeCarga = (TicketCarga)ticket;
			assertEquals(ticketDeCarga.getCarga().getPeso(), 10.0, 0.001);
		}
	}

	@Test
	public void queSePuedaRegistrarUnTicketMixtoAUnViaje() {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";



		Double cargaMaxima = 50.0;

		Integer cantidadPasajerosMaximos = 50;
		
		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos,cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Carga carga=new Carga(1, 10.0);
		
		// Completar Test
		
		try {
			empresa.registrarTicketMixto(numeroViaje, pasajero,carga);
		} catch (CantidadPasajeroSobrepasadaException | CapacidadExcedidaException| NoSeEncontroUnViajePorElNumeroDeViaje e) {
			e.printStackTrace();
		}
		
		for (Ticket ticket : empresa.getTickets()) {
			TicketMixto ticketMixto = (TicketMixto)ticket;
			assertEquals(ticketMixto.getCarga().getPeso(), 10.0, 0.001);
			assertEquals(ticketMixto.getPasajero().getDni(), dni);
		}
	}

	@Test (expected = CapacidadExcedidaException.class)
	public void queAlRegistrarUnticketYExcedalaCargaMaximaDelTransporteLanceUnaExceptionCapacidadExcedidaException() throws CapacidadExcedidaException {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";



		Double cargaMaxima = 50.0;

		Integer cantidadPasajerosMaximos = 50;
		
		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos,cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Carga carga=new Carga(1, 51.0);
		
		// Completar Test
		
		try {
			empresa.registrarTicketMixto(numeroViaje, pasajero,carga);
		} catch (CantidadPasajeroSobrepasadaException | NoSeEncontroUnViajePorElNumeroDeViaje e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queSePuedaObtenerUnaListaPasajeroDeUnViajeOrdenadoPorDNIDescendiente() {
		// Desarrollar test
		// Debe invcar el Metodo obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer
		// numeroViaje) y este retorna un Treeset <Pasajero>

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		
		Integer dni1 = 1111;
		String apellido1 = "perez";
		Pasajero pasajero1 = new Pasajero(dni1, apellido1);
		
		Integer dni2 = 2222;
		String apellido2 = "alberto";
		Pasajero pasajero2 = new Pasajero(dni2, apellido2);
		
		Integer dni3 = 3333;
		String apellido3 = "rodriguez";
		Pasajero pasajero3 = new Pasajero(dni3, apellido3);
		
		Integer dni4 = 4444;
		String apellido4 = "ker";
		Pasajero pasajero4 = new Pasajero(dni4, apellido4);
		
		Integer dni5 = 5555;
		String apellido5 = "sanchez";
		Pasajero pasajero5 = new Pasajero(dni5, apellido5);
		
		TreeSet<Pasajero> pasajerosOrdenados = null;
		
		try {
			empresa.registrarTicketPasajero(numeroViaje, pasajero1);
			empresa.registrarTicketPasajero(numeroViaje, pasajero2);
			empresa.registrarTicketPasajero(numeroViaje, pasajero3);
			empresa.registrarTicketPasajero(numeroViaje, pasajero4);
			empresa.registrarTicketPasajero(numeroViaje, pasajero5);
			
			pasajerosOrdenados = empresa.obtenerListaPasajeroOrdenadosPorDNIDescendiente(numeroViaje);
			
		} catch (TipoTicketInvalidoExcption | CantidadPasajeroSobrepasadaException | NoSeEncontroUnViajePorElNumeroDeViaje e) {
			e.printStackTrace();
		}

//		for (Pasajero p : pasajerosOrdenados) {
//			System.out.println(p.toString());      // este muestra cada pasajero y si, esta bien ordenado
//		}
		
		int i = 1;
		for (Pasajero p : pasajerosOrdenados) {
			
			switch (i) {
			case 1:
				assertEquals(p.getDni(), dni5);
				break;
			case 2:
				assertEquals(p.getDni(), dni4);
				break;
			case 3:
				assertEquals(p.getDni(), dni3);
				break;
			case 4:
				assertEquals(p.getDni(), dni2);
				break;
			case 5:
				assertEquals(p.getDni(), dni1);
				break;
			}
			i++;
		}
		
	}

	@Test
	public void queSePuedaObtenerElTotalDeCargasTransportada() {
		// Desarrollar test

	}
}
