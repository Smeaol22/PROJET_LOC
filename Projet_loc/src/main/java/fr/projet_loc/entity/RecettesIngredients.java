package fr.projet_loc.entity;

import java.io.Serializable;

public class RecettesIngredients implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Float quantity;

	private Recettes recettes;

	private Ingredients ingredients;

	public RecettesIngredients() {
	}

	public RecettesIngredients(final Recettes recettes, final Ingredients ingredients) {
		this.recettes = recettes;
		this.ingredients = ingredients;
	}

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
		if (!(obj instanceof RecettesIngredients)) {
			return false;
		}
		RecettesIngredients other = (RecettesIngredients) obj;
		if (id == null) {
			// Comparaison par identifiant produit et cocktail.
			if (recettes != null && ingredients != null) {
				if (other.recettes == null || other.ingredients == null) {
					return false;
				} else if (!recettes.getId().equals(other.recettes.getId())) {
					return false;
				} else if (!ingredients.getId().equals(other.ingredients.getId())) {
					return false;
				}
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the quantity
	 */
	public Float getQuantity() {
		return quantity;
	}

	/**
	 * @return the recettes
	 */
	public Recettes getRecettes() {
		return recettes;
	}

	/**
	 * @return the ingredients
	 */
	public Ingredients getIngredients() {
		return ingredients;
	}

	/**
	 * @param id
	 *            the ID to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param recettes
	 *            the RECETTES to set
	 */
	public void setRecettes(Recettes recettes) {
		this.recettes = recettes;
	}

	/**
	 * @param ingredients
	 *            the Ingredients to set
	 */
	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{ ID=");
		sb.append(this.id != null ? this.id : "null");
		sb.append(", RecettesId=").append(this.recettes != null ? this.recettes.getId() : "null");
		sb.append(", IngredientsID=").append(this.ingredients != null ? this.ingredients.getId() : "null");
		sb.append(", quantity=").append(this.quantity != null ? this.quantity : "null");
		sb.append(" }");
		return sb.toString();
	}
}
