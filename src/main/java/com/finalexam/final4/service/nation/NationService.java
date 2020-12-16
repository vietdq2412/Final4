package com.finalexam.final4.service.nation;

import com.finalexam.final4.model.Nation;
import com.finalexam.final4.repo.INationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationService implements INationService {
    @Autowired
    INationRepo nationRepo;

    @Override
    public Iterable findAll() {
        return nationRepo.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return nationRepo.findById(id);
    }

    @Override
    public Nation save(Nation o) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
