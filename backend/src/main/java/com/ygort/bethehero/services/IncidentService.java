package com.ygort.bethehero.services;

import com.ygort.bethehero.dto.IncidentDTO;
import com.ygort.bethehero.entities.Incident;
import com.ygort.bethehero.entities.ONG;
import com.ygort.bethehero.repositories.IncidentRepository;
import com.ygort.bethehero.repositories.ONGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<IncidentDTO> findAll(Pageable pageable) {
        Page<Incident> incidents = repository.findAll(pageable);
        return incidents.stream().map(x -> new IncidentDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Long countIncidents() {
        return repository.count();
    }

    @Transactional
    public IncidentDTO insert(IncidentDTO dto, Long ongId) {
        Incident incident = new Incident(null, dto.getTitle(), dto.getDescription(), dto.getValue());
        ONG ong = ongRepository.findById(ongId).get();
        incident.setOng(ong);
        incident = repository.save(incident);
        return new IncidentDTO(incident);
    }

    @Transactional
    public boolean delete(Long incidentId, Long ongId) {
        try {
            Incident incident = repository.findById(incidentId).get();
            if(incident.getOng().getId().equals(ongId)) {
                repository.delete(incident);
                return true;
            }
            else return false;
        }
        catch (Exception e) {
            return false;
        }
    }
}
