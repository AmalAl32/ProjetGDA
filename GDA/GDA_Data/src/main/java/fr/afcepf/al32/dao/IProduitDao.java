package fr.afcepf.al32.dao;

import java.util.List;
import fr.afcepf.al32.entity.Produit;

public interface IProduitDao extends IGenericDao<Produit>{	
	List<Produit> produitParType(Long idTypeProduit);
	List<Produit> packAvecProduits(Long idPack);
}
