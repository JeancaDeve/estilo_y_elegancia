package com.project.estilo_y_elegancia.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.estilo_y_elegancia.models.MdCustomer;
import com.project.estilo_y_elegancia.models.MdSale;

@Repository
public interface SaleRepository extends BaseRepository<Long, MdSale> {

 @Query("SELECT c FROM MdCustomer c WHERE c.name = :#{#customer.name} AND c.lastName = :#{#customer.lastName} AND c.email = :#{#customer.email} AND c.phoneNumber = :#{#customer.phoneNumber}")
 boolean CustomerExists(MdCustomer customer);

}
