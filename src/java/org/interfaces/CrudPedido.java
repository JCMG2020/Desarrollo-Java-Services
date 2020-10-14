package org.interfaces;
import java.util.List;
import org.modelos.Pedido;
public interface CrudPedido {
    public List listar();
    public boolean insertar(Pedido pedido);
    public boolean modificar(Pedido pedido);
    
}
