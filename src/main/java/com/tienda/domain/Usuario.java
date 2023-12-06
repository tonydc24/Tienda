
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
@Table(name = "usuario")
public class Usuario implements Serializable{ //serializacion guarda disco en memoria volatil
    private static final long serialVersionUID= 1L; //suma automatica del autoIncrement
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //que sean igual en la bd y en la clase 
    @Column (name="id_usuario")
    
    
    private long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;        
    private String rutaImagen;
    private boolean activo;

    
    @OneToMany //Un usuario puede tener multiples roles
    @JoinColumn (name ="id_usuario" )
    List<Rol> roles;
    
    
    
}
