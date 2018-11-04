package fr.afcepf.al32.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.entity.Produit;
import fr.afcepf.al32.service.IServicePack;
import fr.afcepf.al32.service.IServicePackAssociation;
import fr.afcepf.al32.service.IServiceProduit;

@ManagedBean  
@SessionScoped
public class PackFiltrageBean {
	
	@ManagedProperty("#{servicePackAssociation}")	
	private IServicePackAssociation servicePackAssociation;
	
	@ManagedProperty("#{serviceProduitImpl}")	
	private IServiceProduit serviceProduit;		
	
	List<Pack> listePacks;	
	List<Produit> listeProduits;
	@Autowired
	private PackAssociation selectedPackAssociation; 
	
	
	public String recupererPacks(String typeRecherche) {		
		String suite=null;	
		if (typeRecherche.equals("parTypeProduit")) {
			Long typeProduit = 1L;			
			listePacks = servicePackAssociation.rechercherPackAssociationParType(typeProduit);		
		}
		else {
			listePacks = servicePackAssociation.rechercherPackAssociationParAssociation(1L);			
		}
		for (Pack packAssociation : listePacks) {
			packAssociation.setProduits(serviceProduit.rechercherPackAvecProduits(packAssociation.getId()));
		}
		//listeProduits = serviceProduit.rechercherPackAvecProduits(1);	
		
		suite="listePacksAssociation";
		return suite;
	}
	
	//Pack possede des produits
	public String recupererListeProduits() {		
		String suite=null;
		System.out.println("id pack " + selectedPackAssociation.getId());
		listeProduits = serviceProduit.rechercherPackAvecProduits(selectedPackAssociation.getId());	
		System.out.println("taille listeProduits: " + listeProduits.size());
		System.out.println("contenue listeProduits: " + listeProduits.toString() );
		suite="testListe";
		return suite;
	}
	
	
//	public String recupererPacksParTypeProduit() {		
//		Long typeProduit = 1L;
//		String suite=null;
//		
//		listePacks = servicePackAssociation.rechercherPackAssociationParType(typeProduit);
//		
//		suite="listePacksAssociation";
//	    return suite;
//	}

	public IServiceProduit getServiceProduit() {
		return serviceProduit;
	}

	public void setServiceProduit(IServiceProduit serviceProduit) {
		this.serviceProduit = serviceProduit;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	

	public IServicePackAssociation getServicePackAssociation() {
		return servicePackAssociation;
	}

	public void setServicePackAssociation(IServicePackAssociation servicePackAssociation) {
		this.servicePackAssociation = servicePackAssociation;
	}

	public List<Pack> getListePacks() {
		return listePacks;
	}

	public void setListePacks(List<Pack> listePacks) {
		this.listePacks = listePacks;
	}

	public PackAssociation getSelectedPackAssociation() {
		return selectedPackAssociation;
	}

	public void setSelectedPackAssociation(PackAssociation selectedPackAssociation) {
		this.selectedPackAssociation = selectedPackAssociation;
	}
	

}
