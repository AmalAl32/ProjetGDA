package fr.afcepf.al32.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.IProduitDao;
import fr.afcepf.al32.entity.Produit;

@Component 
@Transactional
public class ServiceProduitImpl implements IServiceProduit {
	
	@Autowired 
	private IProduitDao produitDao=null;

	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;}


	@Override
	public List<Produit> rechercherProduitDuType(long idTypeProduit) {	
		return produitDao.produitParType(idTypeProduit);		
	}
	
	@Override
	public void ajouterProduit(Produit p) {
		produitDao.save(p);
	}
	
	@Override
	public List<Produit> rechercherPackAvecProduits(long idPack) {
		return produitDao.packAvecProduits(idPack);
	}

}
