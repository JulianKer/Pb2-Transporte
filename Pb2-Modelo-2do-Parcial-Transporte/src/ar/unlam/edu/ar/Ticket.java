package ar.unlam.edu.ar;

import java.util.Objects;

public abstract class Ticket {
	
	private Integer id;

	public Ticket(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}
}
