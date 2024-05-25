package com.project.estilo_y_elegancia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.project.estilo_y_elegancia.models.MdBaseEntity;
import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<Id extends Serializable, T extends MdBaseEntity>
    extends JpaRepository<T, Id> {

}
