package com.upstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upstart.dtos.FetchNHeadlineRequest;
import com.upstart.dtos.SearchRequest;
import com.upstart.dtos.SearchResultResponseDTO;
import com.upstart.service.ArticleServiceImp;

import lombok.extern.slf4j.Slf4j;


//@Slf4j
@RestController
@RequestMapping("/articleApi")
public class MainController {
	
	
	@Autowired
	private ArticleServiceImp articleService;
	
	
	@PostMapping("/getTopHeadline")
	public SearchResultResponseDTO getTopHeadline(@RequestBody FetchNHeadlineRequest numberOfnews) {
		
//		log.info("Article Service getTopHeadline method started");
		
		SearchResultResponseDTO res=null;
		try {
			res=articleService.getTopHEadline(numberOfnews.getNumberOfnews());
		} catch (Exception e) {
			res=new SearchResultResponseDTO();
			res.setErrorMessage(e.getMessage());
//			log.error("Article Service getTopHeadline method error: "+e.getMessage());
		}
		
		if(res==null) {
			res=new SearchResultResponseDTO();
			res.setErrorMessage("Service response is null!");
		}
		
//		log.info("Article Service getTopHeadline method completed");
		return res;
	}

	
	
	@PostMapping("/search")
	public SearchResultResponseDTO getTopHeadline(@RequestBody SearchRequest searchRequest){
//		log.info("Article Service getTopHeadline method started");
		
		SearchResultResponseDTO res=null;
		try {
			res=articleService.searchNews(searchRequest);
		} catch (Exception e) {
			res=new SearchResultResponseDTO();
			res.setErrorMessage(e.getMessage());
//			log.error("Article Service getTopHeadline method error: "+e.getMessage());
		}
		
		if(res==null) {
			res=new SearchResultResponseDTO();
			res.setErrorMessage("Service response is null!");
		}
		
//		log.info("Article Service getTopHeadline method completed");
		return res;
	}
	
}
