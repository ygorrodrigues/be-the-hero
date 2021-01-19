package com.ygort.bethehero.repositories;

import com.ygort.bethehero.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
