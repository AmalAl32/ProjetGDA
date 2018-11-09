package fr.afcepf.al32.service;

import fr.afcepf.al32.entity.Personne;

public interface IServiceAdministrateur {
	void ajouterModifierAdmin(Personne a);
	void supprimerAdmin(Long  num);
	Personne rechercheAdmin(Long num);
	Personne rechercherParConnexion(String login, String password);
}
