package fr.afcepf.al32.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@NamedQuery(name="AssociationParPxPack", query="SELECT DISTINCT a FROM Association a JOIN a.packAssociations p  "
												+ "WHERE a.dateAcceptation is not Null "
												+ "And a.dateFin IS Null "
												//+ "And p.prix BETWEEN :minPx AND :maxPx ")
												+ "And p.prix >=:minPx And p.prix<=:maxPx ")
@Entity
@Getter @Setter
@DiscriminatorValue("PackAssociation")
public class PackAssociation extends Pack implements Serializable{
	 private Date dateAjout;
	 
	 private Date dateRetrait;
	 
	 @ManyToOne
	 @JoinColumn(name="idAssociation")
	 private Association association;
	 
	 @OneToMany(mappedBy="packAssociation",fetch=FetchType.LAZY)
	 private List<PackDonateur> packDonateurs;
	 
	 public PackAssociation(){		 
	 } 
	
	 public PackAssociation(String libelle, Double prix) {
		super(libelle, prix);
		this.dateAjout = new Timestamp( System.currentTimeMillis() );
	 }
	 
	 public PackAssociation(String libelle, Double prix, TypeProduit typeProduit, List<Produit> produits) {
			super(libelle, prix, typeProduit, produits);
			this.dateAjout = new Timestamp( System.currentTimeMillis() );		
	 }

	@Override
	public String toString() {
		return "PackAssociation [dateAjout=" + dateAjout + ", association=" + association +"]";
//		return "PackAssociation [dateAjout=" + dateAjout + ", association=" + association + ", packDonateurs="
//				+ packDonateurs + "]";
	}	
	
}
