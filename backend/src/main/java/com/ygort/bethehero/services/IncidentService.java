package com.ygort.bethehero.services;

import com.ygort.bethehero.dto.IncidentDTO;
import com.ygort.bethehero.entities.Incident;
import com.ygort.bethehero.entities.ONG;
import com.ygort.bethehero.repositories.IncidentRepository;
import com.ygort.bethehero.repositories.ONGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository repository;

    @Autowired
    private ONGRepository ongRepository;

    @Transactional(readOnly = true)
    public List<IncidentDTO> findAll(){
        List<Incident> incidents = repository.findAll();
        return incidents.stream().map(x -> new IncidentDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public IncidentDTO insert(IncidentDTO dto, Long ongId) {
        Incident incident = new Incident(null, dto.getTitle(), dto.getDescription(), dto.getValue());
        ONG ong = ongRepository.findById(ongId).get();
        incident.setOng(ong);
        incident = repository.save(incident);
        return new IncidentDTO(incident);
    }
}
