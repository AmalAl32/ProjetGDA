package fr.afcepf.al32.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("PackDonateur")
public class PackDonateur extends Pack implements Serializable{
	 private Date dateModification;
	
	 @ManyToOne
	 @JoinColumn(name="idPackAssociation") 
	 private PackAssociation packAssociation;
	 
	 public PackDonateur(){		 
	 } 
	
	 public PackDonateur(String libelle, Double prix, PackAssociation packAssociation) {
		super(libelle, prix);
		this.packAssociation = packAssociation;
		this.dateModification = new Timestamp( System.currentTimeMillis() );
	 }
	 
	 public PackDonateur(String libelle, Double prix, PackAssociation packAssociation, TypeProduit typeProduit, List<Produit> produits) {
			super(libelle, prix, typeProduit, produits);
			this.packAssociation = packAssociation;
			this.dateModification = new Timestamp( System.currentTimeMillis() );		
	 }
}
