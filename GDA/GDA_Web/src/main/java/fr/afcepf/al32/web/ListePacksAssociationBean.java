package fr.afcepf.al32.web;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Produit;
import fr.afcepf.al32.service.IServiceAdministrateur;
import fr.afcepf.al32.service.IServicePack;
import fr.afcepf.al32.service.IServiceProduit;


@ManagedBean 
@RequestScoped 
public class ListePacksAssociationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value ="#{servicePackImpl}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServicePack servicePack;
	
	@ManagedProperty(value ="#{serviceProduitImpl}")	
	private IServiceProduit serviceProduit;	
	
	@ManagedProperty(value = "#{connexionBean}")
	private ConnexionBean user;

	private List<PackAssociation> packs;
	List<Produit> listeProduits;
	private Long idAssoc ;
	@Autowired
	private Pack selectPack;
	
	
//	@PostConstruct
//	public void Init()
//	{
//		
//	}
	
	@PostConstruct
	public void init()
	{	
		idAssoc =  (Long)user.getUtilisateur().getId();
		packs = servicePack.rechercherPackAssociationParAssociation(idAssoc);
	}

	//Pack possede des produits
	public String recupererListeProduits() {		
		String suite=null;
		System.out.println("recuprer liste produit");
		System.out.println("id pack " + selectPack.getId());
		listeProduits = serviceProduit.rechercherPackAvecProduits(selectPack.getId());	
		System.out.println("taille listeProduits: " + listeProduits.size());
		System.out.println("contenue listeProduits: " + listeProduits.toString() );
		suite="testListe";
		return suite;
	}
	
	public String supprimerPack()
	{
		String suite=null;	
		System.out.println("id pack sup " + selectPack.getId() );
		servicePack.desactiverPack(selectPack.getId());
		return suite;
	}

	public IServicePack getServicePack() {
		return servicePack;
	}



	public void setServicePack(IServicePack servicePack) {
		this.servicePack = servicePack;
	}



	public List<PackAssociation> getPacks() {
		return packs;
	}



	public void setPacks(List<PackAssociation> packs) {
		this.packs = packs;
	}

	public ConnexionBean getUser() {
		return user;
	}

	public void setUser(ConnexionBean user) {
		this.user = user;
	}

	public Long getIdAssoc() {
		return idAssoc;
	}

	public void setIdAssoc(Long idAssoc) {
		this.idAssoc = idAssoc;
	}

	public Pack getSelectPack() {
		return selectPack;
	}

	public void setSelectPack(Pack selectPack) {
		this.selectPack = selectPack;
	}

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

	
}

	
	
	

