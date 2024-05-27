package com.project.estilo_y_elegancia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estilo_y_elegancia.models.MdSale;
import com.project.estilo_y_elegancia.services.implementation.SaleServiceImpl;

@RestController
@RequestMapping("/api/sale")
public class SaleController extends BaseController<MdSale, SaleServiceImpl> {

 @PostMapping("/generate")
 public ResponseEntity<?> generateSale(@RequestBody MdSale sale) throws Exception {
  try {
   return ResponseEntity.ok(service.generateSale(sale));
  } catch (Exception e) {
   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }
 }

}
