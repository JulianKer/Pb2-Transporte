package ar.unlam.edu.ar;

import java.time.LocalDateTime;

public class Viaje {
	
	private LocalDateTime salida; 
	private LocalDateTime llegada;  
	private String origen;  
	private String destino;
	private MedioTransporte medioTransporte;
	
	
	public Viaje(LocalDateTime salida, LocalDateTime llegada, String origen, String destino,
			MedioTransporte medioTransporte) {
		
		this.salida = salida;
		this.llegada = llegada;
		this.origen = origen;
		this.destino = destino;
		this.medioTransporte = medioTransporte;
			
	}
	public LocalDateTime getSalida() {
		return salida;
	}
	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}
	public LocalDateTime getLlegada() {
		return llegada;
	}
	public void setLlegada(LocalDateTime llegada) {
		this.llegada = llegada;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public MedioTransporte getMedioTransporte() {
		return medioTransporte;
	}
	public void setMedioTransporte(MedioTransporte medioTransporte) {
		this.medioTransporte = medioTransporte;
	}
	
	
	

}
