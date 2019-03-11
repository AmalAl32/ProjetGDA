package fr.afcepf.al32.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServiceAssociation;


@ManagedBean  
@RequestScoped
public class AssociationFiltreBean {
	@ManagedProperty("#{serviceAssociation}")	
	private IServiceAssociation serviceAssociation; 
	
	private List<Personne> associationsFiltre;
	private Long idType;
	private Long idPays;
	private double prixMin;
	private double prixMax;
	private Association selectAssociation;
	
	
	@PostConstruct
	public void init() {
		recupererAssociations();
	}
	
	public void recupererAssociations() 
	{
		associationsFiltre = serviceAssociation.rechercheAssociationValidee();
	}
	
	public void recupererAssociationsParType() 
	{
		if(idType!=0)
			associationsFiltre = serviceAssociation.rechercheAssociationTypePt(idType);
		else
			recupererAssociations();
	}
	
	public void recupererAssociationsParPays() 
	{	
		if(idPays!=0)
			associationsFiltre = serviceAssociation.rechercheAssociationTypePays(idPays);
		else
			recupererAssociations();
	}
	
	public void recupererAssociationsParPrix() 
	{	
		associationsFiltre = serviceAssociation.rechercheAssociationPxPack(prixMin, prixMax);
	}

	public List<Personne> getAssociationsFiltre() {
		return associationsFiltre;
	}

	public void setAssociationsFiltre(List<Personne> associationsFiltre) {
		this.associationsFiltre = associationsFiltre;
	}

	public IServiceAssociation getServiceAssociation() {
		return serviceAssociation;
	}

	public void setServiceAssociation(IServiceAssociation serviceAssociation) {
		this.serviceAssociation = serviceAssociation;
	}

	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public Long getIdPays() {
		return idPays;
	}

	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}

	public double getPrixMin() {
		return prixMin;
	}

	public void setPrixMin(double prixMin) {
		this.prixMin = prixMin;
	}

	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public Association getSelectAssociation() {
		return selectAssociation;
	}

	public void setSelectAssociation(Association selectAssociation) {
		this.selectAssociation = selectAssociation;
	}
	
}
