package com.ygort.bethehero.controllers;

import com.ygort.bethehero.dto.ONGDTO;
import com.ygort.bethehero.entities.ONG;
import com.ygort.bethehero.services.ONGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ongs")
public class ONGController {

    @Autowired
    private ONGService service;

    @GetMapping
    public ResponseEntity<List<ONGDTO>> findAll() {
        List<ONGDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
