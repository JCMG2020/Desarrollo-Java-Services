package org.interfaces;
import java.util.List;
import org.modelos.ModelColaboradores;
public interface CrudColaborador {
    
    public List listar();
    public boolean insertar(ModelColaboradores colaborador);
    public boolean modificar(ModelColaboradores colaborador);
    public boolean eliminar(ModelColaboradores colaborador);
    public List listarCargos();
}
