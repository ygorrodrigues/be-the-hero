package com.ygort.bethehero.controllers;

import com.ygort.bethehero.dto.IncidentDTO;
import com.ygort.bethehero.services.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/incidents")
public class IncidentController {

    @Autowired
    private IncidentService service;

    @GetMapping
    public ResponseEntity<List<IncidentDTO>> findAll() {
        List<IncidentDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<IncidentDTO> insert(
            @RequestBody IncidentDTO dto,
            @RequestHeader(value = "Authorization") Long ongId
    ) {
        dto = service.insert(dto, ongId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
