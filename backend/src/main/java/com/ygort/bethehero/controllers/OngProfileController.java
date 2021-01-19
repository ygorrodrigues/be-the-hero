package com.ygort.bethehero.controllers;

import com.ygort.bethehero.dto.ONGDTO;
import com.ygort.bethehero.services.OngProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profile")
public class OngProfileController {

    @Autowired
    private OngProfileService service;

    @GetMapping
    public ResponseEntity<ONGDTO> findOngProfile(
            @RequestHeader(value = "Authorization") Long ongId
    ) {
        ONGDTO ong = service.findIncidentsOfOng(ongId);
        return ResponseEntity.ok().body(ong);
    }
}
