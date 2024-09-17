package com.zurimokato.ms_product.infrastructure.adapter.out.database.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("tshirt")
public class TShirtEntity extends ProductEntity{
    private String size;
    private String color;

}
