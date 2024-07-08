package ar.unlam.edu.ar;
 
// nose si esta bien esto de implementar las dos interfaces, pasa que las dos tenian el mismo metodo, asiq se lo modifique 
// segun mi logica
public class TransporteMixto extends MedioTransporte implements iCargable, ITransportable{

	/*
	 * No se pueden agregar mas Atributos
	 */
	private Integer cantidadPasajerosMaximos;
	private Double cargaMaxima;
 
	public TransporteMixto(String patente, Integer cantidadPasajerosMaximos, Double cargaMaxima) {
		super(patente);
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
		this.cargaMaxima = cargaMaxima;
	}

	
	
	
	
	// getters y setters
	public Integer getCantidadPasajerosMaximos() {
		return cantidadPasajerosMaximos;
	}

	public void setCantidadPasajerosMaximos(Integer cantidadPasajerosMaximos) {
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
	}

	public Double getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(Double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	// metodos de las interfaces implementadas
	@Override
	public Integer obtenerCantidadMaximaPasajero() {
		return getCantidadPasajerosMaximos();
	}

	@Override
	public Double obtenerCantidadMaximaCarga() {
		return getCargaMaxima();
	}
}
