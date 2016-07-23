package com.coldstorage.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coldstorage.mongo.model.Vyapari;
import com.coldstorage.rest.services.VyapariServices;

@RestController
public class VyapariController {



	@Autowired
	VyapariServices vyapariServices;
	
	
			@RequestMapping(value = "/createVyapari", method = RequestMethod.POST)
			public ResponseEntity<String> update(@RequestBody Vyapari vyapari) {
				String sttus = "Invalid";
			    if (vyapari != null) {
			    	sttus = vyapariServices.addvypari(vyapari);
			    }
			    HttpHeaders httpHeaders = new HttpHeaders();
			    return new ResponseEntity<String>(sttus, httpHeaders,HttpStatus.OK);
			}
}
