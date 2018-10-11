package com.coldstorage.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coldstorage.mongo.model.Kisan;
import com.coldstorage.rest.services.KisanService;


@RestController
public class KisanController {
	
	@Autowired
	KisanService kisanService;
	
	
	@RequestMapping(value = "/createKisan", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody Kisan kisan) {
		String sttus = "Invalid";
		if (kisan != null) {
			sttus = kisanService.addKisan(kisan);
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<String>(sttus, httpHeaders,HttpStatus.OK);
	}
}
