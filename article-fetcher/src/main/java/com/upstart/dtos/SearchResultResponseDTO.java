
package com.upstart.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)//for unexpected fields in response parsing.
@JsonInclude(JsonInclude.Include.NON_NULL)//for hiding the null fields to end user.
public class SearchResultResponseDTO {

    @JsonProperty("totalArticles")
    private Integer totalArticles;
    @JsonProperty("articles")
    private List<Article> articles = null;
    
    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonProperty("totalArticles")
    public Integer getTotalArticles() {
        return totalArticles;
    }

    @JsonProperty("totalArticles")
    public void setTotalArticles(Integer totalArticles) {
        this.totalArticles = totalArticles;
    }

    @JsonProperty("articles")
    public List<Article> getArticles() {
        return articles;
    }

    @JsonProperty("articles")
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
