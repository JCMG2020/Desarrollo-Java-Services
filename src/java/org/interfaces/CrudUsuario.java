package org.interfaces;

import java.util.List;
import org.modelos.ModelUsuario;
public interface CrudUsuario {
    public List listar();
    public List login(String correo, String contrasena);
    public boolean insertar(ModelUsuario usuario);
    public boolean modificar(ModelUsuario usuario);
    public boolean eliminar(ModelUsuario usuario);
    public List listarTipoUsuario();
}
