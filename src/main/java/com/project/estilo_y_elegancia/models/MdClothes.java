package com.project.estilo_y_elegancia.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "clothes")
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class MdClothes extends MdBaseEntity {
 @Column(length = 100)
 private String description;
 private int stock;
 private double price;
 @Column(name = "image_url")
 private String image;

 @ManyToOne
 private MdCategory category;
 @ManyToOne
 private MdSize size;
}
