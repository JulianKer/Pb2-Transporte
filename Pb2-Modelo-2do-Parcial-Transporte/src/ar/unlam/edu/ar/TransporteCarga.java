package ar.unlam.edu.ar;

import java.util.HashSet;

public class TransporteCarga extends MedioTransporte implements iCargable{

	private Double cargaMaxima;
	private HashSet<Carga> cargas;

	public TransporteCarga(String patente, Double cargaMaxima) {
		super(patente);
		this.cargaMaxima = cargaMaxima;
		this.cargas = new HashSet<>();
	}
	
	public Double obtenerPesoTotalDeLasCargas() {
		Double pesoTotal = 0.0;
		for (Carga carga : this.cargas) {
			pesoTotal += carga.getPeso();
		}
		return pesoTotal;
	}
	
	// getters y setters
	public Double getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(Double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	public HashSet<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(HashSet<Carga> cargas) {
		this.cargas = cargas;
	}

	
	// metodo de la interface iCargable
	@Override
	public Double obtenerCantidadMaximaCarga() {
		return getCargaMaxima();
	}
	
}
