package com.forhad.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forhad.ims.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
