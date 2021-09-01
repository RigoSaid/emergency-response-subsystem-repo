package com.medhead.repository;

import com.medhead.entity.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Long> {
}
