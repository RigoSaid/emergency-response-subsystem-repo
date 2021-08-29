package com.medhead.repository;

import com.medhead.entity.Emergency;
import org.springframework.data.repository.CrudRepository;

public interface  EmergencyRepository extends CrudRepository<Emergency, Long> {
}
