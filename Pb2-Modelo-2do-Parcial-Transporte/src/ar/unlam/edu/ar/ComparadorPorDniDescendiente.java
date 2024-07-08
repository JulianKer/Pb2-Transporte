package ar.unlam.edu.ar;

import java.util.Comparator;

public class ComparadorPorDniDescendiente implements Comparator<Pasajero>{

	@Override
	public int compare(Pasajero pasajero1, Pasajero pasajero2) {
		return (pasajero1.getDni().compareTo(pasajero2.getDni()))*(-1);
	}
	
}
