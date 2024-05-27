package com.project.estilo_y_elegancia.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "customer")
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class MdCustomer extends MdBaseEntity {
 private String name;
 @Column(name = "last_name")
 private String lastName;

 @Column(name = "phone_number", length = 20, unique = true)
 private String phoneNumber;
}
