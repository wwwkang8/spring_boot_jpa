package net.slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String customerName;
	private String title;
	private String contents;
	public Reservation(Long id, String customerName, String title, String contents) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.title = title;
		this.contents = contents;
	}
	public Reservation() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", customerName=" + customerName + ", title=" + title + ", contents="
				+ contents + "]";
	}
	
	
	
	
}
