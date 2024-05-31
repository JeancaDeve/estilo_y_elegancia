package com.project.estilo_y_elegancia.services.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.estilo_y_elegancia.enums.EnCategory;
import com.project.estilo_y_elegancia.models.MdClothes;
import com.project.estilo_y_elegancia.repositories.BaseRepository;
import com.project.estilo_y_elegancia.repositories.ClothesRepository;
import com.project.estilo_y_elegancia.services.business.ClothesServiceBs;

@Service
public class ClothesServiceImpl extends BaseServiceImpl<MdClothes, Long> implements ClothesServiceBs {

 @Autowired
 protected ClothesRepository _clothesRepository;

 public ClothesServiceImpl(BaseRepository<Long, MdClothes> repository) {
  super(repository);
 }

 @Override
 public List<MdClothes> getAllClothesAvailables() throws Exception {
  try {
   return _clothesRepository.getClothesAvailables();
  } catch (Exception e) {
   throw new Exception(e);
  }
 }

 @Override
 public List<MdClothes> getClothesByCategory(EnCategory category) throws Exception {

  List<MdClothes> listClothes = _clothesRepository.findByCategory(category);
  if (!listClothes.isEmpty())
   return listClothes;
  else
   throw new Exception("No hay resultados de " + category);

 }

 @Override
 public List<MdClothes> getClothesByDescription(String description) throws Exception {

  List<MdClothes> listClothes = _clothesRepository.findByDescriptionContaining(description);

  if (!listClothes.isEmpty())
   return listClothes;
  else
   throw new Exception("No hay resultados de " + description);

 }

 // * Agregar a una lista los producto que seran seleccionados por el cliente.

 public Set<JsonNode> clothesSelected(List<MdClothes> clothesList) throws Exception {

  List<MdClothes> clothes = new ArrayList<>();

  for (MdClothes item : clothesList) {
   clothes.add(_clothesRepository.findById(item.getId()).get());
  }

  // Create an ObjectMapper instance for JSON processing
  ObjectMapper mapper = new ObjectMapper();

  // Convert the clothesList to a JSON string
  String jsonString = mapper.writeValueAsString(clothes);

  // Deserialize the JSON string back into a list of MdClothes objects
  Set<MdClothes> updatedClothesList = mapper.readValue(jsonString, new TypeReference<Set<MdClothes>>() {
  });

  // Iterate through the updated clothes list and add the "cant" attribute to the
  // JSON representation
  Set<JsonNode> updatedJsonList = new HashSet<>();
  for (MdClothes item : updatedClothesList) {
   int count = Collections.frequency(clothes, item);

   // Get the JSON representation of the item with "cant" attribute
   ObjectNode itemNode = mapper.valueToTree(item);
   itemNode.put("cant", count);

   // Add the modified JSON node to the new list
   updatedJsonList.add(itemNode);
  }

  // Return the list of JSON representations
  return updatedJsonList;
 }

}
