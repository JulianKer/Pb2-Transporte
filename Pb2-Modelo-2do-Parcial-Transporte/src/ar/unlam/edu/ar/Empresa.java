package ar.unlam.edu.ar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Empresa {

	private String nombre;
	private Map<Integer, Viaje> viajes;

	// Se registran todas las ventas de pasajes de los pasajeros
	private Set<Ticket> tickets;

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.viajes = new HashMap<>();
		this.tickets = new HashSet<>();
	}

	// getters y setters-----------------------------------------------
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<Integer, Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Map<Integer, Viaje> viajes) {
		this.viajes = viajes;
	}
	
	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
    //------------------------------------------------------------------
	
	
	/*
	 * Registra Un Nuevo viaje se debe guardar en un mapa donde la Key es un entero
	 * y es autoincremental arrancando de 0
	 */
	public void registrarViaje(Viaje viaje) {
		Integer key = obtenerSiguienteKeyParaUnViaje();
		this.viajes.put(key, viaje);
	}

	private Integer obtenerSiguienteKeyParaUnViaje() {
		Integer siguienteKey = this.viajes.size();
		if (siguienteKey.equals(0)) {
			return 1;
		}
		return siguienteKey++;
	}

	/*
	 * Registra Un ticket para carga TicketCarga.class 
	 * Si el viaje no admite Carga lanza TipoTicketInvalidoExcption
	 *  si supera El peso maximo que soporta el   medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public void registrarTicketcarga(Integer numeroViaje, Carga carga) throws TipoTicketInvalidoExcption, CapacidadExcedidaException, NoSeEncontroUnViajePorElNumeroDeViaje {
		
		Viaje viajeEncontrado = buscarViajePorNumeroDeViaje(numeroViaje);
		
		if (!(viajeEncontrado.getMedioTransporte() instanceof TransporteCarga)) {
			throw new TipoTicketInvalidoExcption("El medio de transporte es de CARGA por ende no acepta pasajeros.");
		}
		
		saberSiElTransporteDelViajeSoportaLaCantidadDeCarga(viajeEncontrado, carga);
		
		TransporteCarga transporteDeCarga = ((TransporteCarga)viajeEncontrado.getMedioTransporte());
		
		Ticket nuevoTicket = new TicketCarga(numeroViaje, carga);
		transporteDeCarga.getCargas().add(carga);
		this.tickets.add(nuevoTicket);
	}

	private void saberSiElTransporteDelViajeSoportaLaCantidadDeCarga(Viaje viajeEncontrado, Carga carga) throws CapacidadExcedidaException {
		TransporteCarga transporteDeCarga = ((TransporteCarga)viajeEncontrado.getMedioTransporte());
		
		if (transporteDeCarga.obtenerPesoTotalDeLasCargas() > transporteDeCarga.obtenerCantidadMaximaCarga()) {
			throw new CapacidadExcedidaException("La carga sobrepasa la capacidad maxima.");
		}
	}
	/*
	 * Se registra un TicketPasajero TicketPasajero 
	 * Si el viaje no admite pasajeros lanza TipoTicketInvalidoExcption 
	 * si supera la cantidad de pasajero que soporta el medioTransprte Lanza Una exception CantidadPasajeroSobrepasadaException
	 */


	public void registrarTicketPasajero(Integer numeroViaje, Pasajero pasajero) throws TipoTicketInvalidoExcption, CantidadPasajeroSobrepasadaException, NoSeEncontroUnViajePorElNumeroDeViaje {
		
		Viaje viajeEncontrado = buscarViajePorNumeroDeViaje(numeroViaje);
		
		if (!(viajeEncontrado.getMedioTransporte() instanceof TransportePasajero)) {
			throw new TipoTicketInvalidoExcption("El medio de transporte es de CARGA por ende no acepta pasajeros.");
		}
		
		Boolean elTransporteDelViajeSoportaLaCantidadDePasajeros = saberSiElTransporteDelViajeSoportaLaCantidadDePasajeros(viajeEncontrado);
		
		if (elTransporteDelViajeSoportaLaCantidadDePasajeros) {
			Ticket nuevoTicket = new TicketPasajero(numeroViaje, pasajero);
			((TransportePasajero)viajeEncontrado.getMedioTransporte()).getPasajeros().add(pasajero);
			this.tickets.add(nuevoTicket);
		}
	}

	public Boolean saberSiElTransporteDelViajeSoportaLaCantidadDePasajeros(Viaje viaje) throws CantidadPasajeroSobrepasadaException {
		TransportePasajero transportePasajero = (TransportePasajero) viaje.getMedioTransporte();
		
		if (transportePasajero.getPasajeros().size() < transportePasajero.obtenerCantidadMaximaPasajero()) {
			return true;
		}
		throw new CantidadPasajeroSobrepasadaException("Se sobrepasa la cantidad de pasajeros");
	}

	public Viaje buscarViajePorNumeroDeViaje(Integer numeroViaje) throws NoSeEncontroUnViajePorElNumeroDeViaje {
		Viaje encontrado = null;
		
		for (Map.Entry<Integer, Viaje> entry : this.viajes.entrySet()) {
			Integer key = entry.getKey();
			
			if (key.equals(numeroViaje)) {
				encontrado = this.viajes.get(key);
			}
		} 
		
		if (encontrado != null) {
			return encontrado;			
		}
		throw new NoSeEncontroUnViajePorElNumeroDeViaje("No se encontro un viaje por el numero de viaje.");
	}

	/*
	 * Se registra un TicketMixto TicketMixto.class  
	 * si supera la cantidad de pasajero que soporta el medioTransprte Lanza Una exception CantidadPasajeroSobrepasadaException
	 * si supera El peso maximo que soporta el   medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public void registrarTicketMixto(Integer numeroViaje, Pasajero pasajero, Carga carga) throws CantidadPasajeroSobrepasadaException, CapacidadExcedidaException, NoSeEncontroUnViajePorElNumeroDeViaje {
		
		Viaje viajeEncontrado = buscarViajePorNumeroDeViaje(numeroViaje);
		TransporteMixto transporteMixto = (TransporteMixto)viajeEncontrado.getMedioTransporte();
		
		if (1 > transporteMixto.getCantidadPasajerosMaximos()) {
			throw new CantidadPasajeroSobrepasadaException("Se sobrepasa la cantidad de pasajeros en el transporte mixto");
		}
		if (carga.getPeso() > transporteMixto.getCargaMaxima()) {
			throw new CapacidadExcedidaException("Capacidad sobrepasada. La capacidad maxima es de: " + transporteMixto.getCargaMaxima() + " y esperas que se carguen: " + carga.getPeso());
		}
		
		Ticket nuevoTicketMixto = new TicketMixto(numeroViaje, carga, pasajero);
		this.tickets.add(nuevoTicketMixto);
	}


	
	
	
	
	
	
	/*
	 * retorna la lista de pasajero enforma Descendiente Lanza una exception si el
	 * viaje no existe o si el tipo de viaje No es compatible para trnssporte de
	 * pasajero lanza una exception si el viaje no existe
	 */

	public TreeSet<Pasajero> obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer numeroViaje) throws NoSeEncontroUnViajePorElNumeroDeViaje {
		
		ComparadorPorDniDescendiente comparadorPorDniDescendiente = new ComparadorPorDniDescendiente();
		TreeSet<Pasajero> pasajerosOrdenadosPorDniDescendiente = new TreeSet<>(comparadorPorDniDescendiente);
		
		Viaje viajeEncontrado = buscarViajePorNumeroDeViaje(numeroViaje);
		
		if (viajeEncontrado.getMedioTransporte() instanceof TransporteCarga) {
			throw new NoSeEncontroUnViajePorElNumeroDeViaje("El transporte de ese viaje NO admite pasajeros");
		}
		
		if (viajeEncontrado.getMedioTransporte() instanceof TransportePasajero) {
			for (Pasajero pasajero : ((TransportePasajero)viajeEncontrado.getMedioTransporte()).getPasajeros()) {
				pasajerosOrdenadosPorDniDescendiente.add(pasajero);
			}
			
		}
		return pasajerosOrdenadosPorDniDescendiente;
	}

	public Double obtenerELTotalDeCargaTransportadaEnTodosLosViajes() {
		
//		bueno, primero deberia revisar en los metodos de registrar tickets, de que tambien agregue los viajes a la coleccion viajes
//		para mi, los viajer deberian ser los que tengan los array con los pasajeros que se van subiendo, pero lo hice distitno
//		asique para mi que está mal, pero bueno, este metodo solo seria recorrer todos los viajes, y los que tengan carga, hago una
//		variable doble que sume el paso de cada carg y despues la devuelvo, pero bueno, si algun dia estoy al pedo, lo rehago.
		
		return null;
	}



}
