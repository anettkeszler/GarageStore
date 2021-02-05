package com.codecool.stuffservice.controller;

import com.codecool.stuffservice.entity.Stuff;
import com.codecool.stuffservice.model.StuffWithDetails;
import com.codecool.stuffservice.service.StuffProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stuff")
public class StuffController {

    @Autowired
    private StuffProvider stuffProvider;

    @GetMapping("/all")
    public List<Stuff> getAllStuff() {
        return stuffProvider.getAllStuff();
    }

    @GetMapping("/{stuff_id}")
    public StuffWithDetails getStuffWithDetailsByStuffId(@PathVariable("stuff_id") Long stuffId) {
        return stuffProvider.getStuffWithDetailsByStuffId(stuffId);
    }

    @PutMapping("/{stuff_id}/sold")
    public void setSoldStatusByStuffId(@PathVariable("stuff_id") Long stuffId) {
        stuffProvider.setSoldStatusByStuffId(stuffId);
    }

    @PutMapping("/{stuff_id}/update")
    public void updateStuffById(@PathVariable("stuff_id") Long stuffId,
                                @RequestBody StuffWithDetails stuffWithDetails) {
        stuffProvider.updateStuffById(stuffId, stuffWithDetails);
    }


    @PostMapping("/add")
    public ResponseEntity addNewStuffWithDetails(@RequestBody StuffWithDetails stuffWithDetails) {
        return stuffProvider.addNewStuffWithDetails(stuffWithDetails);
    }
}
