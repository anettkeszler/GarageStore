package com.codecool.stuffservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Stuff {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String image;

    private int price;

    @Builder.Default
    private boolean soldStatus = false;


}
