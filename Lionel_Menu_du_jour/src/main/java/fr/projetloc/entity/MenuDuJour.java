package fr.projetloc.entity;

import java.io.Serializable;

public class MenuDuJour implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String titre;
	
	private String recettes;

	private Integer difficultes;
	
	private Integer types;

	private Boolean veg;

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((veg == null) ? 0 : veg.hashCode());
		result = prime * result + ((difficultes == null) ? 0 : difficultes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		result = prime * result + ((recettes == null) ? 0 : recettes.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		MenuDuJour other = (MenuDuJour) obj;
		if (veg == null) {
			if (other.veg != null)
				return false;
		} else if (!veg.equals(other.veg))
			return false;
		if (difficultes == null) {
			if (other.difficultes != null)
				return false;
		} else if (!difficultes.equals(other.difficultes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		if (recettes == null) {
			if (other.recettes != null)
				return false;
		} else if (!recettes.equals(other.recettes))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}


	/**
	 * @param noms the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}


	/**
	 * @return the recettes
	 */
	public String getRecettes() {
		return recettes;
	}


	/**
	 * @param recettes the recettes to set
	 */
	public void setRecettes(String recettes) {
		this.recettes = recettes;
	}


	/**
	 * @return the difficultes
	 */
	public Integer getDifficultes() {
		return difficultes;
	}


	/**
	 * @param difficultes the difficultes to set
	 */
	public void setDifficultes(Integer difficultes) {
		this.difficultes = difficultes;
	}


	/**
	 * @return the types
	 */
	public Integer getTypes() {
		return types;
	}


	/**
	 * @param types the types to set
	 */
	public void setTypes(Integer types) {
		this.types = types;
	}


	/**
	 * @return the veg
	 */
	public Boolean getVeg() {
		return veg;
	}


	/**
	 * @param veg the veg to set
	 */
	public void setVeg(Boolean veg) {
		this.veg = veg;
	}

	/**
	 * Affichage d'un recette en chaine de caractères.
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
