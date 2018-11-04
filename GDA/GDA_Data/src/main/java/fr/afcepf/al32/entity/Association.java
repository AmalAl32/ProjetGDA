
package fr.afcepf.al32.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@NamedQueries({
	@NamedQuery(name="AssociationNouvelle", query="SELECT a FROM Association a WHERE a.dateAcceptation is Null And a.dateFin IS Null"),
	@NamedQuery(name="AssociationParType", query="SELECT a FROM Association a JOIN a.typeProduits t WHERE a.dateAcceptation is not Null And a.dateFin IS Null And t.id =:id"),
	//@NamedQuery(name="AssociationParPxPack", query="SELECT a FROM Association a JOIN a.packAssociations p WHERE a.dateAcceptation is not Null And a.dateFin IS Null And p.prix  BETWEEN :minPx AND :maxPx ")
	@NamedQuery(name="AssociationValidee", query="SELECT a FROM Association a WHERE a.dateAcceptation is not Null And a.dateFin IS Null")
})													
@Entity
@Getter @Setter
@DiscriminatorValue("Association")//valeur de typePersonne pour cette classe
public class Association extends Personne implements Serializable {

	private String raisonSociale;

	   private String siret;

	   private String ape;

	   private Date dateAcceptation;

	   private Date dateFin;
	   
	   @OneToMany(mappedBy="association",fetch=FetchType.LAZY)
	   private List<PackAssociation> packAssociations;
	   
	   @ManyToMany
		@JoinTable(name="Association_TypeProduit",
		     joinColumns= {@JoinColumn(name="idAssociation")} ,
		     inverseJoinColumns = {@JoinColumn(name="idTypeProduit")})
		private List<TypeProduit> typeProduits;
	   
	   @ManyToOne 
	   @JoinColumn(name="idPaysAide")
	   private PaysAide paysAide;

	@Override
	public String toString() {
		return "Association [raisonSociale=" + raisonSociale + ", siret=" + siret + ", ape=" + ape
				+ ", dateAcceptation=" + dateAcceptation + ", dateFin=" + dateFin + "]" +  super.toString();
	}
	 
	 public Association()
	   {
		  
	   }

	   
	   public Association(String raisonSociale, String siret, String ape)
	   {
		   super();
		   this.raisonSociale = raisonSociale;
		   this.siret=siret;
		   this.ape = ape;
		   
	   }

}