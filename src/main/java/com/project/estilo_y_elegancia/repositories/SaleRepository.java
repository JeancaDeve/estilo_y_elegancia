package com.project.estilo_y_elegancia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.estilo_y_elegancia.models.MdClothes;
import com.project.estilo_y_elegancia.models.MdCustomer;
import com.project.estilo_y_elegancia.models.MdSale;

@Repository
public interface SaleRepository extends BaseRepository<Long, MdSale> {

 @Query("SELECT c FROM MdCustomer c WHERE c.name = :#{#customer.name} AND c.lastName = :#{#customer.lastName}  AND c.phoneNumber = :#{#customer.phoneNumber}")
 Optional<MdCustomer> CustomerExists(MdCustomer customer);

 @Query("SELECT c FROM MdClothes c WHERE c.id = :id")
 MdClothes getClothesById(Long id);

 @Query("SELECT c FROM MdCustomer c WHERE c.phoneNumber = :phoneNumber")
 Optional<MdCustomer> getCustomerByPhoneNumber(String phoneNumber);

 @Query("SELECT s FROM MdSale s WHERE s.customer.id = :idCustomer")
 List<MdSale> findSaleByIdCustomer(Long idCustomer);

}
