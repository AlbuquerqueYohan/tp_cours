package com.dov.travel.service;

import com.dov.travel.model.PropertyType;

import java.util.List;


public interface PropertyTypeService {
 public List<PropertyType> getAll();
 public void add(PropertyType propertyType);
 public void update(PropertyType propertyType);
 public void delete(Long id);
 public PropertyType findById(Long id);
}
