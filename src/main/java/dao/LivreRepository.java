package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Livre;

public class LivreRepository {

	private EntityManager entityManager;
	private EntityTransaction transaction;

	public LivreRepository(EntityManager entityManager,
			EntityTransaction transaction) {
		super();
		
		this.entityManager = entityManager;
		this.transaction = transaction;
	}

	public void ajouterLivre(Livre l) {
		this.transaction.begin();
		this.entityManager.persist(l);
		this.transaction.commit();
	}

	public void modifierLivre(Livre l) {
		this.transaction.begin();
		this.entityManager.merge(l);
		this.transaction.commit();
	}

	public void supprimerLivre(Livre l) {
		this.transaction.begin();
		this.entityManager.remove(l);
		this.transaction.commit();
	}

	public Livre retournerLivre(Long id) {
		
		return this.entityManager.find(Livre.class, id);
		
	}

	public List<Livre> retournerTousLivre() {

		Query req = this.entityManager.createQuery("select l from Livre l");
		return req.getResultList();

	}
}
