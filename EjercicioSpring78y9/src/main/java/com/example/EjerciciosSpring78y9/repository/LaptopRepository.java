package com.example.EjerciciosSpring78y9.repository;

import com.example.EjerciciosSpring78y9.entities.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {
}
