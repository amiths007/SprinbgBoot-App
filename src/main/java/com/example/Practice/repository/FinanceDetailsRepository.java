package com.example.Practice.repository;

import com.example.Practice.model.FinanceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceDetailsRepository extends JpaRepository<FinanceDetails, Integer> {
}
