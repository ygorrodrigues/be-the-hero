package com.ygort.bethehero.services;

import com.ygort.bethehero.dto.ONGDTO;
import com.ygort.bethehero.entities.ONG;
import com.ygort.bethehero.repositories.ONGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OngProfileService {

    @Autowired
    private ONGRepository ongRepository;

    @Transactional(readOnly = true)
    public ONGDTO findIncidentsOfOng(Long ongId) {
        ONG ong = ongRepository.findById(ongId).get();
        return new ONGDTO(ong);
    }
}
