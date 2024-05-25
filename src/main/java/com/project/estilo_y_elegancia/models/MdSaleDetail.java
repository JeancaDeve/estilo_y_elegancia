package com.project.estilo_y_elegancia.models;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "sale_detail")
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class MdSaleDetail extends MdBaseEntity {

 @Column(columnDefinition = "DATE")
 @CurrentTimestamp
 private String date;

 private double total;

 @OneToOne
 private MdSale sale;

 @OneToOne
 private MdCustomer customer;
}
