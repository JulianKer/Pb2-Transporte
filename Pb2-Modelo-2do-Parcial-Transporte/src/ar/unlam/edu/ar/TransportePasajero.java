package ar.unlam.edu.ar;

import java.util.HashSet;
import java.util.Set;

public class TransportePasajero extends MedioTransporte implements ITransportable{

	
	private Integer cantidadPasajerosMaximos;
	private Set<Pasajero> pasajeros;
	
	public TransportePasajero(String patente, Integer cantidadPasajerosMaximos) {
		super(patente);
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
		this.pasajeros = new HashSet<>();
	}
	
	
	// getters y setters
	public Integer getCantidadPasajerosMaximos() {
		return cantidadPasajerosMaximos;
	}

	public void setCantidadDePasajerosMaximos(Integer cantidadDePasajeros) {
		this.cantidadPasajerosMaximos = cantidadDePasajeros;
	}
	
	public Set<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public void setCantidadPasajerosMaximos(Integer cantidadPasajerosMaximos) {
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
	}
	
	
	

	// metodo de interface
	@Override
	public Integer obtenerCantidadMaximaPasajero() {
		return getCantidadPasajerosMaximos();
	}
	
}
