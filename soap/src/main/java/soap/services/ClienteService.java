package soap.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import soap.model.Cliente;

import java.util.List;

@WebService(name = "ClienteService")
public interface ClienteService {

    @WebMethod
    List<Cliente> listClientes();

    @WebMethod
    @WebResult(name = "Cliente")
    Cliente getCliente(@WebParam(name = "id") Long id);

    @WebMethod
    Cliente createCliente(@WebParam(name = "cliente") Cliente cliente);

    @WebMethod
    boolean deleteCliente(@WebParam(name = "id") Long id);
}
