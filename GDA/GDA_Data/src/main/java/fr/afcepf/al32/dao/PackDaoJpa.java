package fr.afcepf.al32.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;

@Component
@Transactional
public class PackDaoJpa implements IPackDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Pack> findAllPack() {
		return entityManager.createNamedQuery("PackAssociationfindAll", Pack.class)
				            .getResultList();			
	}	

	
	@Override
	public List<Pack> findAllPackByType(Long idType) {
		return entityManager.createNamedQuery("PackAssociation.findAllByType", Pack.class)
							.setParameter("idType", idType)
        					.getResultList();		
	}


	@Override
	public List<Pack> findAllPackByAssociation(Long id) {
		return entityManager.createNamedQuery("PackAssociation.findAllByAssociation", Pack.class)
							.setParameter("id", id)
							.getResultList();	
	}


	@Override
	public List<Pack> findAllPackByAssociationAndType(Long id, Long idType) {
		return entityManager.createNamedQuery("PackAssociation.findAllByAssociationAndType", Pack.class)
							.setParameter("idType", idType)
							.setParameter("id", id)
							.getResultList();
	}	

	
	@Override
	public void save(Pack p) {

		if(p.getId()==null) {
			entityManager.persist(p);
		}
		else {
			entityManager.merge(p);
		}
	}

	
	@Override
	public Pack findOne(Long numero) {			
		return entityManager.find(PackAssociation.class, numero);		
	}

	@Override
	public void delete(Long numero) {
		// TODO Auto-generated method stub
	}


	@Override
	public List<Pack> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
