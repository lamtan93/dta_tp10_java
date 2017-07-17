package Entity;

import java.lang.reflect.Field;

public class Pizza {

	@ToString
	private int index;
	
	@ToString
	private String code;
	
	@ToString
	private String nom;
	@ToString
	private double prix;
	@ToString
	private CategoriePizza categoriePizza;

	public Pizza() {
	}

	public Pizza(int index, String code, String nom, double prix, CategoriePizza categoriePizza) {

		this.index = index;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categoriePizza) {

		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}

//	public String toString() {
//		return index + "  " + code + "  " + nom + "    " + prix + "  " + categoriePizza+ "\n" ;
//	}

	//TODO
	public String toString() {
        String chaine = "";
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                ToString annotation = field.getAnnotation(ToString.class);
                if (annotation != null) {
                    chaine += " " + field.get(this).toString();
                }
            }
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite "+e.getMessage());
            return "";
        }
        return chaine;
    }
	
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

}