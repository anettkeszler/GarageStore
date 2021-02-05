package com.codecool.stuffdetailsservice.service;

import com.codecool.stuffdetailsservice.entity.StuffDetails;
import com.codecool.stuffdetailsservice.repository.StuffDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StuffDetailsProvider {

    @Autowired
    private StuffDetailsRepository stuffDetailsRepository;

    public StuffDetails getStuffDetailsByStuffId(Long stuffId) {
        return stuffDetailsRepository.getStuffDetailsByStuffId(stuffId);
    }

    public void updateStuffDetailsByStuffId(Long stuffId, StuffDetails stuffDetails) {
        StuffDetails oldStuffDetails = stuffDetailsRepository.getStuffDetailsByStuffId(stuffId);
        oldStuffDetails.setDescription(stuffDetails.getDescription());
        oldStuffDetails.setPurchaseYear(stuffDetails.getPurchaseYear());
        oldStuffDetails.setYoutubeVideoUrl(stuffDetails.getYoutubeVideoUrl());
        stuffDetailsRepository.save(oldStuffDetails);
    }
    public void addNewStuffDetails(Long stuffId, StuffDetails stuffDetails) {
        StuffDetails newStuffDetails = StuffDetails.builder()
                .description(stuffDetails.getDescription())
                .purchaseYear(stuffDetails.getPurchaseYear())
                .stuffId(stuffId)
                .youtubeVideoUrl(stuffDetails.getYoutubeVideoUrl())
                .build();
        stuffDetailsRepository.save(newStuffDetails);
    }
}
