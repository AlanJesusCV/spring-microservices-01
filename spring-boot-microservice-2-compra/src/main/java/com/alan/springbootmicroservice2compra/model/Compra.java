package com.alan.springbootmicroservice2compra.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="compra")
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable = false)
    private Long userID;

    @Column(name = "inmuebleId", nullable = false)
    private Long inmuebleId;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "fechaCompra", nullable = false)
    private LocalDateTime fechaCompra;
}
