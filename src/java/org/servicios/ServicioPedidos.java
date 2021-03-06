
package org.servicios;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.dao.DaoPedido;
import org.modelos.ModelPedido;
@WebService(serviceName = "ServicioPedidos")
public class ServicioPedidos {

    @WebMethod(operationName = "ObtenerPedidos")
    public List<ModelPedido> getUsuarios() {        
        DaoPedido daoPedido = new DaoPedido();
        List<ModelPedido> lstPedido = daoPedido.listar();
        return lstPedido;   
    }
    
    @WebMethod(operationName = "ObtenerUltimoPedido")
    public List<ModelPedido> getUltimoPedido(@WebParam(name = "usuario")int usu) {        
        DaoPedido daoPedido = new DaoPedido();
        List<ModelPedido> lstPedido = daoPedido.listarUltimoPedido(usu);
        return lstPedido;   
    }
    
    @WebMethod(operationName = "ObtenerPedidosPorUsuario")
    public List<ModelPedido> getPedidoPorUsuario(@WebParam(name = "usuario")int usu) {        
        DaoPedido daoPedido = new DaoPedido();
        List<ModelPedido> lstPedido = daoPedido.listarPedidosPorUsuario(usu);
        return lstPedido;   
    }
    
    @WebMethod(operationName = "ObtenerTipoPedido")
    public List<ModelPedido> getTipoPedido() {        
        DaoPedido daoPedido = new DaoPedido();
        List<ModelPedido> lstPedido = daoPedido.TipoPedido();
        return lstPedido;   
    }
    @WebMethod(operationName = "insertarPedido")
    public boolean insertarPedido(                              
                                @WebParam(name = "ID_USUARIO") int idUsuario,
                              @WebParam(name = "TIPO_PEDIDO") int tipoPedido,
                              @WebParam(name = "DIR_ORIGEN") String direccionOrigen,
                              @WebParam(name = "DIR_DESTINO") String direccionDestino,
                              @WebParam(name = "COMENTARIO") String comentario
                              ){
        //Se crea el objeto
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
        String fechaActual = fecha.format(new Date());
        
        ModelPedido pedido = new ModelPedido();
        pedido.setIdUsuario(idUsuario);
        pedido.setTipo_pedido(tipoPedido);
        pedido.setDireccion_origen(direccionOrigen);
        pedido.setDireccion_destino(direccionDestino);
        pedido.setFecha_ingreso(fechaActual);
        pedido.setComentario(comentario);
        //Instanciamos el objeto 
        DaoPedido daoPedido = new DaoPedido();
        //Insertamos y retornamos la respuesta
        return daoPedido.insertar(pedido);
        
    }
    @WebMethod(operationName = "actualizarPedido")
    public boolean actualizarPedido(@WebParam(name = "IdPedido") int IdPedido,
            @WebParam(name = "IdEstado") int IdEstado){       
        ModelPedido pedido = new ModelPedido();
        pedido.setIdPedido(IdPedido);
        pedido.setIdEstado(IdEstado);

        //Instanciamos el objeto 
        DaoPedido daoPedido = new DaoPedido();                  
        return daoPedido.modificar(pedido);
    }
}
