package fr.afcepf.al32.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Adresse implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String pays;
	private String ville;
	private String numeroVoie;
	private String typeVoie;
	private String nomVoie;
	private String codePostal;
	
	@OneToOne
	private Personne personne;
	
}
