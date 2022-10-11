package com.upstart.service;

import com.upstart.dtos.SearchRequest;
import com.upstart.dtos.SearchResultResponseDTO;

public interface ArticleService {

	
	public SearchResultResponseDTO getTopHEadline(String numberOfnews) throws Exception;
	
	public SearchResultResponseDTO searchNews(SearchRequest searchRequest) throws Exception;
	
	
}