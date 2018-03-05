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
 *  
 */
package com.ws.juxtarem.obj;

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
@Table(name="tasks")
@Proxy(lazy=false)
public class Task implements JSONInterface, Identifiable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id; 
	
	@Column(name="description")
	private String taskText;
	
	@Column(name="details")
	private String taskDetails;
	
	@Column(name="awardedpoints")
	private int awardedPoints;
	
	@Column(name="confirmationtext")
	private String confirmationText;
	
	@Column(name="denialtext")
	private String denialText;
	
	@Column(name="tasktype")
	private String taskType;
	
	@Column(name="taskcomplexity")
	private String taskComplexity; 
	
	/** 
	 * If the user takes less time than this to declare a task completed 
	 * then it will be marked as not done. (in seconds) 
	 */
	@Column(name="minimumtaskduration")
	private int minimumTaskDuration;
	
	/** 
	 * The duration (in minutes) in which the task can be completed to gather more points
	 */
	@Column(name="incentivetaskduration")
	private int incentiveTaskDuration;
	
	/** 
	 * The number of points earned if the task is done in the incentive time
	 */
	@Column(name="incentivetaskpoints")
	private int incentiveTaskPoints;
	
	@OneToMany(mappedBy = "task")
	private Set<UserTask> userTask;
	
	@Transient
	private GoogleLocation taskLocation;
	
	//TODO change to new object which supports list of a period of time, schedule when a Task is ok to be performed
	@Transient
	private int recomendedTimeOfDayAndWeek;
	
	@Column(name="advertisingtask")
	private boolean advertasingTask = false;
	
	//TODO add confirmationType (the way the user can have a task validated
	
	/**
	 * Default public constructor
	 */
	public Task() {
		
	}
	
	public Task(int id, String taskText, String taskDetails, int awardedPoints, String taskType,  
			String taskComplexity, int minimumTaskDuration, int incentiveTaskDuration, 
			int incentiveTaskPoints, GoogleLocation taskLocation, int recomendedTime, boolean isAd) {
		this.id = id;
		this.taskText = taskText;
		this.taskType = taskType;
		this.taskDetails = taskDetails;
		this.taskComplexity = taskComplexity;
		this.awardedPoints = awardedPoints;
		this.minimumTaskDuration = minimumTaskDuration;
		this.incentiveTaskDuration = incentiveTaskDuration;
		this.incentiveTaskPoints = incentiveTaskPoints;
		this.taskLocation = taskLocation; 
		this.recomendedTimeOfDayAndWeek = recomendedTime;
		this.advertasingTask = isAd;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTaskText() {
		return taskText;
	}
	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
	public String getTaskDetails() {
		return taskDetails;
	}
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getTaskComplexity() {
		return taskComplexity;
	}
	public void setTaskComplexity(String taskComplexity) {
		this.taskComplexity = taskComplexity;
	}
	public int getMinimumTaskDuration() {
		return minimumTaskDuration;
	}
	public void setMinimumTaskDuration(int minimumTaskDuration) {
		this.minimumTaskDuration = minimumTaskDuration;
	}
	public int getIncentiveTaskDuration() {
		return incentiveTaskDuration;
	}
	public void setIncentiveTaskDuration(int incentiveTaskDuration) {
		this.incentiveTaskDuration = incentiveTaskDuration;
	}
	public int getIncentiveTaskPoints() {
		return incentiveTaskPoints;
	}
	public void setIncentiveTaskPoints(int incentiveTaskPoints) {
		this.incentiveTaskPoints = incentiveTaskPoints;
	}
	public GoogleLocation getTaskLocation() {
		return taskLocation;
	}
	public void setTaskLocation(GoogleLocation taskLocation) {
		this.taskLocation = taskLocation;
	}
	public int getRecomendedTimeOfDayAndWeek() {
		return recomendedTimeOfDayAndWeek;
	}
	public void setRecomendedTimeOfDayAndWeek(int recomendedTime) {
		this.recomendedTimeOfDayAndWeek = recomendedTime;
	}
	public boolean isAdvertasingTask() {
		return advertasingTask;
	}
	public void setAdvertasingTask(boolean advertasingTask) {
		this.advertasingTask = advertasingTask;
	}
	public int getAwardedPoints() {
		return awardedPoints;
	}
	public void setAwardedPoints(int awardedPoints) {
		this.awardedPoints = awardedPoints;
	}
	public String getConfirmationText() {
		return confirmationText;
	}
	public void setConfirmationText(String confirmationText) {
		this.confirmationText = confirmationText;
	}
	public String getDenialText() {
		return denialText;
	}
	public void setDenialText(String denialText) {
		this.denialText = denialText;
	}
	public void setUserTask(Set<UserTask> userTask) {
		this.userTask = userTask;
	}
	public Set<UserTask> getUserTask() {
		return userTask;
	}

	public String toJSON() {
		StringBuffer jsonStringBuffer = new StringBuffer();
		//{"task:
		jsonStringBuffer.append("{").append(STRING_QUOTE).append("task").append(STRING_QUOTE).append(":");
		//   e.g. {"id":"id"},
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("id", String.valueOf(id), true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("taskText", taskText, true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("taskDetails", taskDetails, true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("awardedPoints", String.valueOf(awardedPoints), true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("taskType", taskType, true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("taskComplexity", taskComplexity, true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("minimumTaskDuration", String.valueOf(minimumTaskDuration), true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("incentiveTaskDuration", String.valueOf(incentiveTaskDuration), true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("incentiveTaskPoints", String.valueOf(incentiveTaskPoints), true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("recomendedTime", String.valueOf(recomendedTimeOfDayAndWeek), true));
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("isAdvertasingTask", String.valueOf(advertasingTask), true));
		
		//TODO fill task location
		jsonStringBuffer.append(ObjectUtils.buildJSONObject("taskLocation", "\"null\"", false));
		jsonStringBuffer.append("}");
		
		return jsonStringBuffer.toString();
	}
}
