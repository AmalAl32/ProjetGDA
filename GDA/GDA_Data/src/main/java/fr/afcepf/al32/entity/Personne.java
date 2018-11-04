package fr.afcepf.al32.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity
@NamedQueries({
	@NamedQuery(name="Administrateur.Connexion", query="SELECT a FROM Administrateur a "
															+ "WHERE a.connexion.password = :password "
															+ "and a.connexion.login = :login "),
	@NamedQuery(name="Association.Connexion", query="SELECT a FROM Association a "
															+ "WHERE a.connexion.password = :password "
															+ "and a.connexion.login = :login "),
	@NamedQuery(name="Donateur.Connexion", query="SELECT d FROM Donateur d "
															+ "WHERE d.connexion.password = :password "
															+ "and d.connexion.login = :login "),
	@NamedQuery(name="Donateur.All", query="SELECT d FROM Donateur d "),
	@NamedQuery(name="Personne.Connexion", query="SELECT p FROM Personne p "
															+ "WHERE p.connexion.password = :password "
															+ "and p.connexion.login = :login ")
			
})
@Table(name="Personne")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typePersonne",
                     discriminatorType=DiscriminatorType.STRING)
public abstract class Personne implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String prenom;
	
	private String nom;
	
	private String email;
	
	private String telephone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idConnexion")
	private Connexion connexion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idAdresse")
	private Adresse adresse;
	
	public Personne(String prenom, String nom, String email, String telephone, Adresse adresse) {
		
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
	}
}