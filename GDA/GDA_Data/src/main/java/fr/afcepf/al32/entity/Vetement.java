package fr.afcepf.al32.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@DiscriminatorValue("V")
public class Vetement extends Produit implements Serializable{
	
	private Boolean sexe;
	private Boolean adulte;
	
	@ManyToOne
	@JoinColumn(name="idNatureVetement")
	private NatureVetement natureVetement;
	
	public Vetement() {}

	public Vetement(String libelle, String libelleCourt, Double prix, String description, Boolean sexe, Boolean adulte) {
		super(libelle, libelleCourt, prix, description);
		this.sexe = sexe;
		this.adulte = adulte;		
	}

	@Override
	public String toString() {
		return "Vetement [sexe=" + sexe + ", adulte=" + adulte + ", natureVetement=" + natureVetement + "]";
	}
	
}
