package com.dov.travel.service;


import com.dov.travel.model.Property;
import com.dov.travel.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

   @Autowired
   PropertyRepository propertyRepository;

    @Override
    public List<Property> getAll() {
       return propertyRepository.findAll();
   }

    @Override
    public void add(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public void update(Property property) {
        if (findById(property.getPropertyId()) != null) {
            propertyRepository.save(property);
        }
    }
    @Override
    public void delete(String id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public Property findById(String id) {
        Optional<Property> optionalproperty = propertyRepository.findById(id);
        if (optionalproperty.isPresent()) {
            return optionalproperty.get();
        }
        return null;
    }
    
}
