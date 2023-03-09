package com.supriweb.supriweb.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.supriweb.supriweb.model.enums.Sex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(length = 11)
	private String cpf;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "birth_date", columnDefinition = "DATE")
	private LocalDate birthDate;
	@Column(length = 10)
	private String telephone;
	@Column(length = 12)
	private String cellphone;
	@Column(length = 50)
	private String email;
	private boolean active;

	@Enumerated(EnumType.STRING)
	private Sex sex;

	
	public Client() {

	}

	public Client(long id, String name, String cpf, LocalDate birthDate, String telephone, String cellphone,
			String email, boolean active, Sex sex) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.email = email;
		this.active = active;
		this.sex = sex;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
	

	@Override
	public String toString() {
		return "id" + id 
				+ ", name=" + name 
				+ ", cpf=" + cpf 
				+ ", birthDate=" + birthDate 
				+ ", telephone="+ telephone 
				+ ", cellphone=" + cellphone 
				+ ", email=" + email 
				+ ", active=" + active 
				+ ", sex=" + sex;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf) && id == other.id;
	}

}
