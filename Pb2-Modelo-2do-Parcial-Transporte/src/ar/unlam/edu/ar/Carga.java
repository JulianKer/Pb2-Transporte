package ar.unlam.edu.ar;

public class Carga {

	private Integer id;
	private Double peso;
	
	public Carga(Integer id, Double peso) {
		super();
		this.id = id;
		this.peso = peso;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
}
