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
            strSql = "SELECT * FROM COLABORADOR ";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelColaboradores usu = new ModelColaboradores();
                usu.setIdColaborador(rs.getInt("ID"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setDPI(rs.getString("DPI"));
                usu.setIdCargo(rs.getInt("ID_Cargo"));             
                usu.setFechaNacimiento(rs.getString("FCH_NAC"));
                usu.setFechaContratacion(rs.getString("FCH_CONTRAT"));
                usu.setDomicilio(rs.getString("DOMICILiO"));
                usu.setTelefono(rs.getLong("TELEFONO"));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ModelColaboradores colaborador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(ModelColaboradores colaborador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
