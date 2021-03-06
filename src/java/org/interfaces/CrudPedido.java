package org.interfaces;
import java.util.List;
import org.modelos.ModelPedido;
public interface CrudPedido {
    public List listar();
    public List listarUltimoPedido(int usuario);
    public List listarPedidosPorUsuario(int usuario);
    public boolean insertar(ModelPedido pedido);
    public boolean modificar(ModelPedido pedido);
    public List TipoPedido();
}
