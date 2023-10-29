package com.example.DSWII_CL2_NovoaLuis.repository;

import com.example.DSWII_CL2_NovoaLuis.model.bd.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByNomProducto(String NomProducto);
    @Query("Select p from Producto p where p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> listaProductoMa10Me100();
}
