package com.codecool.stuffservice.service;

import com.codecool.stuffservice.entity.Stuff;
import com.codecool.stuffservice.repository.StuffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBInitializer {

    @Autowired
    private StuffRepository stuffRepository;

    private static Logger LOGGER = LoggerFactory.getLogger(DBInitializer.class);

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("Initializing stuff database");
        List<Stuff> stuffList = new ArrayList<>();

        stuffList.add(Stuff.builder()
                .name("Nike shoes")
                .image("https://images.unsplash.com/photo-1460353581641-37baddab0fa2?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8c2hvZXN8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60")
                .price(10)
                .build());

        stuffList.add(Stuff.builder()
                .name("Elvis's sunglasses")
                .image("https://images.unsplash.com/photo-1606196480617-47862998df85?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=967&q=80")
                .price(100)
                .build());

        stuffList.add(Stuff.builder()
                .name("Jamie Oliver knife set")
                .image("https://images.unsplash.com/photo-1593618998160-e34014e67546?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=911&q=80")
                .price(10).build());

        stuffList.add(Stuff.builder()
                .name("Samurai sword")
                .image("https://images.unsplash.com/photo-1569995617877-d845becc0d40?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80")
                .price(10000).build());

        stuffList.add(Stuff.builder()
                .name("IronMan suit")
                .image("https://images.unsplash.com/photo-1563902698405-d4ac5e6047b9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80")
                .price(1000).build());

        stuffList.add(Stuff.builder()
                .name("Lightsaber")
                .image("https://cdn.shopify.com/s/files/1/1440/9434/products/mpp1-11_740x.jpg?v=1558467177")
                .price(20000).build());

        stuffList.add(Stuff.builder()
                .name("Smart watch")
                .image("https://images.unsplash.com/photo-1517420879524-86d64ac2f339?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=626&q=80")
                .price(150).build());

        stuffList.add(Stuff.builder()
                .name("Smart Stylus Pen")
                .image("https://images.unsplash.com/photo-1522159698025-071104a1ddbd?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80")
                .price(74).build());

        stuffRepository.saveAll(stuffList);
        LOGGER.info("Initializing stuff finished");
    }
}
