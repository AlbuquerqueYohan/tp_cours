
package com.dov.travel.repository;

import com.dov.travel.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository  extends JpaRepository<Property, String> {
    
}
