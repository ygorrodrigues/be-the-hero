package com.ygort.bethehero.services;

import com.ygort.bethehero.dto.ONGDTO;
import com.ygort.bethehero.entities.ONG;
import com.ygort.bethehero.repositories.ONGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ONGService {

    @Autowired
    private ONGRepository repository;

    @Transactional(readOnly = true)
    public List<ONGDTO> findAll() {
        List<ONG> list = repository.findAll();
        return list.stream().map(x -> new ONGDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public ONGDTO insert(ONGDTO dto) {
        ONG ong = new ONG(null, dto.getName(), dto.getEmail(), dto.getWhatsapp(),
                dto.getCity(), dto.getUf());
        ong = repository.save(ong);
        return new ONGDTO(ong);
    }
}
