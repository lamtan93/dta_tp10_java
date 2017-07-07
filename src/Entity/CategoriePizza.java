package Entity;

public enum CategoriePizza {

	VIANDE("Viande"), FROMAGE ("Fromage"), VEGETARIEN("Végétatarien");  
   
	private String libelle;
	
	 private CategoriePizza(String libelle){
		 this.libelle = libelle;
	 }

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	 
	public static CategoriePizza valueByLabel(String label){
		for (CategoriePizza categ: values()){
			if (categ.getLibelle().equals(label)){
				return categ;
			}
		}
		return null;
	}
}
