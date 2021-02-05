package com.codecool.stuffservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StuffDetailsResult {

    public Long id;

    public String purchaseYear;

    public String description;

    public String youtubeVideoUrl;

    public Long stuffId;
}
