package entity;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	@ToString
	private int id;
	
	@ToString
	private String code;
	
	@ToString
	private String nom;
	@ToString
	private double prix;
	
	@Column(name = "categorie", nullable = true)
	@Enumerated
	@ToString
	private CategoriePizza categoriePizza;

	public Pizza() {
	}

	private static final Logger LOG = LoggerFactory.getLogger(Pizza.class);

	public Pizza(Integer index, String code, String nom, double prix, CategoriePizza categoriePizza) {

		this.id = index;
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
			LOG.info("Une erreur s'est produite " + e.getMessage());
            return "";
        }
        return chaine;
    }
	
	
	public Integer getIndex() {
		return id;
	}

	public void setIndex(Integer index) {
		this.id = index;
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
