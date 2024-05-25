package com.project.estilo_y_elegancia.services.implementation;

import com.project.estilo_y_elegancia.models.MdBaseEntity;
import com.project.estilo_y_elegancia.repositories.BaseRepository;
import com.project.estilo_y_elegancia.services.business.BaseServiceBs;

import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

import java.util.Optional;

public class BaseServiceImpl<T extends MdBaseEntity, ID extends Serializable> implements BaseServiceBs<T, ID> {

 protected BaseRepository<ID, T> _repository;

 public BaseServiceImpl(BaseRepository<ID, T> repository) {
  this._repository = repository;
 }

 @Override
 @Transactional
 public T saveEntity(T entity) throws Exception {
  try {
   return _repository.save(entity);
  } catch (Exception e) {
   throw e;
  }
 }

 @Override
 @Transactional
 public void deleteEntity(T entity) throws Exception {
  try {
   _repository.delete(entity);
  } catch (Exception e) {
   throw e;
  }
 }

 @Override
 @Transactional
 public T updateEntity(T entity) throws Exception {
  try {
   return _repository.save(entity);
  } catch (Exception e) {
   throw e;
  }
 }

 @Override
 public T findById(ID id) throws Exception {
  try {
   Optional<T> entity = _repository.findById(id);

   return entity.orElseThrow(() -> new Exception("No se encontro en la base de datos el regsitro con el id " + id));

  } catch (Exception e) {
   throw e;
  }
 }

 @Override
 public List<T> findAll() throws Exception {
  try {
   return _repository.findAll();
  } catch (Exception e) {
   throw e;
  }
 }

}
