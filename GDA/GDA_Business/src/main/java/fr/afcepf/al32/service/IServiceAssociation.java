package fr.afcepf.al32.service;

import java.util.Date;
import java.util.List;


import fr.afcepf.al32.entity.Personne;

public interface IServiceAssociation  {
	
	void ajouterModifierAssociation(Personne a);
	void supprimerAssociation(Long  num);
	Personne rechercheAssociation(Long num);
	List<Personne> rechercheAssociationTypePt( Long param);
	List<Personne> rechercheAssociationTypePays(Long param);
	List<Personne> rechercheAssociationNouvelle();
	List<Personne> rechercheAssociationPxPack(double valParam, double valParam1);
	Personne rechercherParConnexion(String login, String password);
	public void accepterAssociation(Long num, Date dateAcc);
	public void refuserAssociation(Long num, Date dateFin);
	List<Personne> rechercheAssociationValidee();
}

