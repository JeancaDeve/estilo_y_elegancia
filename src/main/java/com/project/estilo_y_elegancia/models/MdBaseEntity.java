package com.project.estilo_y_elegancia.models;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdBaseEntity implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
}
