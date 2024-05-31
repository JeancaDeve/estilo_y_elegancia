package com.project.estilo_y_elegancia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.estilo_y_elegancia.models.MdClothes;
import com.project.estilo_y_elegancia.enums.EnCategory;

@Repository
public interface ClothesRepository extends BaseRepository<Long, MdClothes> {

 @Query("SELECT c FROM MdClothes c WHERE c.stock > 0")
 List<MdClothes> getClothesAvailables();

 List<MdClothes> findByCategory(EnCategory category);

 List<MdClothes> findByDescriptionContaining(String description);

 


}
