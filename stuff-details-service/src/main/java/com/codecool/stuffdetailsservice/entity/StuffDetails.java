package com.codecool.stuffdetailsservice.entity;

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
public class StuffDetails {

    @Id
    @GeneratedValue
    public Long id;

    public String purchaseYear;

    public String description;

    public String youtubeVideoUrl;

    public Long stuffId;
}
