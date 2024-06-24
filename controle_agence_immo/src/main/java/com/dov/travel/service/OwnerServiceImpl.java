package com.dov.travel.service;

import com.dov.travel.model.Owner;
import com.dov.travel.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAll() {return ownerRepository.findAll();}

    @Override
    public void add(Owner owner) {ownerRepository.save(owner);}

    @Override
    public void update(Owner owner) {
        if (findById(owner.getId()) != null) {
            ownerRepository.save(owner);
        }
    }

    @Override
    public void delete(Long id) {ownerRepository.deleteById(id);}

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }
}
