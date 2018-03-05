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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class representing the many to many relation between users and tasks.
 * 
 * Decided to go with first solution from here: 
 * http://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-with-extra-columns-in-join-table-example
 * 
 * @author Mihaela Munteanu
 * @since 3rd March 2018
 *
 */
@Entity
@Table(name = "users_tasks")
public class UserTask {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_id")
	private Task task;
	
	@Column(name = "completion_date")
	private Date completionDate;
	
	@Column(name = "snoozed_date")
	private Date snoozedDate;
	
	@Column(name = "snoozed")
	private boolean snoozed;
	
	@Column(name = "snoozed_number")
	private short snoozed_number;
	
	@Column(name = "remarks")
	private String remarks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public Date getSnoozedDate() {
		return snoozedDate;
	}

	public void setSnoozedDate(Date snoozedDate) {
		this.snoozedDate = snoozedDate;
	}

	public boolean isSnoozed() {
		return snoozed;
	}

	public void setSnoozed(boolean snoozed) {
		this.snoozed = snoozed;
	}

	public short getSnoozed_number() {
		return snoozed_number;
	}

	public void setSnoozed_number(short snoozed_number) {
		this.snoozed_number = snoozed_number;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
