package com.coldstorage.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.coldstorage.mongo.model.Kisan;


@Repository
public interface KisanRepository  extends MongoRepository<Kisan, String>{
	
	List<Kisan> findBySlipNumberLikeOrKisanNameLikeOrFatherNameLikeOrMobileLikeOrAddressLike(String slipNumber, String kisanName , String fatherName, String mobile, String address);


}
