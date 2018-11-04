package fr.afcepf.al32.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@DiscriminatorValue("A")
public class Aliment extends Produit implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="idNatureAliment")
	private NatureAliment natureAliment;

	public Aliment() {}

	public Aliment(String libelle, String libelleCourt, Double prix, String description) {
		super(libelle, libelleCourt, prix, description);		
	}

	@Override
	public String toString() {
		return "Aliment [natureAliment=" + natureAliment + "]";
	}	
	
}
