package fr.afcepf.al32.entity;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeProduit",
                     discriminatorType=DiscriminatorType.STRING)
@Table(name="Produit")
@NamedQueries({
	@NamedQuery(name="Produit.findByTypeProduit", 
			query="SELECT prod FROM TypeProduit t INNER JOIN t.produits prod WHERE t.id = :idTypeProduit")	
})
public abstract class Produit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String libelle;
	private String libelleCourt;
	private Double prix;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="idTypeProduit")
	private TypeProduit typeProduit;
	
	@ManyToMany(mappedBy="produits")
	private List<Pack> packs;	
	
	
	public Produit(String libelle, String libelleCourt, Double prix, String description) {		
		this.libelle = libelle;
		this.libelleCourt = libelleCourt;
		this.prix = prix;
		this.description = description;
	}


	
	
}
