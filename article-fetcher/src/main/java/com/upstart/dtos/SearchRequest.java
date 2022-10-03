package com.upstart.dtos;

public class SearchRequest {

	private String keywords;
	private String title;
	private String author;
	private String numberOfResults;
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNumberOfResults() {
		return numberOfResults;
	}
	public void setNumberOfResults(String numberOfResults) {
		this.numberOfResults = numberOfResults;
	}
	
	
	
}
