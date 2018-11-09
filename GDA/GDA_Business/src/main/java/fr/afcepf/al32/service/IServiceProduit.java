package fr.afcepf.al32.service;

import java.util.List;

import fr.afcepf.al32.entity.Produit;

public interface IServiceProduit {
	List<Produit> rechercherProduitDuType(long idTypeProduit);
	void ajouterProduit(Produit p);	
	List<Produit> rechercherPackAvecProduits(long idPack);
}
