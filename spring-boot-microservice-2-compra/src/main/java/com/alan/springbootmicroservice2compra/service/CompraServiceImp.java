package com.alan.springbootmicroservice2compra.service;

import com.alan.springbootmicroservice2compra.model.Compra;
import com.alan.springbootmicroservice2compra.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompraServiceImp implements CompraSService{

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public Compra saveCompra(Compra compra){
        compra.setFechaCompra(LocalDateTime.now());
        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> findAllComprasOfUser(Long userId){
        return compraRepository.findAllByUserID(userId);
    }



}
