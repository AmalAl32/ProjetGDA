package fr.afcepf.al32.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TypeProduit implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String Type;
	
	@ManyToMany(mappedBy="typeProduits")
	private List<Association> associations;
	
	@OneToMany(mappedBy="typeProduit",fetch=FetchType.LAZY)//mappedBy = nom "java" de la relation inverse 
	private List<Produit> produits;
	
	@OneToMany(mappedBy="typeProduit",fetch=FetchType.LAZY)//mappedBy = nom "java" de la relation inverse 
	private List<Pack> packs;
}
