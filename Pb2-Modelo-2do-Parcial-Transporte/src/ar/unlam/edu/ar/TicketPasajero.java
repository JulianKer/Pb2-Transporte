package ar.unlam.edu.ar;

public class TicketPasajero extends Ticket {
	
	private Pasajero pasajero;

	public TicketPasajero(Integer numeroDeViaje, Pasajero pasajero) {
		super(numeroDeViaje);
		this.pasajero = pasajero;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
}
