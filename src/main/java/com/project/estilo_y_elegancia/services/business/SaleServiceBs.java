package com.project.estilo_y_elegancia.services.business;

import java.util.List;

import com.project.estilo_y_elegancia.models.MdSale;

public interface SaleServiceBs extends BaseServiceBs<MdSale, Long> {
 MdSale generateSale(MdSale sale) throws Exception;

 List<MdSale> getSalesByIdCustomer(Long idCustomer) throws Exception;
 
}
