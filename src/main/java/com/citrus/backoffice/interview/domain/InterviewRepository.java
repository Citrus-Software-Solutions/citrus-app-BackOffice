package com.citrus.backoffice.interview.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citrus.backoffice.interview.domain.valueobjects.InterviewId;

@Repository
public interface InterviewRepository extends CrudRepository<Interview, InterviewId>, JpaSpecificationExecutor<Interview> {

	Interview findByName(String name);
	
}
