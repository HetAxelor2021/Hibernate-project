package com.HibernateProjNow.app;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import org.hibernate.annotations.CollectionId;


import java.util.*;

@Entity 
@Table (name="USER_DETAILS")
public class UserDetails {
	
	
	
//	@EmbeddedId
//	@Column (name="USER_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column (name="USER_NAME")
//	@Transient
	private String userName;
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
			joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="increment-gen",strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID")},generator="increment-gen",type=@Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
//	
//	public Set<Address> getListOfAddress() {
//		return listOfAddress;
//	}
//	public void setListOfAddress(Set<Address> listOfAddress) {
//		this.listOfAddress = listOfAddress;
//	}
//	@Embedded
//	@AttributeOverrides({
//	@AttributeOverride(name="street",column=@Column(name="HOME_STREET_NAME")),
//	@AttributeOverride(name="city",column=@Column(name="HOME_CITY_NAME")),
//	@AttributeOverride(name="state",column=@Column(name="HOME_STATE_NAME")),
//	@AttributeOverride(name="pincode",column=@Column(name="HOME_PIN_NAME"))
//	})
//	public Address homeAddress;
//	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
//	public Address getHomeAddress() {
//		return homeAddress;
//	}
//	public void setHomeAddress(Address homeAddress) {
//		this.homeAddress = homeAddress;
//	}
//	public Address getOfficeAddress() {
//		return officeAddress;
//	}
//	public void setOfficeAddress(Address officeAddress) {
//		this.officeAddress = officeAddress;
//	}
//	@Embedded
//	public Address officeAddress;
//	
////	public void setAddress(Address address) {
////		this.address = address;
////	}
//	@Temporal (TemporalType.DATE)
//	private Date joinedDate;
////	private String Address;
//	
//	@Lob
//	private String description;
//	
//	
//	
//	public Date getJoinedDate() {
//		return joinedDate;
//	}
//	public void setJoinedDate(Date joinedDate) {
//		this.joinedDate = joinedDate;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
//	public String getAddress() {
//		return Address;
//	}
//	public void setAddress(String address) {
//		Address = address;
//	}
	
}
