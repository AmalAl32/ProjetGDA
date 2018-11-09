package fr.afcepf.al32.web;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Produit;
import fr.afcepf.al32.service.IServiceAdministrateur;
import fr.afcepf.al32.service.IServicePack;
import fr.afcepf.al32.service.IServicePackAssociation;
import fr.afcepf.al32.service.IServiceProduit;


@ManagedBean 
@RequestScoped 
public class ListePacksAssociationBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{servicePackAssociation}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServicePackAssociation servicePackAssociation;
	
	@ManagedProperty("#{serviceProduitImpl}")	
	private IServiceProduit serviceProduit;	
	
	@ManagedProperty("#{connexionBean}")
	private ConnexionBean user;

	private List<Pack> packs;
	private boolean ajoutOk =true;
	private List<Produit> listeProduits;
	private Long idAssoc ;
	
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
		packs = servicePackAssociation.rechercherPackAssociationParAssociation(idAssoc);
		if (packs.size()<5)
			ajoutOk =true;
		else ajoutOk=false;
		
		System.out.println("nombre packs : " + packs.size());
	}

	//Pack possede des produits
	public String recupererListeProduits() {		
		String suite=null;
		listeProduits = serviceProduit.rechercherPackAvecProduits(selectPack.getId());
		return suite;
	}
	
	public String supprimerPack()
	{
		String suite=null;	
		System.out.println("id pack sup " + selectPack.getId() );
		servicePackAssociation.desactiverPackAssociation(selectPack.getId());
		return suite;
	}

	

	public IServicePackAssociation getServicePackAssociation() {
		return servicePackAssociation;
	}

	public void setServicePackAssociation(IServicePackAssociation servicePackAssociation) {
		this.servicePackAssociation = servicePackAssociation;
	}

	public List<Pack> getPacks() {
		return packs;
	}

	public void setPacks(List<Pack> packs) {
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

	public boolean isAjoutOk() {
		return ajoutOk;
	}

	public void setAjoutOk(boolean ajoutOk) {
		this.ajoutOk = ajoutOk;
	}



	
}

	
	
	

