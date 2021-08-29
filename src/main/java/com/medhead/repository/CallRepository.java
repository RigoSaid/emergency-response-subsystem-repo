package com.medhead.repository;

import com.medhead.entity.Call;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CallRepository extends CrudRepository<Call, Long> {

}

