package com.alan.springbootmicroservice2compra.service;

import com.alan.springbootmicroservice2compra.model.Compra;

import java.util.List;

public interface CompraSService {
    Compra saveCompra(Compra compra);

    List<Compra> findAllComprasOfUser(Long userId);
}
