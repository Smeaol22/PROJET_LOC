package fr.projet_loc.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class Recettes implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private Integer id;

	@NotEmpty
	private String titre;
	@NotEmpty
	private String recettes;

	@Min(value = 0, message = "erreur min")
	@Max(value = 5, message = "erreur max")
	private Integer difficultes; 
	
	@Min(value = 1, message = "erreur min")
	@Max(value = 3, message = "erreur max")
	private Integer types;

	private Boolean veg;

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
		if (!(obj instanceof Recettes)) {
			return false;
		}
		Recettes other = (Recettes) obj;
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @return the recettes
	 */
	public String getRecettes() {
		return recettes;
	}
	
	/**
	 * @return the difficultes
	 */
	public Integer getDifficultes() {
		return difficultes;
	}

	/**
	 * @return the difficultes
	 */
	public Integer getTypes() {
		return types;
	}

	/**
	 * @return the veg
	 */
	public Boolean getVeg() {
		return veg;
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
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	/**
	 * @param recettes
	 *            the recettes to set
	 */
	public void setRecettes(String recettes) {
		this.recettes = recettes;
	}
	
	/**
	 * @param difficultes
	 *            the difficultes to set
	 */
	public void setDifficultes(Integer difficultes) {
		this.difficultes = difficultes;
	}
	
	/**
	 * @param types
	 *            the types to set
	 */
	public void setTypes(Integer types) {
		this.types = types;
	}
	
	/**
	 * @param veg
	 *            the veg to set
	 */
	public void setVeg(Boolean veg) {
		this.veg = veg;
	}

	

	
	/**
	 * Affichage d'une recette en chaine de caractères avec options.
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append(" id=").append(this.id != null ? this.id : "null");
		sb.append(", titre=").append(this.titre != null ? this.titre : "null");
		sb.append(", recettes=").append(this.recettes != null ? this.recettes : "null");
		sb.append(", difficultes=").append(this.difficultes != null ? this.difficultes : "null");
		sb.append(", types=").append(this.types != null ? this.types : "null");
		sb.append(", veg=").append(this.veg != null ? this.veg : "null");
		sb.append(" }");
		return sb.toString();
	}
}
