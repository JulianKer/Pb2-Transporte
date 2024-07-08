package ar.unlam.edu.ar;

public abstract class MedioTransporte {

	
	private String patente;

	public MedioTransporte (String patente) {
		this.patente=patente;
	}
	
	
	

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	
	
}
