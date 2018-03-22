/**
 * Copyright 2018 Mihaela Munteanu 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0 
 *  
 *  Unless required by applicable law or agreed to in writing, software 
 *  distributed under the License is distributed on an "AS IS" BASIS, 
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 *  See the License for the specific language governing permissions and 
 *  limitations under the License. 
 */
package com.ws.juxtarem.obj;

import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import com.ws.juxtarem.util.ObjectUtils;

@Entity
@Table(name="users")
@Proxy(lazy=false)
public class User implements JSONInterface, Identifiable {
	public static String MAIL = "mail";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id; 
	
	@Column(name = "main_mail")
	private String mainMail;
	
	@Column(name="nickname")	
	private String nickName; 
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName; 
	
	@Column(name="middlename")
	private String middleName;
	
	@Column(name="points")
	private int points;
	
	@Column(name="birthdate")
	private Date birthDate;
	
	@OneToMany(mappedBy = "user")
	private Set<UserTask> userTasks;
	
	@Transient
	private List<GoogleLocation> userLocations; 
	
	@Transient
	private GoogleLocation currentLocation;
	
	@Transient
	private Contact contact;
	
	@Column(name="password")
	private byte[] password;
	
	/**
	 * Default public constructor
	 */
	public User() {
		
	}
	public User (String name, String mail, byte[] password) {
		this.nickName = name;
		this.mainMail = mail; 
		this.password = password;
	}
	
	/**
	 * Public constructor to fill field
	 */
	public User(int id, String nickame, String firstName, String lastName, String middleName, int points) {
		this.id = id;
		this.middleName = middleName;
		this.firstName = firstName;
		this.nickName = nickame;
		this.lastName = lastName;
		this.points = points;
	}	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMainMail() {
		return mainMail;
	}

	public void setMainMail(String mainMail) {
		this.mainMail = mainMail;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public List<GoogleLocation> getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(List<GoogleLocation> userLocations) {
		this.userLocations = userLocations;
	}

	public GoogleLocation getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(GoogleLocation currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<UserTask> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(Set<UserTask> userTasks) {
		this.userTasks = userTasks;
	}

	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	
	public String toJSON() {
		StringBuffer jsonStringBuffer = new StringBuffer();
		//{"user:
		jsonStringBuffer.append("{").append(STRING_QUOTE).append("user").append(STRING_QUOTE).append(":");
		//   e.g. {"id":"id"},
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("id", String.valueOf(id), true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("nickname", nickName, true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("firstName", firstName, true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("lastName", lastName, true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("middleName", middleName, true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("points", String.valueOf(points), true));
		//TODO fill current location
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("currentLocation", "\"null\"", false));
		//TODO add Contact
		jsonStringBuffer.append("}");
		
		return jsonStringBuffer.toString();
	}
}
