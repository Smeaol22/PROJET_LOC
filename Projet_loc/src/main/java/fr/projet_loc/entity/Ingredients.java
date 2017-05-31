package fr.projet_loc.entity;

import java.io.Serializable;

public class Ingredients implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String noms;

	private Integer Unit;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Ingredients)) {
			return false;
		}
		Ingredients other = (Ingredients) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
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
		return Unit;
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
	public void setUnit(Integer Unit) {
		this.Unit = Unit;
	}

	
	
	
	
	/**
	 * Affichage d'un Ingredients en chaine de caractères.
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append(" id=").append(this.id != null ? this.id : "null");
		sb.append(", noms=").append(this.noms != null ? this.noms : "null");
		sb.append(", Unit=").append(this.Unit != null ? this.Unit : "null");
		sb.append(" }");
		return sb.toString();
	}

}
