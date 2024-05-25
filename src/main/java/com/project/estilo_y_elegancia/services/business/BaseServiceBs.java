package com.project.estilo_y_elegancia.services.business;

import com.project.estilo_y_elegancia.models.MdBaseEntity;
import java.io.Serializable;
import java.util.List;

public interface BaseServiceBs<T extends MdBaseEntity, ID extends Serializable> {
 public T saveEntity(T entity) throws Exception;

 public void deleteEntity(T entity)  throws Exception;

 public T updateEntity(T entity)  throws Exception;

 public T findById(ID id)  throws Exception;

 public List<T> findAll()  throws Exception;
}
