package com.codecool.stuffdetailsservice.service;

import com.codecool.stuffdetailsservice.entity.StuffDetails;
import com.codecool.stuffdetailsservice.repository.StuffDetailsRepository;
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
    private StuffDetailsRepository stuffDetailsRepository;

    private static Logger LOGGER = LoggerFactory.getLogger(DBInitializer.class);

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("Initializing stuff details database");
        List<StuffDetails> stuffDetailsList = new ArrayList<>();
        stuffDetailsList.add(StuffDetails.builder()
                  .purchaseYear("2019")
                  .description("Beleive me it is original, but I have more than 10 pairs! JUST BUY IT... ")
                  .youtubeVideoUrl("yshNZlWezDk")
                  .stuffId(1L)
                  .build()
        );

        stuffDetailsList.add(
                StuffDetails.builder()
                        .purchaseYear("2010")
                        .description("No UV filter, but who cares? This was owned by Elvis once!")
                        .youtubeVideoUrl("Dm8M7_P2NiY")
                        .stuffId(2L)
                        .build()
        );

        stuffDetailsList.add(
                StuffDetails.builder()
                        .purchaseYear("2020")
                        .description("Knife set of 12pcs. So Sharp so Good!")
                        .youtubeVideoUrl("yJ44SxiemMs")
                        .stuffId(3L)
                        .build()
        );

        stuffDetailsList.add(
                StuffDetails.builder()
                        .purchaseYear("2005")
                        .description("Sword of Uma Turman from the famous movie Kill Bill! Yeees... of course made by Hattori Hanso!")
                        .youtubeVideoUrl("VE_4zHNcieM")
                        .stuffId(4L)
                        .build()
        );

        stuffDetailsList.add(
                StuffDetails.builder()
                        .purchaseYear("2018")
                        .description("be like Tony..")
                        .youtubeVideoUrl("9_GfjE3-1NE")
                        .stuffId(5L)
                        .build()
        );

        stuffDetailsList.add(
                StuffDetails.builder()
                        .purchaseYear("2019")
                        .description("Did you ever heard about the world's 1st real lightsaber? It is not a childplay! You can buy it now!")
                        .youtubeVideoUrl("AymYhmayWz4")
                        .stuffId(6L)
                        .build()
        );

        stuffDetailsList.add(
                StuffDetails.builder()
                        .purchaseYear("2020")
                        .description("Buy your smart watch and keep everthing in your hand - or ON your arm.")
                        .youtubeVideoUrl("IkXFTFBmjC4")
                        .stuffId(7L)
                        .build()
        );

        stuffDetailsList.add(
                StuffDetails.builder()
                        .purchaseYear("2020")
                        .description("Actually I don't know what is used for, but for further information just check the video.")
                        .youtubeVideoUrl("_4W1sHGJw3A")
                        .stuffId(8L)
                        .build()
        );

        stuffDetailsRepository.saveAll(stuffDetailsList);
        LOGGER.info("Initializing stuff details finished");
    }
}
