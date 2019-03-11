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

import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Produit;
import fr.afcepf.al32.service.IServiceAdministrateur;
import fr.afcepf.al32.service.IServicePack;
import fr.afcepf.al32.service.IServicePackAssociation;
import fr.afcepf.al32.service.IServiceProduit;


@ManagedBean 
@RequestScoped 
public class FaireUnDonBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private long selectAssociation;
	
	
//	@PostConstruct
//	public void Init()
//	{
//		
//	}
	
	@PostConstruct
	public void init()
	{	
		
	}

	public long getSelectAssociation() {
		return selectAssociation;
	}

	public void setSelectAssociation(long selectAssociation) {
		this.selectAssociation = selectAssociation;
	}

	//Ouvrir AssociationDetail
	public String ouvrirPageDetail () {	
		System.out.println("id association" + selectAssociation);
		String suite="associationDetails";
		return suite;
	}
	
	

	


	
}

	
	
	

