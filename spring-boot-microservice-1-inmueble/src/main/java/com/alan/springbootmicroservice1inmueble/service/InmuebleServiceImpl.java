package com.alan.springbootmicroservice1inmueble.service;

import com.alan.springbootmicroservice1inmueble.model.Inmueble;
import com.alan.springbootmicroservice1inmueble.repository.InmuebleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InmuebleServiceImpl implements  InmuebleService{

    private final InmuebleRepository inmuebleRepository;


    public InmuebleServiceImpl(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    @Override
    public Inmueble saveInmueble(Inmueble inmueble){
        inmueble.setFecha_creacion(LocalDateTime.now());

        return inmuebleRepository.save(inmueble);
    }

    @Override
    public  void deleteInmueble(Long idInm){
        inmuebleRepository.deleteById(idInm);
    }

    @Override
    public List<Inmueble> findAllInmuebless(){
        return inmuebleRepository.findAll();
    }
}
