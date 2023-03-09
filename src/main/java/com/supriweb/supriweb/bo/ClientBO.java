package com.supriweb.supriweb.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supriweb.supriweb.dao.CRUD;
import com.supriweb.supriweb.dao.ClientDAO;
import com.supriweb.supriweb.model.Client;

@Service
public class ClientBO implements CRUD<Client, Long> {

	@Autowired
	private ClientDAO dao;

	@Override
	public Client findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Client> findAll() {
		return dao.findAll();
	}

	@Override
	public void insert(Client client) {
		dao.insert(client);
	}

	@Override
	public void update(Client client) {
		dao.update(client);
	}

	@Override
	public void remove(Client client) {
		dao.remove(client);
	}

	public void inactivate(Client client) {
		client.setActive(false);
		dao.update(client);
	}

	public void activate(Client client) {
		client.setActive(true);
		dao.update(client);
	}
}
