package com.Railworld.Shop.Management.Spring.Boot.repo;

import com.Railworld.Shop.Management.Spring.Boot.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
//     @Query("SELECT a FROM Admin a WHERE LOWER(a.aName) = LOWER(?1)") // Case-insensitive search
//     Admin findByUsernameIgnoreCase(String username);
     Admin findByaName(String username);
}
