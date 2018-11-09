package fr.afcepf.al32.dao;

import java.util.List;

import javax.persistence.Query;

import fr.afcepf.al32.entity.Don;
import fr.afcepf.al32.entity.Personne;

public interface IDonDao extends IGenericDao<Don> {

	List<Don> findAllByParam(String hql, String param, Long valParam);
	public List<Don> findAll(String hql) ;
	
}
