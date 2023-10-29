package com.example.DSWII_CL2_NovoaLuis.model.bd;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;
    @Column(name = "nomproducto")
    private String nomproducto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fechavencimiento")
    private Date fechavencimiento;
}
