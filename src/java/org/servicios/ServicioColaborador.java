package org.servicios;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.dao.DaoColaborador;
import org.modelos.ModelColaboradores;


@WebService(serviceName = "ServicioColaborador")
public class ServicioColaborador {

    @WebMethod(operationName = "ObtenerColaboradorres")
    public List<ModelColaboradores> getColaboradores() {        
        DaoColaborador daoColaborador = new DaoColaborador();
        List<ModelColaboradores> lstColaborador = daoColaborador.listar();
        return lstColaborador;   
    }
    @WebMethod(operationName = "insertarColaborador")
    public boolean insertarColaborador(                              
                               
                              @WebParam(name = "NOMBRE") String nombre,
                              @WebParam(name = "APELLIDO") String apellido,
                              @WebParam(name = "DPI") String dpi,
                              @WebParam(name = "ID_CARGO") int idCargo,                          
                              @WebParam(name = "FCH_NAC") String fecha_nac,
                              @WebParam(name = "FCH_CONTRAT") String fecha_contrat,
                              @WebParam(name = "DOMICILIO") String domicilio,                             
                               @WebParam(name = "TELEFONO") String telefono,
                              @WebParam(name = "PLACA") String placa,
                              @WebParam(name = "ESTADO") boolean estado) {
        //Se crea el objeto
        ModelColaboradores colaborador = new ModelColaboradores();
        colaborador.setNombre(nombre);
        colaborador.setApellido(apellido);
        colaborador.setIdCargo(idCargo);
        colaborador.setFechaNacimiento(fecha_nac);
        colaborador.setFechaContratacion(fecha_contrat);
        colaborador.setDomicilio(domicilio);
        colaborador.setDPI(dpi);
        colaborador.setTelefono(telefono);
        colaborador.setPlaca(placa);
        colaborador.setEstado(estado);
        //Instanciamos el objeto 
        DaoColaborador daoColaborador = new DaoColaborador();
        //Insertamos y retornamos la respuesta
        return daoColaborador.insertar(colaborador  );
        
    }
    @WebMethod(operationName = "actualizarColaborador")
     public boolean actualizarColaborador(@WebParam(name = "ID") int id,
                                      @WebParam(name = "NOMBRE") String nombre,
                                      @WebParam(name = "APELLIDO") String apellido,
                                      @WebParam(name = "DPI") String dpi,
                                      @WebParam(name = "ID_CARGO") int idCargo,                          
                                      @WebParam(name = "FCH_NAC") String fecha_nac,
                                      @WebParam(name = "FCH_CONTRAT") String fecha_contrat,
                                     @WebParam(name = "DOMICILIO") String domicilio,                             
                                     @WebParam(name = "TELEFONO") String telefono,
                                     @WebParam(name = "PLACA") String placa,
                                     @WebParam(name = "ESTADO") boolean estado){
    ModelColaboradores colaborador = new ModelColaboradores();
        colaborador.setIdColaborador(id);
        colaborador.setNombre(nombre);
        colaborador.setApellido(apellido);
        colaborador.setIdCargo(idCargo);
        colaborador.setFechaNacimiento(fecha_nac);
        colaborador.setFechaContratacion(fecha_contrat);
        colaborador.setDomicilio(domicilio);
        colaborador.setDPI(dpi);
        colaborador.setTelefono(telefono);
        colaborador.setPlaca(placa);
        colaborador.setEstado(estado);
        //Instanciamos el objeto 
        DaoColaborador daoColaborador = new DaoColaborador();
        //Insertamos y retornamos la respuesta
        return daoColaborador.modificar(colaborador);
     }
     
     @WebMethod(operationName = "eliminarColaborador")
     public boolean eliminarColaborador(@WebParam(name = "id") int id) {
        
        ModelColaboradores colaborador = new ModelColaboradores();
        colaborador.setIdColaborador(id);
        //Instanciamos el objeto 
        DaoColaborador daoColaborador = new DaoColaborador();                  
        return daoColaborador.eliminar(colaborador);
        
    }
     @WebMethod(operationName = "ObtenerCargos")
    public List<ModelColaboradores> ObtenerCargos() {        
        DaoColaborador daoColaborador = new DaoColaborador();
        List<ModelColaboradores> lstColaborador = daoColaborador.listarCargos();
        return lstColaborador;   
    }
}
