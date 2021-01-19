package com.ygort.bethehero.services;

import com.ygort.bethehero.dto.ONGDTO;
import com.ygort.bethehero.entities.ONG;
import com.ygort.bethehero.repositories.ONGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionService {

    @Autowired
    private ONGRepository repository;

    @Transactional(readOnly = true)
    public ONGDTO findOng(Long ongId) {
        ONG ong = repository.findById(ongId).get();
        return new ONGDTO(ong);
    }
}
