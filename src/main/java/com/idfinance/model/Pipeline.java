package com.idfinance.model;

public class Pipeline {
	
	private int id;
	private String description;
	private Task task;
	private Transition transition;
	
	public Pipeline(){
		
	}

	public Pipeline(int id, String description, Task task, Transition transition) {
		super();
		this.id = id;
		this.description = description;
		this.task = task;
		this.transition = transition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	
	

}
