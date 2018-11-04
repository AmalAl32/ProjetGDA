package fr.afcepf.al32.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
		@NamedQuery(name="AssociationParPays", query="SELECT a FROM Association a WHERE a.dateAcceptation is not Null And a.dateFin IS Null  And a.paysAide.id=:idPaysAide")
})							
@Entity
@Getter @Setter @NoArgsConstructor
public class PaysAide implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String libelle;
	
	//Le @OneToMany est l'inverse du @ManyToOne
	@OneToMany(mappedBy="paysAide",fetch=FetchType.LAZY)
	private List<Association> associations;
}
