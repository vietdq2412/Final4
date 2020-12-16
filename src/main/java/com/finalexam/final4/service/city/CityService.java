package com.finalexam.final4.service.city;

import com.finalexam.final4.model.City;
import com.finalexam.final4.repo.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    ICityRepo cityRepo;
    @Override
    public Iterable findAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public City save(City o) {
        return cityRepo.save(o);
    }

    @Override
    public void delete(Long id) {
        cityRepo.deleteById(id);
    }
}
