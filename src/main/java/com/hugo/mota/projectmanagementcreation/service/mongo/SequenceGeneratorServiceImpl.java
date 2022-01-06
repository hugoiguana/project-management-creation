package com.hugo.mota.projectmanagementcreation.service.mongo;


import com.hugo.mota.projectmanagementcreation.entity.mongo.DatabaseSequenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Long generateSequence(String sequence) {
        DatabaseSequenceEntity counter = mongoOperations.findAndModify(query(where("_id").is(sequence)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true),
                DatabaseSequenceEntity.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}
