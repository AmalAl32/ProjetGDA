package fr.afcepf.al32.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@DiscriminatorValue("F")
public class FournitureScolaire extends Produit implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="idNatureFourniture")
	private NatureFourniture natureFourniture;

	public FournitureScolaire(String libelle, String libelleCourt, Double prix, String description)
	{
		super(libelle, libelleCourt, prix, description);		
	}
	
	public FournitureScolaire() {}

	@Override
	public String toString() {
		return "FournitureScolaire [natureFourniture=" + natureFourniture + "]";
	}	
	
}
