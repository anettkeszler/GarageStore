package com.codecool.stuffdetailsservice.repository;

import com.codecool.stuffdetailsservice.entity.StuffDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StuffDetailsRepository extends JpaRepository<StuffDetails, Long> {

    StuffDetails getStuffDetailsByStuffId(Long stuffId);

}
