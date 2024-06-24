package com.dov.travel.service;

import com.dov.travel.model.Property;

import java.util.List;


public interface PropertyService {
 public List<Property> getAll();
 public void add(Property owner);
 public void update(Property owner);
 public void delete(String id);
 public Property findById(String id);
}
