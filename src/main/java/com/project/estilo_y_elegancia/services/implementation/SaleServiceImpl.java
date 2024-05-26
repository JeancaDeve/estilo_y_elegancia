package com.project.estilo_y_elegancia.services.implementation;

import org.springframework.stereotype.Service;

import com.project.estilo_y_elegancia.models.MdSale;
import com.project.estilo_y_elegancia.repositories.BaseRepository;
import com.project.estilo_y_elegancia.services.business.SaleServiceBs;

@Service
public class SaleServiceImpl extends BaseServiceImpl<MdSale, Long> implements SaleServiceBs {

 public SaleServiceImpl(BaseRepository<Long, MdSale> repository) {
  super(repository);
 }

}
