package com.coldstorage.rest.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.coldstorage.mongo.model.Vyapari;
import com.coldstorage.mongo.repository.VypariRepository;

@Service
public class VyapariServices {

	@Autowired
	VypariRepository vypariRepository;
	
	public String addvypari(Vyapari newVypari) {
		if(StringUtils.isEmpty(newVypari.getSlipNumber()) || newVypari.getSlipNumber().equals("slipNumber"))
			return "Invalid Slip Number";

		Vyapari vypari  = new Vyapari();
		vypari.setCreatedDate(new Date());
		vypari.setLastModifiedDate(new Date());
		vypari.setMaintainedBy(newVypari.getMaintainedBy());
		vypari.setSlipNumber(newVypari.getSlipNumber());
		vypari.setVypariName((newVypari.getVypariName()));
		vypari.setFatherName(newVypari.getFatherName());
		vypari.setLotNumber(newVypari.getLotNumber());
		vypari.setPickupPrice(newVypari.getPickupPrice());
		vypari.setDropPrice(newVypari.getDropPrice());
		vypari.setMobile(newVypari.getMobile());
		vypari.setNoOfPacket(newVypari.getNoOfPacket());
		vypari.setAddress(newVypari.getAddress());
		vypariRepository.save(vypari);
		
		return "Vypari Added Successfully";
	}

}
