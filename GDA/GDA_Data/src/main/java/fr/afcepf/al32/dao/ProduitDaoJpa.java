package fr.afcepf.al32.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.Produit;

@Component
@Transactional
public class ProduitDaoJpa implements IProduitDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Produit findOne(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Produit p) {
		if(p.getId()==null) {
			entityManager.persist(p);
		}
		else {
			entityManager.merge(p);
		}
	}

	@Override
	public void delete(Long numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> produitParType(Long idTypeProduit) {	
		return entityManager.createNamedQuery("Produit.findByTypeProduit",Produit.class)
				.setParameter("idTypeProduit", idTypeProduit)
				.getResultList();
	}	
	
    @Override
	public List<Produit> packAvecProduits(Long idPack) {
		String jpaRequest="SELECT pr FROM Produit pr JOIN pr.packs pa"
		        + " WHERE pa.id = :idPack";			
		return entityManager.createQuery(jpaRequest,Produit.class)
	            .setParameter("idPack",idPack)
	            .getResultList();
	}

}
