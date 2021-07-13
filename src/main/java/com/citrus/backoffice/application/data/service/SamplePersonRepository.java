package com.citrus.backoffice.application.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citrus.backoffice.application.data.entity.SamplePerson;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, Integer> {

}