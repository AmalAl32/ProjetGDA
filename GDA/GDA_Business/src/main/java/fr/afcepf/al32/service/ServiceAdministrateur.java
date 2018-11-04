package fr.afcepf.al32.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al32.dao.IPersonneDao;
import fr.afcepf.al32.entity.Administrateur;
import fr.afcepf.al32.entity.Personne;

@Service
@Transactional
public class ServiceAdministrateur implements IServiceAdministrateur {
	
	@Autowired
	private IPersonneDao personneDao;

	@Override
	public void ajouterModifierAdmin(Personne p) {
		 personneDao.save(p);
	}

	@Override
	public void supprimerAdmin(Long num) {
		personneDao.delete(num);
		
	}

	@Override
	public Personne rechercheAdmin(Long num) {
		Personne p = personneDao.findOne(num);
		if(p instanceof Administrateur)
		{
			return p;
		}else return null;
		
	}


	@Override
	public Personne rechercherParConnexion(String login, String password) {
		System.out.println(personneDao);
		return personneDao.findByConnexion(login, password);
	}
	
	

}
