package com.codecool.stuffservice.model;

import com.codecool.stuffservice.entity.Stuff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StuffWithDetails {

    private Stuff stuff;
    private StuffDetailsResult stuffDetailsResult;
}
