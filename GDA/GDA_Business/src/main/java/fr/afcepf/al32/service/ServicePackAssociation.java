package fr.afcepf.al32.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.IPackDao;
import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Personne;


@Component 
@Transactional
public class ServicePackAssociation implements IServicePackAssociation {
	
	@Autowired 
	private IPackDao packDao=null;	

//	public void setPackDao(IPackDao packDao) {
//		this.packDao = packDao;
//	}
	
	@Override
	public void ajouterPackAssociation(Pack p) {
		packDao.save(p);
	}	
	

	@Override
	public Pack rechercherPackAssociationParNumero(Long num) {		
		
		Pack p = packDao.findOne(num);
		if(p instanceof PackAssociation)
		{
			return p;
		}else return null;
	}
		
	@Override  
	public List<Pack> rechercherPackAssociation() {		
		return packDao.findAllPack();		
	}


	@Override
	public List<Pack> rechercherPackAssociationParType(Long idType) {
		return packDao.findAllPackByType(idType);
	}


	@Override
	public List<Pack> rechercherPackAssociationParAssociation(Long id) {
		return packDao.findAllPackByAssociation(id);
	}


	@Override
	public List<Pack> rechercherPackAssociationParAssociationEtType(Long id, Long idType) {
		return packDao.findAllPackByAssociationAndType(id, idType);
	}


	@Override
	public void desactiverPackAssociation(Long num) {
		
		PackAssociation p = (PackAssociation) packDao.findOne(num);
		Timestamp dtefin = new Timestamp( System.currentTimeMillis() );
		p.setDateRetrait(dtefin);
		packDao.save(p);
		System.out.println("j essaye de supprimer");
	}


}
