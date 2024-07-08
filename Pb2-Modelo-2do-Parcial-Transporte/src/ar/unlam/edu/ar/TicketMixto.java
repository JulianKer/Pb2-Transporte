package ar.unlam.edu.ar;

public class TicketMixto extends Ticket {
	private Carga carga;
	private Pasajero pasajero;
	
	public TicketMixto(Integer numeroDeViaje, Carga carga, Pasajero pasajero) {
		super(numeroDeViaje);
		this.carga = carga;
		this.pasajero = pasajero;
	}

	
	// getters y setters
	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	
	
	
}
