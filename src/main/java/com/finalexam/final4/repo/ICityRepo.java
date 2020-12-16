package com.finalexam.final4.repo;

import com.finalexam.final4.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends CrudRepository<City, Long> {
}
