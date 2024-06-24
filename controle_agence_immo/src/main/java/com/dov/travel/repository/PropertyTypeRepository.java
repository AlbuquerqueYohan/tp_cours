package com.dov.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dov.travel.model.PropertyType;


public interface PropertyTypeRepository  extends JpaRepository<PropertyType, Long> {
    
}
