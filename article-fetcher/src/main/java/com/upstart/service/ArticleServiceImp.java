package com.upstart.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstart.dtos.SearchRequest;
import com.upstart.dtos.SearchResultResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class ArticleServiceImp implements ArticleService {

	
	@Value("${api.token}")
	private String apiToken;
//	private ObjectMapper oblectMapper;
//	
//	public ArticleService() {
//		oblectMapper=new ObjectMapper();
//	}
	
	
	@Cacheable("searchResultResponseDTO")
	public SearchResultResponseDTO getTopHEadline(String numberOfnews) throws Exception {
		SearchResultResponseDTO externalResponse=null;
		URL url = new URL("https://gnews.io/api/v4/top-headlines?token="+apiToken
				+"&lang=en&max="+numberOfnews);//default language is set to english
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
        con.setRequestProperty("Content-length", "0");
        con.setUseCaches(false);
        con.setAllowUserInteraction(false);
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
        con.connect();
		
        try {
	
	        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line+"\n");
	        }
	        br.close();
	        log.info("Response received from external service: "+sb.toString());
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        if(con.getResponseCode()==201 || con.getResponseCode()==200) {
	            
	            externalResponse=objectMapper.readValue(sb.toString(), SearchResultResponseDTO.class);
	
	        }else {
	        	Object errorResponse=objectMapper.readValue(sb.toString(), Object.class);
	        	log.info("Response could not be received from. Response code: "+con.getResponseCode());
	        	log.info("Error response from the external server: "+errorResponse.toString());
	        }
		}catch(Exception e) {
			throw e;
		}finally {
	        if (con != null) {
	            con.disconnect();
	         }
		}
		return externalResponse;
	}


	@Cacheable("searchResultResponseDTO")
	public SearchResultResponseDTO searchNews(SearchRequest searchRequest) throws Exception {
		SearchResultResponseDTO externalResponse=null;
		URL url = new URL("https://gnews.io/api/v4/search?token="+apiToken
				+"&lang=en&max="//default language is set to english
				+searchRequest.getNumberOfResults()+"&q="+searchRequest.getKeywords());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
        con.setRequestProperty("Content-length", "0");
        con.setUseCaches(false);
        con.setAllowUserInteraction(false);
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
        con.connect();
		
        try {
	
	        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line+"\n");
	        }
	        br.close();
	        log.info("Response received from external service: "+sb.toString());
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        if(con.getResponseCode()==201 || con.getResponseCode()==200) {
	            
	            externalResponse=objectMapper.readValue(sb.toString(), SearchResultResponseDTO.class);
	
	        }else {
	        	Object errorResponse=objectMapper.readValue(sb.toString(), Object.class);
	        	log.info("Response could not be received from. Response code: "+con.getResponseCode());
	        	log.info("Error response from the external server: "+errorResponse.toString());
	        }
		}catch(Exception e) {
			throw e;
		}finally {
	        if (con != null) {
	            con.disconnect();
	         }
		}
		return externalResponse;
	}


//	private String getApiToken() {
//		return apiToken;
//	}
//
//
//	private void setApiToken(String apiToken) {
//		this.apiToken = apiToken;
//	}

}
