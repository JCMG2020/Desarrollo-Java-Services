package org.servicios;

import java.math.BigInteger;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.dao.DaoUsuario;
import org.modelos.ModelUsuario;
@WebService(serviceName = "ServiciosUsuario")
public class ServiciosUsuario {
    
    @WebMethod(operationName = "ObtenerUsuarios")
    public List<ModelUsuario> getUsuarios() {        
        DaoUsuario daoUsuario = new DaoUsuario();
        List<ModelUsuario> lstUsuario = daoUsuario.listar();
        return lstUsuario;   
    }
   @WebMethod(operationName = "LoginUsuario")
    public List<ModelUsuario> login(@WebParam(name = "email") String email,                              
                         @WebParam(name = "contrasena") String contrasena){
        DaoUsuario daoUsuario = new DaoUsuario();  
        List<ModelUsuario> lstLogin = daoUsuario.login(email, contrasena);
        return lstLogin;
    }
    @WebMethod(operationName = "insertarUsuario")
    public boolean insertarUsuario(                              
                                @WebParam(name = "USUARIO_ALIAS") String usuario_alias,
                              @WebParam(name = "NOMBRE") String nombre,
                              @WebParam(name = "APELLIDO") String apellido,
                              @WebParam(name = "EMAIL") String email,
                              @WebParam(name = "CONTRASENA") String contrasena,
                              @WebParam(name = "TELEFONO") String telefono,
                              @WebParam(name = "TIPO_USUARIO") int tipo_usuario,
                              @WebParam(name = "DPI") String dpi,
                              @WebParam(name = "ESTADO") boolean estado) {
        //Se crea el objeto
        ModelUsuario usuario = new ModelUsuario();
        usuario.setUsuario_alias(usuario_alias);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setContrasena(contrasena);
        usuario.setTelefono(telefono);
        usuario.setTipo_usuario(tipo_usuario);
        usuario.setDPI(dpi);
        usuario.setEstado(estado);
        //Instanciamos el objeto 
        DaoUsuario daoUsuario = new DaoUsuario();
        //Insertamos y retornamos la respuesta
        return daoUsuario.insertar(usuario);
        
    }
    public boolean actualizarUsuario(@WebParam(name = "ID") int id,
                              @WebParam(name = "USUARIO_ALIAS") String usuario_alias,
                              @WebParam(name = "NOMBRE") String nombre,
                              @WebParam(name = "APELLIDO") String apellido,
                              @WebParam(name = "EMAIL") String email,
                              @WebParam(name = "CONTRASENA") String contrasena,
                              @WebParam(name = "TELEFONO") String telefono,
                              @WebParam(name = "TIPO_USUARIO") int tipo_usuario,
                              @WebParam(name = "DPI") String  dpi,
                              @WebParam(name = "ESTADO") boolean estado){
       
        
        
        ModelUsuario usuario = new ModelUsuario();
        usuario.setIdUsuario(id);
        usuario.setUsuario_alias(usuario_alias);
        usuario.setNombre(nombre); 
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setContrasena(contrasena);
        usuario.setTelefono(telefono);
        usuario.setTipo_usuario(tipo_usuario);
        usuario.setDPI(dpi);
        usuario.setEstado(estado);
        //Instanciamos el objeto 
        DaoUsuario daoUsuario = new DaoUsuario();
        
                  
        return daoUsuario.modificar(usuario);
    }
    public boolean eliminarUsuario(@WebParam(name = "id") int id) {
        
        ModelUsuario usuario = new ModelUsuario();
        usuario.setIdUsuario(id);
        //Instanciamos el objeto 
        DaoUsuario daoUsuario = new DaoUsuario();                  
        return daoUsuario.eliminar(usuario);
        
    }
}
