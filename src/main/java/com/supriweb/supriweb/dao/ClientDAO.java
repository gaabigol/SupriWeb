package com.supriweb.supriweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.supriweb.supriweb.model.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClientDAO implements CRUD<Client, Long> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Client findById(Long id) {
		return entityManager.find(Client.class, id);
	}

	@Override
	public List<Client> findAll() {
		TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
		List<Client> clients = query.getResultList();
		return clients;
	}

	@Override
	public void insert(Client client) {
		entityManager.persist(client);
	}

	@Override
	public void update(Client client) {
		entityManager.merge(client);
	}

	@Override
	public void remove(Client client) {
		if (entityManager.contains(client)) {
			entityManager.remove(client);
		}
	}
}
