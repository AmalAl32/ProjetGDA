package fr.afcepf.al32.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Administrateur")
@Getter @Setter @NoArgsConstructor
public class Administrateur  extends Personne implements Serializable{

	private Date dateDebut;
	
	private Date dateFin;

	
	public Administrateur(String prenom, String nom, String email, String telephone, Adresse adresse) {
		super(prenom, nom, email, telephone, adresse);
		
	}
	
	@Override
	public String toString() {
		return "Administrateur [dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]" + super.toString();
	}
	
}