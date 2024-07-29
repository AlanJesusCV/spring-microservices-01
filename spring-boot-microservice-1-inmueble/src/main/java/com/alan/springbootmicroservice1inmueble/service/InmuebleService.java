package com.alan.springbootmicroservice1inmueble.service;

import com.alan.springbootmicroservice1inmueble.model.Inmueble;

import java.util.List;

public interface InmuebleService {
    Inmueble saveInmueble(Inmueble inmueble);

    void deleteInmueble(Long idInm);

    List<Inmueble> findAllInmuebless();
}
