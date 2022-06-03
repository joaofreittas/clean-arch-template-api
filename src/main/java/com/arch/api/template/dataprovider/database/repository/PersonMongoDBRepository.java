package com.arch.api.template.dataprovider.database.repository;

import com.arch.api.template.dataprovider.database.presentation.PersonPresentation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMongoDBRepository extends MongoRepository<PersonPresentation, String> {}