package com.project.estilo_y_elegancia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

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

 @OneToMany
 private List<MdClothes> clothes;
}
