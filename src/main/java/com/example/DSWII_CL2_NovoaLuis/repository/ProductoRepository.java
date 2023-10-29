package com.example.DSWII_CL2_NovoaLuis.repository;

import com.example.DSWII_CL2_NovoaLuis.model.bd.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
