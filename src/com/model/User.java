package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="t_user")
public class User {
	
	private int id;
	
	private String username;
	private String password;
	private String email;
	private String nickname;
	private int root;
	//0��������Ա 1��ͨ�û� 
	
	@GeneratedValue
	@Id
	public int getId() {
		return id;
	}
	@NotNull(message="�û�Ȩ�޲���Ϊ��")
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotEmpty(message="�û�������Ϊ��")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@NotEmpty(message="�û����벻��Ϊ��")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Email(message="�û��ʼ���ʽ����ȷ")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

}
