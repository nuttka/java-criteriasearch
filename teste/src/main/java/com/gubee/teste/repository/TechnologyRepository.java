package com.gubee.teste.repository;

import org.springframework.stereotype.Repository;
import com.gubee.teste.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer>  {
    
}
