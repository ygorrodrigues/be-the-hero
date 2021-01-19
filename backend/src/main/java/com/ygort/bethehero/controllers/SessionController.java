package com.ygort.bethehero.controllers;

import com.ygort.bethehero.dto.ONGDTO;
import com.ygort.bethehero.services.OngProfileService;
import com.ygort.bethehero.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {

    @Autowired
    private SessionService service;

    @PostMapping
    public ResponseEntity<ONGDTO> createSession(@RequestBody ONGDTO dto) {
        ONGDTO ong = service.findOng(dto.getId());
        return ResponseEntity.ok().body(ong);
    }

}
