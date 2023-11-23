
package com.tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{ //serializacion guarda disco en memoria volatil
    private static final long serialVersionUID= 1L; //suma automatica del autoIncrement
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //que sean igual en la bd y en la clase 
    @Column (name="id_categoria")
    
    
    private long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    
    @OneToMany
    @JoinColumn (name ="id_categoria" , updatable = false)
    List <Producto> productos;
    
    
    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    
}
