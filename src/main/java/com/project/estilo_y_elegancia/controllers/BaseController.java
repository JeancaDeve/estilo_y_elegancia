package com.project.estilo_y_elegancia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.estilo_y_elegancia.models.MdBaseEntity;
import com.project.estilo_y_elegancia.services.implementation.BaseServiceImpl;

public class BaseController<T extends MdBaseEntity, S extends BaseServiceImpl<T, Long>> {

 @Autowired
 protected S service;

 @GetMapping("/get")
 public ResponseEntity<?> save() throws Exception {
  return ResponseEntity.ok(service.findAll());
 }

 @PostMapping("/save")
 public ResponseEntity<?> save(@RequestBody T entity) throws Exception {
  return ResponseEntity.ok(service.saveEntity(entity));
 }

 @PatchMapping("/update/{id}")
 public ResponseEntity<?> update(@PathVariable Long id, @RequestBody T entity) throws Exception {
  return ResponseEntity.ok(service.updateEntity(id, entity));
 }

}
