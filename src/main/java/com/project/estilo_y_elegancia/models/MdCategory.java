package com.project.estilo_y_elegancia.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "category")
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class MdCategory extends MdBaseEntity {
 @Column(length = 100)
 private String description; // example : "womenswear, mens clothing, shoes, etc"
}
