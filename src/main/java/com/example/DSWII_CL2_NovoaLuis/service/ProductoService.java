package com.example.DSWII_CL2_NovoaLuis.service;

import com.example.DSWII_CL2_NovoaLuis.model.bd.Producto;
import com.example.DSWII_CL2_NovoaLuis.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public Optional<Producto> productoXid(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }
    public Producto nuevo (Producto producto){
        return productoRepository.save(producto);
    }
    public Optional<Producto> obtenerProductoXNombre(String NomProducto){
        Optional<Producto> producto = productoRepository.findByNomProducto(NomProducto);
        if(producto.isEmpty())
            return Optional.empty();
        else
            return producto;
    }
    public List<Producto> obtenerProductosMayor10Menor100(){
        return productoRepository.listaProductoMa10Me100();
    }
}
