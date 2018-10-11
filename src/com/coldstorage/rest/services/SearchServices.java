package com.coldstorage.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coldstorage.mongo.model.Kisan;
import com.coldstorage.mongo.model.SearchParams;
import com.coldstorage.mongo.model.Vyapari;
import com.coldstorage.mongo.repository.KisanRepository;
import com.coldstorage.mongo.repository.VypariRepository;

@Service
public class SearchServices {

	@Autowired
	KisanRepository kisanRepository;
	@Autowired
	VypariRepository vypariRepository;
	List<Vyapari> vypariList;
	List<Kisan> kisanList;
	List<SearchParams> outputlist = new ArrayList<>();
	
	public List<SearchParams> search(SearchParams searchParams) {

		vypariList = vypariRepository.findBySlipNumberLikeOrVypariNameLikeOrFatherNameLikeOrMobileLikeOrAddressLike( searchParams.getSlipNumber(),  searchParams.getName() ,  searchParams.getFatherName(),  searchParams.getMobile(),searchParams.getAddress());
		kisanList = kisanRepository.findBySlipNumberLikeOrKisanNameLikeOrFatherNameLikeOrMobileLikeOrAddressLike( searchParams.getSlipNumber(),  searchParams.getName() ,  searchParams.getFatherName(),  searchParams.getMobile(),searchParams.getAddress());

		for(Kisan k : kisanList){
			SearchParams ss = new SearchParams();
			ss.setTypeUser("kisan");
			ss.setAddress(k.getAddress());
			ss.setFatherName(k.getFatherName());
			ss.setMobile(k.getMobile());
			ss.setName(k.getKisanName());
			ss.setSlipNumber(k.getSlipNumber());
			outputlist.add(ss);
		}
		for(Vyapari v : vypariList){
			SearchParams ss = new SearchParams();
			ss.setTypeUser("Vyapari");
			ss.setAddress(v.getAddress());
			ss.setFatherName(v.getFatherName());
			ss.setMobile(v.getMobile());
			ss.setName(v.getVypariName());
			ss.setSlipNumber(v.getSlipNumber());
			outputlist.add(ss);
		}
		
		
		return outputlist;
	}

	/*
	 * {"slipNumber":"123","kisanName":"0000000009","fatherName":"69315495TK","lotNumber":"Delhi","pickupPrice":"FLBPL991998","dropPrice":true ,"session_id":"123", "noOfPacket":"40","address":"chummiNagar" , "mobile":"7878787887"}
	 * */
	
}
