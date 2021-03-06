
package org.modelos;

import java.math.BigInteger;


public class ModelUsuario {
   private int idUsuario;
   private String usuario_alias;   
   private String nombre;
   private String apellido;
   private String email;
   private String contrasena;
   private String telefono;
   private int tipo_usuario;
   private String tipo_usuario_nombre;
   private String DPI;
   private boolean estado;
   
    public String getUsuario_alias() {
        return usuario_alias;
    }

    public void setUsuario_alias(String usuario_alias) {
        this.usuario_alias = usuario_alias;
    }
   
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String   DPI) {
        this.DPI = DPI;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
   
    public String getTipo_usuario_nombre() {
        return tipo_usuario_nombre;
    }

    public void setTipo_usuario_nombre(String tipo_usuario_nombre) {
        this.tipo_usuario_nombre = tipo_usuario_nombre;
    }
}
