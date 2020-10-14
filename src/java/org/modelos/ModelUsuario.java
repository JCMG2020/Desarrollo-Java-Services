
package org.modelos;

import java.math.BigInteger;


public class ModelUsuario {
   private int idUsuario;
   private String usuario_alias;

    public String getUsuario_alias() {
        return usuario_alias;
    }

    public void setUsuario_alias(String usuario_alias) {
        this.usuario_alias = usuario_alias;
    }
   private String nombre;
   private String apellido;
   private String email;
   private String contrasena;
   private int telefono;
   private int tipo_usuario;
   private float DPI;
   private boolean estado;
   
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public float getDPI() {
        return DPI;
    }

    public void setDPI(float   DPI) {
        this.DPI = DPI;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
   
}
