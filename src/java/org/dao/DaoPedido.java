package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudPedido;
import org.modelos.ModelPedido;

public class DaoPedido implements CrudPedido {
//Se crea un objeto publico del Usuario
    ModelPedido pedido = new ModelPedido();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    @Override
    public List listar() {
        ArrayList<ModelPedido> lstPedido = new ArrayList<>();
         try {            
            strSql = "SELECT P.ID AS ID_PEDIDO, "
                    + "CONCAT (U.NOMBRE,+' '+U.APELLIDO) AS USUARIO, "
                    + "TP.DESCRIPCION AS TIPO_PEDIDO, "
                    + "P.DIR_ORIGEN, "
                    + "P.DIR_DESTINO, "
                    + "P.FCH_INGRESO, "
                    + "P.COMENTARIO, "
                    + "E.DESCRIPCION AS ESTADO, "
                    + "CONCAT(CO.NOMBRE,+' '+CO.APELLIDO) AS COLABORADOR  "
                    + "FROM PEDIDO P "
                    + "INNER JOIN USUARIO U ON P.ID_USUARIO = U.ID "
                    + "INNER JOIN TIPO_PEDIDO TP ON P.TIPO_PEDIDO = TP.ID "
                    + "INNER JOIN ESTADO E ON P.ID_ESTADO = E.ID "
                    + "INNER JOIN COLABORADOR CO ON P.ID_COLABORADOR = CO.ID";
            conexion.open();
            rs = conexion.executeQuery(strSql);        
            
            while (rs.next()) {
                ModelPedido ped = new ModelPedido();
                ped.setIdPedido(rs.getInt("ID_PEDIDO"));
                ped.setUsuario(rs.getString("USUARIO"));
                ped.setDescripcion_pedido(rs.getString("TIPO_PEDIDO"));
                ped.setDireccion_origen(rs.getString("DIR_ORIGEN"));
                ped.setDireccion_destino(rs.getString("DIR_DESTINO"));
                ped.setFecha_ingreso(rs.getString("FCH_INGRESO"));
                ped.setComentario(rs.getString("COMENTARIO"));
                ped.setEstado(rs.getString("ESTADO"));
                ped.setColaborador(rs.getString("COLABORADOR"));
                lstPedido.add(ped);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstPedido;
    }

    @Override
    public boolean insertar(ModelPedido  pedido) {
        
        //String strSql3 =  "UPDATE COLABORADOR SET COLABORADOR='FALSE'";
        strSql = "INSERT INTO PEDIDO (ID_USUARIO, TIPO_PEDIDO, DIR_ORIGEN, DIR_DESTINO, FCH_INGRESO, COMENTARIO, ID_ESTADO) "
                + "VALUES ("
                +"    " + pedido.getIdUsuario()+ ""
                + ",  " + pedido.getTipo_pedido()+ " "
                + ", '"+ pedido.getDireccion_origen()+ "'"
                + ", '"+ pedido.getDireccion_destino()+ "'"
                + ", '" + pedido.getFecha_ingreso()+ "'"
                + ", '" + pedido.getComentario() +"'"
                + ",  1)";       
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelPedido  pedido) {
     //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE PEDIDO SET ID_ESTADO = " + pedido.getIdEstado()+ " WHERE ID = " + pedido.getIdPedido();
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    
}
