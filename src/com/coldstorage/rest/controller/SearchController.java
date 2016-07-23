package com.coldstorage.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coldstorage.mongo.model.SearchParams;
import com.coldstorage.rest.services.SearchServices;

@RestController
public class SearchController {

	@Autowired
	SearchServices searchServices;
	
	List<SearchParams> searchResult ;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ResponseEntity<List<SearchParams>> update(@RequestBody SearchParams searchParams) {
		
	    if (searchParams != null) {
	    	searchResult = searchServices.search(searchParams);
	    }
	    HttpHeaders httpHeaders = new HttpHeaders();
	    return new ResponseEntity<List<SearchParams>>(searchResult, httpHeaders,HttpStatus.OK);
	}
}
