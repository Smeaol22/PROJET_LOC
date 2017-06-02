package fr.projet_loc.entity;

import java.io.Serializable;

public class Ingredients implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String noms;

	private Integer unit;

	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((noms == null) ? 0 : noms.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredients other = (Ingredients) obj;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (noms == null) {
			if (other.noms != null)
				return false;
		} else if (!noms.equals(other.noms))
			return false;
		return true;
	}

	

	/*getter*/
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the noms
	 */
	public String getNoms() {
		return noms;
	}

	/**
	 * @return the Unit
	 */
	public Integer getUnit() {
		return unit;
	}

	/*setter*/
	
	
	
	
	
	
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param noms
	 *            the noms to set
	 */
	public void setNoms(String noms) {
		this.noms = noms;
	}

	/**
	 * @param Unit
	 *            the stock to Unit
	 */
	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredients [id=").append(id).append(", noms=").append(noms).append(", unit=").append(unit)
				.append("]");
		return builder.toString();
	}
	

}
