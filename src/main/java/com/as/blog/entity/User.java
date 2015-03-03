package com.as.blog.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.as.blog.entity.template.Role;
import com.as.blog.entity.template.Sex;

@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="name", unique = true, nullable = false)
	private String name;
	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="password", unique = true, nullable = false)
	private String password;
	
	@Column(name="sex", unique = false, nullable = false)
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	@Column(name="birthday", unique = false, nullable = false)
	private Date birthday;
	
	@Column(name="kind_of_sport", unique = false, nullable = true)
	private String kindOfSport;
	
	@Column(name="experience", unique = false, nullable = true)
	private String experience;
	
	@Column(name="city", unique = false, nullable = true)
	private String city;
	
	@Column(name="country", unique = false, nullable = true)
	private String country;
	
	@Column(name="avatar_path", unique = false, nullable = true)
	private String avatarPath;
	
	@Column(name="registration_date", unique = false, nullable = false)
	private Date registrationDate;
	
	@Column(name="role", unique = false, nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name="enabled", unique = false, nullable = false)
	private byte enabled;
	
	public User() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getKindOfSport() {
		return kindOfSport;
	}

	public void setKindOfSport(String kindOfSport) {
		this.kindOfSport = kindOfSport;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public byte getEnabled() {
		return enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}
	
}