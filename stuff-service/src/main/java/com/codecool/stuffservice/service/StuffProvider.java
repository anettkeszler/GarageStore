package com.codecool.stuffservice.service;

import com.codecool.stuffservice.entity.Stuff;
import com.codecool.stuffservice.model.StuffDetailsResult;
import com.codecool.stuffservice.model.StuffWithDetails;
import com.codecool.stuffservice.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class StuffProvider {

    @Autowired
    private StuffRepository stuffRepository;

    @Autowired
    private StuffDetailsServiceCaller stuffDetailsServiceCaller;

    public List<Stuff> getAllStuff() {
        return stuffRepository.findAll();
    }

    public StuffWithDetails getStuffWithDetailsByStuffId(Long stuffId) {
        StuffWithDetails stuffWithDetails = StuffWithDetails.builder().build();
        Optional<Stuff> stuff = stuffRepository.findById(stuffId);

        if (stuff.isPresent()) {
            StuffDetailsResult stuffDetailsResult = stuffDetailsServiceCaller
                    .getStuffDetailsResultByStuffId(stuffId);
            stuffWithDetails.setStuff(stuff.get());
            stuffWithDetails.setStuffDetailsResult(stuffDetailsResult);
        }

        return stuffWithDetails;
    }

    public void updateStuffById(Long stuffId, StuffWithDetails stuffWithDetails) {
        Stuff updatedStuff = stuffWithDetails.getStuff();
        updatedStuff.setId(stuffId);
        stuffRepository.save(updatedStuff);
        stuffDetailsServiceCaller.updateStuffDetailsByStuffId(stuffId, stuffWithDetails.getStuffDetailsResult());
    }

    public ResponseEntity addNewStuffWithDetails(StuffWithDetails stuffWithDetails) {
        Map<String, List<String>> responseModel = new TreeMap<>();

        //Check properties of Stuff and collect errors
        List<String> errorsOfStuff = new ArrayList<>();
        if (stuffWithDetails.getStuff().getName() == null) {
            errorsOfStuff.add("Stuff' name should be provided");
        }
        if (stuffWithDetails.getStuff().getPrice() == 0) {
            errorsOfStuff.add("Stuff' price should be provided");
        }
        if (!errorsOfStuff.isEmpty()) {
            responseModel.put("Stuff", errorsOfStuff);
        }

        //Check properties of StuffDetailsResult and collect errors
        List<String> errorsOfStuffDetailsResult = new ArrayList<>();
        if(stuffWithDetails.getStuffDetailsResult().getDescription() == null) {
            errorsOfStuffDetailsResult.add("Description should be provided");
        }
        if (stuffWithDetails.getStuffDetailsResult().getPurchaseYear() == null) {
            errorsOfStuffDetailsResult.add("Purchased year should be provided");
        }
        if (!errorsOfStuffDetailsResult.isEmpty()) {
            responseModel.put("StuffDetails", errorsOfStuffDetailsResult);
        }

        //In case of any error returns with the errors
        if (!responseModel.isEmpty()) {
            return ResponseEntity.badRequest().body(responseModel);
        }

        List<String> successMessages = new ArrayList<>();
        Stuff stuff = Stuff.builder()
                .name(stuffWithDetails.getStuff().getName())
                .price(stuffWithDetails.getStuff().getPrice())
                .image(stuffWithDetails.getStuff().getImage())
                .build();

        successMessages.add("Stuff succesfully created");
        Stuff stuffFromDB = stuffRepository.save(stuff);

        ResponseEntity detailsServiceResponse = stuffDetailsServiceCaller.addNewStuffDetail(stuffFromDB.getId(), stuffWithDetails.getStuffDetailsResult());
        successMessages.add((String) detailsServiceResponse.getBody());
        responseModel.put("StuffWithDetails", successMessages);
        return ResponseEntity.ok(responseModel);
    }

    public void setSoldStatusByStuffId(Long stuffId) {
        Optional<Stuff> optionalStuff = stuffRepository.findById(stuffId);
        Stuff stuff;
        if (optionalStuff.isPresent()) {
            stuff = optionalStuff.get();
            stuff.setSoldStatus(true);
            stuffRepository.save(stuff);
        }
    }
}
