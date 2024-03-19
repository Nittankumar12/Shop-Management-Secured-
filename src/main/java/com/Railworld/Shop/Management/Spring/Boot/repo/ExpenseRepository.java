package com.Railworld.Shop.Management.Spring.Boot.repo;

import com.Railworld.Shop.Management.Spring.Boot.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
