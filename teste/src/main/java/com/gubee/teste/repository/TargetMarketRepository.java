package com.gubee.teste.repository;

import com.gubee.teste.entity.TargetMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetMarketRepository extends JpaRepository<TargetMarket, Integer>  {
    
}
