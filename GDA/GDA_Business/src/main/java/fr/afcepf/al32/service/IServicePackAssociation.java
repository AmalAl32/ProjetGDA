package fr.afcepf.al32.service;

import java.util.List;

import fr.afcepf.al32.entity.Pack;


public interface IServicePackAssociation {

	void ajouterPackAssociation(Pack p);		
	Pack rechercherPackAssociationParNumero(Long num);
	List<Pack> rechercherPackAssociation();	
	List<Pack> rechercherPackAssociationParType(Long idType);
	List<Pack> rechercherPackAssociationParAssociation(Long id);
	List<Pack> rechercherPackAssociationParAssociationEtType(Long id, Long idType);
	void desactiverPackAssociation(Long num);
}
