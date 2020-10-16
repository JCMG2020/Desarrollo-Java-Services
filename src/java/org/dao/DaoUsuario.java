
package org.dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudUsuario;
import org.modelos.ModelUsuario;
public class DaoUsuario implements CrudUsuario {
    //Se crea un objeto publico del Usuario
    ModelUsuario usuario = new ModelUsuario();
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
        ArrayList<ModelUsuario> lstUsuario = new ArrayList<>();
         try {            
            strSql = "SELECT U.ID, U.USUARIO_ALIAS, U.NOMBRE, U.APELLIDO, U.EMAIL, U.CONTRASENA, U.TELEFONO, TP.DESCRIPCION AS TIPO_USUARIO_NOMBRE, U.DPI, U.ESTADO FROM USUARIO U INNER JOIN TIPO_USUARIO TP ON U.TIPO_USUARIO = TP.ID";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelUsuario usu = new ModelUsuario();
                usu.setIdUsuario(rs.getInt("ID"));
                usu.setUsuario_alias(rs.getString("USUARIO_ALIAS"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setEmail(rs.getString("EMAIL"));
                usu.setContrasena(rs.getString("CONTRASENA"));
                usu.setTelefono(rs.getString("TELEFONO"));
                usu.setTipo_usuario_nombre(rs.getString("TIPO_USUARIO_NOMBRE"));
                usu.setDPI(rs.getString("DPI"));
                usu.setEstado(rs.getBoolean("ESTADO"));
                lstUsuario.add(usu);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstUsuario;
    }

    

    @Override
    public List login(String correo, String contrasena) {
        ArrayList<ModelUsuario> lstUsuario = new ArrayList<>();
                 
        
        try {            
            strSql = "SELECT * FROM USUARIO WHERE EMAIL='"+correo+"' AND CONTRASENA='"+contrasena+"'";  
            conexion.open();
            rs = conexion.executeQuery(strSql); 
            while (rs.next()) {
                ModelUsuario usu = new ModelUsuario();
                usu.setIdUsuario(rs.getInt("ID"));
                usu.setUsuario_alias(rs.getString("USUARIO_ALIAS"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setEmail(rs.getString("EMAIL"));
                usu.setContrasena(rs.getString("CONTRASENA"));
                usu.setTelefono(rs.getString("TELEFONO"));
                usu.setTipo_usuario(rs.getInt("TIPO_USUARIO"));
                usu.setDPI(rs.getString("DPI"));
                usu.setEstado(rs.getBoolean("ESTADO"));
                lstUsuario.add(usu);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstUsuario;
    }

    @Override
    public boolean insertar(ModelUsuario usuario) {
          //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO USUARIO (USUARIO_ALIAS, NOMBRE, APELLIDO, EMAIL, CONTRASENA, TELEFONO, TIPO_USUARIO, DPI, ESTADO) "
                + "VALUES ("
                +"'" + usuario.getUsuario_alias()+ "'"
                + ", '" + usuario.getNombre()+ "' "
                + ", '"+ usuario.getApellido()+ "'"
                + ", '"+ usuario.getEmail()+ "'"
                + ", '" + usuario.getContrasena()+ "'"
                + ", " + usuario.getTelefono()
                +","+ usuario.getTipo_usuario()
                +","+ usuario.getDPI()+",'"
                + usuario.getEstado()+ "')";       
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
    public boolean modificar(ModelUsuario usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE USUARIO SET USUARIO_ALIAS = '" + usuario.getUsuario_alias()+ "', " + 
                 "NOMBRE = '" + usuario.getNombre() + "', " + 
                 "APELLIDO = '" + usuario.getApellido() + "', " +
                 "EMAIL = '" + usuario.getEmail()+ "', " +
                 "CONTRASENA = '" + usuario.getContrasena() +"', "+
                 "TELEFONO = " + usuario.getTelefono() +", "+
                 "TIPO_USUARIO = " + usuario.getTipo_usuario() +", "+
                 "DPI = " + usuario.getDPI() +", "+
                 "ESTADO = '" + usuario.getEstado() +"' WHERE ID =" + usuario.getIdUsuario();
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
    public boolean eliminar(ModelUsuario usuario) {
        strSql = "DELETE USUARIO WHERE ID = " + usuario.getIdUsuario();
        
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
    
}
