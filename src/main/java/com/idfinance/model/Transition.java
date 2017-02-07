package com.idfinance.model;

public class Transition {
	
	private int id;
	private String build;
	private String test;
	private String integrationTest;
	private String publish;
	private String docs;
	
	public  Transition(){
		
	}

	public Transition(int id, String build, String test, String integrationTest, String publish, String docs) {
		super();
		this.id = id;
		this.build = build;
		this.test = test;
		this.integrationTest = integrationTest;
		this.publish = publish;
		this.docs = docs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getIntegrationTest() {
		return integrationTest;
	}

	public void setIntegrationTest(String integrationTest) {
		this.integrationTest = integrationTest;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getDocs() {
		return docs;
	}

	public void setDocs(String docs) {
		this.docs = docs;
	}
	
	
	
}
