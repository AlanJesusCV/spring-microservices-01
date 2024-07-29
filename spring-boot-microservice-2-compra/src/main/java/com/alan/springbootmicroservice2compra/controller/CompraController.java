package com.alan.springbootmicroservice2compra.controller;

import com.alan.springbootmicroservice2compra.model.Compra;
import com.alan.springbootmicroservice2compra.service.CompraSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/compra")
public class CompraController {

    @Autowired
    private CompraSService compraSService;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra){
        return new ResponseEntity<>(compraSService.saveCompra(compra), HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllComprasOfUser(@PathVariable Long userId){
        return ResponseEntity.ok(compraSService.findAllComprasOfUser(userId));
    }
}
