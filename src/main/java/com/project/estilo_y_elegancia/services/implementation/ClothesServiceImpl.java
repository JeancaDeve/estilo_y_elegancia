package com.project.estilo_y_elegancia.services.implementation;

import org.springframework.stereotype.Service;

import com.project.estilo_y_elegancia.models.MdClothes;
import com.project.estilo_y_elegancia.repositories.BaseRepository;
import com.project.estilo_y_elegancia.services.business.ClothesServiceBs;

@Service
public class ClothesServiceImpl extends BaseServiceImpl<MdClothes, Long> implements ClothesServiceBs {

 public ClothesServiceImpl(BaseRepository<Long, MdClothes> repository) {
  super(repository);
 }

}
