package fr.afcepf.al32.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;

import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Produit;
import fr.afcepf.al32.service.IServicePackAssociation;
import fr.afcepf.al32.service.IServiceProduit;
import fr.afcepf.al32.service.IServiceTypeProduit;

@ManagedBean
@SessionScoped
public class AccueilAssociationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String libelle;
	
	private String libellePack;
	private Double prix;
	private Double prixPack;
	private List<Produit> produitsSource;
	private List<Produit> produitsPack;
	private Long idTypeProduit;
	
	private DualListModel<Produit> produits;
	
	@ManagedProperty("#{serviceProduitImpl}")
	private IServiceProduit serviceProduit;
	
	@ManagedProperty("#{servicePackAssociation}")
	private IServicePackAssociation servicePackAssociation;
	
	@ManagedProperty("#{serviceTypeProduit}")
	private IServiceTypeProduit serviceTypeProduit;
	
	@PostConstruct
	public void init() {
		//par defaut 0 pour avoir fromulaire vide
		produitsSource = serviceProduit.rechercherProduitDuType(0);
		produitsPack = new ArrayList<Produit>();
		produits = new DualListModel<Produit>(produitsSource, produitsPack);
	}
	
	public void changerTypeProduit(ActionEvent e) {
		System.out.println("changerTypeProduit");
		produitsSource = serviceProduit.rechercherProduitDuType(idTypeProduit);
		produitsPack = new ArrayList<Produit>();
		produits = new DualListModel<Produit>(produitsSource, produitsPack);
	}
	
	public void creerPack(ActionEvent e) {
		System.out.println("libellePack : "+ libellePack);
		System.out.println("prixPack : "+ prixPack);
		System.out.println("produitsPack : "+ produitsPack.toString());
		System.out.println("idTypeProduit : "+ idTypeProduit);
		Pack pack = new PackAssociation(libellePack, prixPack);
		pack.setProduits(produitsPack);
		pack.setTypeProduit(serviceTypeProduit.rechercherTypeProduit(idTypeProduit));
		
		servicePackAssociation.ajouterPackAssociation(pack);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public IServiceProduit getServiceProduit() {
		return serviceProduit;
	}

	public void setServiceProduit(IServiceProduit serviceProduit) {
		this.serviceProduit = serviceProduit;
	}

	public DualListModel<Produit> getProduits() {
		return produits;
	}

	public void setProduits(DualListModel<Produit> produits) {
		this.produits = produits;
	}

	

	public IServicePackAssociation getServicePackAssociation() {
		return servicePackAssociation;
	}

	public void setServicePackAssociation(IServicePackAssociation servicePackAssociation) {
		this.servicePackAssociation = servicePackAssociation;
	}

	public IServiceTypeProduit getServiceTypeProduit() {
		return serviceTypeProduit;
	}

	public void setServiceTypeProduit(IServiceTypeProduit serviceTypeProduit) {
		this.serviceTypeProduit = serviceTypeProduit;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getPrixPack() {
		return prixPack;
	}

	public void setPrixPack(Double prixPack) {
		this.prixPack = prixPack;
	}

	public List<Produit> getProduitsSource() {
		return produitsSource;
	}

	public void setProduitsSource(List<Produit> produitsSource) {
		this.produitsSource = produitsSource;
	}

	public List<Produit> getProduitsPack() {
		return produitsPack;
	}

	public void setProduitsPack(List<Produit> produitsPack) {
		this.produitsPack = produitsPack;
	}

	public Long getIdTypeProduit() {
		return idTypeProduit;
	}

	public void setIdTypeProduit(Long idTypeProduit) {
		this.idTypeProduit = idTypeProduit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLibellePack() {
		return libellePack;
	}

	public void setLibellePack(String libellePack) {
		this.libellePack = libellePack;
	}

}
