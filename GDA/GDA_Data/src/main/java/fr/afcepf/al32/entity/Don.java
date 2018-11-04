package fr.afcepf.al32.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
	@NamedQuery(name="ListeDonDonateur", query="SELECT d FROM Don d WHERE d.donateur.id = :idDonateur")
})
@Entity
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor
public class Don implements Serializable
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date dateDon;
	
	@ManyToMany	
	@JoinTable(name="Don_Pack",
		     joinColumns= {@JoinColumn(name="idPack")},
		     inverseJoinColumns = {@JoinColumn(name="idDon")})
	private List<Pack> packs;
	
	@ManyToOne
	@JoinColumn(name="idDonateur")
	private Donateur donateur;

	@Override
	public String toString() {
		return "Don [id=" + id + ", dateDon=" + dateDon + ", donateur=" + donateur + "]";
	}

}
