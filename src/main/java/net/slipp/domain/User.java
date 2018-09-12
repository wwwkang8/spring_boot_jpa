package net.slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id //PK에 해당하는 필드에 주는 어노테이션
	@GeneratedValue //데이터베이스에서 자동으로 1씩 증가. 시퀀스와 기능이 동일
	private Long id;
	
	@Column(nullable=false, length=20) //userId에는 null이 들어갈 수 없다는 뜻
	private String userId;
	
	private String password;
	private String name;
	private String email;
	
	
	
	public User() {
		super();
	}
	public User(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	/*
	 * 파라메터가 맵핑되는 것은 private 변수가 아니라
	 * set 메서드의 이름에 맵핑이 되는 것이다.
	 * */
	
	public String getUserId() {
		return userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
