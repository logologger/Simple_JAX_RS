package com.rajat.tcs.messenger.model;

import java.util.List;

public class Question {
	
	//Please refer javatpoint from where i am practising 
	//http://www.javatpoint.com/list-one-to-many
	//First i mapped a simple List of strings 
	//After that we will try to map list of Answers class
	private int id;
	private String qname;
	private List<Answer> answers; 
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	//private List<String> answers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
//	public List<String> getAnswers() {
//		return answers;
//	}
//	public void setAnswers(List<String> answers) {
//		this.answers = answers;
//	}
	

}
