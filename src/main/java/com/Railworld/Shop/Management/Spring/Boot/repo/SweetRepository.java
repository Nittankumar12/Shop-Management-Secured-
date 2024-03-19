package com.Railworld.Shop.Management.Spring.Boot.repo;

import com.Railworld.Shop.Management.Spring.Boot.model.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SweetRepository  extends JpaRepository<Sweet,Integer> {
    Sweet findBysName(String sName);
}
