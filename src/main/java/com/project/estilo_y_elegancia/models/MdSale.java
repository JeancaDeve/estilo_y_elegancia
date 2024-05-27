package com.project.estilo_y_elegancia.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;

@Table(name = "sale")
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class MdSale extends MdBaseEntity {
 private int cant;
 private double total;
 @CurrentTimestamp
 @Column(columnDefinition = "DATE")
 private String date;
 
 @ManyToMany
 @JoinTable(name = "sale_clothes", // Create a join table
   joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "clothes_id"))
 private List<MdClothes> clothes;

 @ManyToOne(cascade = CascadeType.ALL)
 private MdCustomer customer;
}
