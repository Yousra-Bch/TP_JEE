package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Etudiant implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String nom;
    private String prenom;
    private String login ;
    private String pwd;
    private Long nbLivreMensuel_Autorise;
    private Long nbLivreEmprunte;
    private String pack;
    private String pwdLivre;
    
    
	public Etudiant() {
		super();
	}

	
	public Etudiant(String nom, String prenom, String login, String pwd, Long nbLivreMensuel_Autorise,
			Long nbLivreEmprunte, String pack,String pwdLivre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
		this.nbLivreMensuel_Autorise = nbLivreMensuel_Autorise;
		this.nbLivreEmprunte = nbLivreEmprunte;
		this.pack=pack;
		this.pwdLivre=pwdLivre;
	}


	
	public Long getId() {
		return id;
	}


	public void setId(Long Id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public Long getNbLivreMensuel_Autorise() {
		return nbLivreMensuel_Autorise;
	}


	public void setNbLivreMensuel_Autorise(Long nbLivreMensuel_Autorise) {
		this.nbLivreMensuel_Autorise = nbLivreMensuel_Autorise;
	}


	public Long getNbLivreEmprunte() {
		return nbLivreEmprunte;
	}


	public void setNbLivreEmprunte(Long nbLivreEmprunte) {
		this.nbLivreEmprunte = nbLivreEmprunte;
	}


	public String getPack() {
		return pack;
	}


	public void setPack(String pack) {
		this.pack = pack;
	}
	
	public String getPwdLivre() {
		return pwdLivre;
	}


	public void setPwdLivre(String pwdLivre) {
		this.pwdLivre = pwdLivre;
	}


}
