package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livre implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String domaine;
	private String url;

	
	public Livre() {
		super();
	}



	public Livre(String nom, String domaine,String url) {
		super();
		this.nom = nom;
		this.domaine = domaine;
		this.url = url;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getDomaine() {
		return domaine;
	}



	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	
	

	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url= url;
	}
	
}
