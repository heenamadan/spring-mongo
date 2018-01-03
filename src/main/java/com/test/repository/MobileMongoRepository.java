package com.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.model.Mobile;

public interface MobileMongoRepository extends CrudRepository<Mobile, String>{}