package org.dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudColaborador;
import org.modelos.ModelColaboradores;
public class DaoColaborador implements CrudColaborador{
    //Se crea un objeto publico del Usuario
    ModelColaboradores colaborador = new ModelColaboradores();
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
        ArrayList<ModelColaboradores> lstColaborador = new ArrayList<>();
         try {            
            strSql = "SELECT C.ID, C.NOMBRE,C.APELLIDO, C.DPI, TC.DESCRIPCION, C.FCH_NAC, C.FCH_CONTRAT, C.DOMICILIO, C.TELEFONO, C.PLACA, C.ESTADO FROM COLABORADOR C INNER JOIN TIPO_CARGO TC ON C.ID_CARGO = TC.ID";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelColaboradores usu = new ModelColaboradores();
                usu.setIdColaborador(rs.getInt("ID"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setDPI(rs.getString("DPI"));
                usu.setCargo(rs.getString("DESCRIPCION"));             
                usu.setFechaNacimiento(rs.getString("FCH_NAC"));
                usu.setFechaContratacion(rs.getString("FCH_CONTRAT"));
                usu.setDomicilio(rs.getString("DOMICILIO"));
                usu.setTelefono(rs.getString("TELEFONO"));
                usu.setPlaca(rs.getString("PLACA"));
                usu.setEstado(rs.getBoolean("ESTADO"));
                lstColaborador.add(usu);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstColaborador;
    }

    @Override
    public boolean insertar(ModelColaboradores colaborador) {
       //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO COLABORADOR (NOMBRE, APELLIDO, DPI, ID_CARGO, FCH_NAC, FCH_CONTRAT, DOMICILIO, TELEFONO, PLACA,  ESTADO)"
                + "VALUES ("
                +" '" + colaborador.getNombre()+ "', "
                +" '"+ colaborador.getApellido()+ "', "
                +" '"+ colaborador.getDPI()+ "', "
                +"  "+ colaborador.getIdCargo()+", "
                +" '" + colaborador.getFechaNacimiento()+ "', "
                +" '" + colaborador.getFechaContratacion()+"', "
                +" '"+ colaborador.getDomicilio()+"', "
                +" '"+ colaborador.getTelefono()+"', "
                +" '"+ colaborador.getPlaca()+"', "
                +" '"+ colaborador.getEstado()+ "')";       
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta; 
    }

    
    @Override
    public boolean eliminar(ModelColaboradores colaborador) {
        strSql = "DELETE COLABORADOR WHERE ID = " + colaborador.getIdColaborador();
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelColaboradores colaborador) {
               //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE COLABORADOR SET "+
                 "NOMBRE = '" + colaborador.getNombre()+ "', " + 
                 "APELLIDO = '" + colaborador.getApellido() + "', " + 
                 "DPI = '" + colaborador.getDPI() + "', " +
                 "ID_CARGO = " + colaborador.getIdCargo()+ ", " +
                 "FCH_NAC = '" + colaborador.getFechaNacimiento() +"', "+
                 "FCH_CONTRAT = '" + colaborador.getFechaContratacion() +"', "+
                 "DOMICILIO = '" + colaborador.getDomicilio() +"', "+
                 "TELEFONO = '" + colaborador.getTelefono() +"', "+
                 "PLACA = '" + colaborador.getPlaca() +"', "+
                 "ESTADO = '" + colaborador.getEstado() +"' WHERE ID =" + colaborador.getIdColaborador();
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    
}
