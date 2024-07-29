package com.alan.springbootmicroservice1inmueble.repository;

import com.alan.springbootmicroservice1inmueble.model.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository <Inmueble, Long> {


}
