package com.spring.mongo.api.service;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.spring.mongo.api.model.DataBaseSequence;
@Service
public class SequenceGeneratorService {


	@Autowired
    private  MongoOperations mongoOperations;

//    @Autowired
//    public SequenceGeneratorService(String mongoOperations) {
//        this.mongoOperations = mongoOperations;
//    }

  

    	public int getSequenceNumber(String seqName)
    	{
            Query query = new Query(Criteria.where("id").is(seqName));          //update the sequence number       
            Update update = new Update().inc("seq", 50);                        //update in the  in document   
            DataBaseSequence counter = mongoOperations.findAndModify(query, update,options().returnNew(true).upsert(true),DataBaseSequence.class);
            return !Objects.isNull(counter) ? counter.getSeq() : 1;
    	}


	
}
