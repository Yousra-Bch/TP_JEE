package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Etudiant;

public class EtudiantRepository {
	
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	
	public EtudiantRepository(EntityManager entityManager, EntityTransaction transaction) {
		super();
		this.entityManager = entityManager;
		this.transaction = transaction;
	}
	
	public void ajouterEtudiant(Etudiant e) {
		this.transaction.begin();
		this.entityManager.persist(e);
		this.transaction.commit();
	}

	public void modifierEtudiant(Etudiant e) {
		this.transaction.begin();
		this.entityManager.merge(e);
		this.transaction.commit();
	}

	public void supprimerEtudiant(Etudiant e) {
		this.transaction.begin();
		this.entityManager.remove(e);
		this.transaction.commit();
	}

	public Etudiant retournerEtudiant(Long id) {
		
		return this.entityManager.find(Etudiant.class, id);
		
	}

	public List<Etudiant> retournerTousEtudiant() {

		Query req = this.entityManager.createQuery("select e from Etudiant e");
		return req.getResultList();

	}

}
