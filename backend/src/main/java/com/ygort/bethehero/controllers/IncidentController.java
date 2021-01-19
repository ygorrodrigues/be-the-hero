package com.ygort.bethehero.controllers;

import com.ygort.bethehero.dto.IncidentDTO;
import com.ygort.bethehero.services.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/incidents")
public class IncidentController {

    @Autowired
    private IncidentService service;

    @GetMapping
    public ResponseEntity<List<IncidentDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        List<IncidentDTO> list = service.findAll(PageRequest.of(page-1, size));
        Long totalIncidents = service.countIncidents();
        return ResponseEntity.ok().header("X-Total-Count", totalIncidents.toString()).body(list);
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

    @DeleteMapping(value = "/{incidentId}")
    public ResponseEntity<String> delete(
            @PathVariable Long incidentId,
            @RequestHeader(value = "Authorization") Long ongId
    ) {
        boolean deleted = service.delete(incidentId, ongId);
        if(!deleted) {
            return ResponseEntity.status(400).body("Incident not found or operation not permitted");
        }
        return ResponseEntity.ok().body("Incident deleted: " + incidentId.toString());
    }

}
