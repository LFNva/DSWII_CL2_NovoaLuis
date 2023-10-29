package com.example.DSWII_CL2_NovoaLuis.controller;

import com.example.DSWII_CL2_NovoaLuis.exception.ResourceNotFoundException;
import com.example.DSWII_CL2_NovoaLuis.model.bd.Producto;
import com.example.DSWII_CL2_NovoaLuis.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productoList = new ArrayList<>();
        productoService.listarProductos()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable("id") Integer id){
        Producto producto = productoService.productoXid(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                    id + " no existe."));
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(
            @RequestBody Producto producto
    ){
        return new ResponseEntity<>(
                productoService.nuevo(producto), HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto
    ){
        Producto oldProducto = productoService
                .productoXid(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));
        oldProducto.setNomproducto(producto.getNomproducto());
        oldProducto.setDescripcion(producto.getDescripcion());
        oldProducto.setCantidad(producto.getCantidad());
        oldProducto.setFechavencimiento(producto.getFechavencimiento());
        return new ResponseEntity<>(
                productoService.nuevo(oldProducto), HttpStatus.OK
        );
    }
    @GetMapping("/nomproducto/{nomproducto}")
    public ResponseEntity<Producto> filtrarProductoPorNombre(
            @PathVariable("nomproducto") String nomproducto
    ){
        Producto producto = productoService
                .obtenerProductoXNombre(nomproducto)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el nombre "+
                        nomproducto + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    @GetMapping("/cantidadmayor")
    public ResponseEntity<List<Producto>> listaMayor10(){
        List<Producto> productoList = new ArrayList<>();
        productoService.obtenerProductosMayor10Menor100()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

}
