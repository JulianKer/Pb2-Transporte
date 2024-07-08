package ar.unlam.edu.ar;

public class TicketCarga extends Ticket{

	private Carga carga;

	public TicketCarga(Integer id, Carga carga) {
		super(id);
		this.carga = carga;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}
}
