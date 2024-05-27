package com.project.estilo_y_elegancia.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estilo_y_elegancia.models.MdCustomer;
import com.project.estilo_y_elegancia.models.MdSale;
import com.project.estilo_y_elegancia.repositories.BaseRepository;
import com.project.estilo_y_elegancia.repositories.SaleRepository;
import com.project.estilo_y_elegancia.services.business.SaleServiceBs;

import jakarta.transaction.Transactional;

@Service
public class SaleServiceImpl extends BaseServiceImpl<MdSale, Long> implements SaleServiceBs {

 @Autowired
 protected SaleRepository _SaleRepository;

 public SaleServiceImpl(BaseRepository<Long, MdSale> repository) {
  super(repository);
 }

 public boolean CustomerExists(MdCustomer customer) {
  return _SaleRepository.CustomerExists(customer);
 }

 @Override
 @Transactional
 public MdSale generateSale(MdSale sale) {
  return _SaleRepository.save(sale);
 }

}
