package com.project.estilo_y_elegancia.services.business;

import java.util.List;

import com.project.estilo_y_elegancia.enums.EnCategory;
import com.project.estilo_y_elegancia.models.MdClothes;

public interface ClothesServiceBs extends BaseServiceBs<MdClothes, Long> {

 List<MdClothes> getAllClothesAvailables() throws Exception;

 List<MdClothes> getClothesByCategory(EnCategory category) throws Exception;

 List<MdClothes> getClothesByDescription(String description) throws Exception;

}
