package fr.afcepf.al32.web;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServiceAssociation;
import fr.afcepf.al32.service.IServicePack;
import fr.afcepf.al32.service.IServicePersonne;


@ManagedBean 
@RequestScoped 
public class ListeAssociationBean {
	
	@ManagedProperty("#{serviceAssociation}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServiceAssociation serviceAssociation;
	private List<Personne> association;
	/****/
	
	private Long idAssociation= 8L;
	
	
	//private List<PackAssociation> packs;
	//la personne connectée
	private ConnexionBean personne;
	
	
	
//	@PostConstruct
//	public void Init()
//	{
//		
//	}
	
	@PostConstruct
	public void init() {
		
		association = serviceAssociation.rechercheAssociationNouvelle();
		System.out.println("taille packs: " + association.size());
		System.out.println("contenue: " + association.toString() );

	}



	public IServiceAssociation getServiceAssociation() {
		return serviceAssociation;
	}



	public void setServiceAssociation(IServiceAssociation serviceAssociation) {
		this.serviceAssociation = serviceAssociation;
	}



	public List<Personne> getAssociation() {
		return association;
	}



	public void setAssociation(List<Personne> association) {
		this.association = association;
	}



	public Long getIdAssociation() {
		return idAssociation;
	}



	public void setIdAssociation(Long idAssociation) {
		this.idAssociation = idAssociation;
	}



	public ConnexionBean getPersonne() {
		return personne;
	}



	public void setPersonne(ConnexionBean personne) {
		this.personne = personne;
	}
//	public String AfficherListePack()
//	{
//		String suite=null;
//		//List<PackAssociation> packs = servicePack.rechercherPackAssociationParAssociation(8L);
//		//List<PackAssociation> packs = servicePack.rechercherPackAssociation();	
//		List<Personne> packs = servicePersonne.rechercheAssociationNouvelle();
//		suite="ListePacksAssociation";
//		System.out.println("taille : " + packs.size());
//		System.out.println("contenue: " + packs.toString() );
//		// pour naviguer vers comptes.jsf (.xhtml ou .jsp)
//		return suite; 
//		
//	}



}
