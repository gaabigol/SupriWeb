package com.supriweb.supriweb.bo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.supriweb.supriweb.model.Client;
import com.supriweb.supriweb.model.enums.Sex;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ClientBOTest {

	@Autowired
	ClientBO bo;

	@Test
	@Order(1)
	public void insert() {
		Client client = new Client();
		client.setName("Gabriel Santos");
		client.setCpf("14609314754");
		client.setBirthDate(LocalDate.of(1996, 7, 10));
		client.setCellphone("927689653");
		client.setEmail("gabigol_96@icloud.com");
		client.setSex(Sex.MASCULINE);
		client.setTelephone("1234567890");
		client.setActive(true);
		bo.insert(client);
	}

	@Test
	@Order(2)
	public void findById() {
		Client client = bo.findById(1L);
		System.out.println(client);
	}

	@Test
	@Order(3)
	public void update() {
		Client client = bo.findById(1L);
		client.setCpf(null);
		client.setTelephone(null);
		client.setCellphone(null);
		client.setEmail(null);
		bo.update(client);
	}

	@Test
	@Order(4)
	public void findAll() {
		List<Client> clients = bo.findAll();
		for (Client client : clients) {
			System.out.println(client);
		}
	}

	@Test
	@Order(5)
	public void inactivate() {
		Client client = bo.findById(1L);
		bo.inactivate(client);
	}

	@Test
	@Order(6)
	public void remove() {
		Client client = bo.findById(1L);
		bo.remove(client);
	}

}
