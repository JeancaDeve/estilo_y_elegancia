package com.project.estilo_y_elegancia.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estilo_y_elegancia.enums.EnCategory;
import com.project.estilo_y_elegancia.models.MdClothes;
import com.project.estilo_y_elegancia.services.implementation.ClothesServiceImpl;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController extends BaseController<MdClothes, ClothesServiceImpl> {

 @GetMapping("/get/availables")
 public ResponseEntity<?> listClothesAvailable() throws Exception {
  return ResponseEntity.ok(service.getAllClothesAvailables());
 }

 @GetMapping("/get/description/{description}")
 public ResponseEntity<?> getClothesByDescription(@PathVariable String description) throws Exception {
  try {
   return ResponseEntity.ok(service.getClothesByDescription(description));
  } catch (Exception e) {
   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }
 }

 @GetMapping("get/category/{category}")
 public ResponseEntity<?> getClothesByCategory(@PathVariable EnCategory category) throws Exception {
  try {
   return ResponseEntity.ok(service.getClothesByCategory(category));
  } catch (Exception e) {
   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }
 }

 @PostMapping("/selected")
 public ResponseEntity<?> selectedClothes(@RequestBody List<MdClothes> clothes) throws Exception {
  try {
   return ResponseEntity.ok(service.clothesSelected(clothes));
  } catch (Exception e) {
   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }
 }

}
