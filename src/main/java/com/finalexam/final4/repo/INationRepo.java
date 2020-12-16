package com.finalexam.final4.repo;

import com.finalexam.final4.model.Nation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepo extends CrudRepository<Nation, Long> {
}
