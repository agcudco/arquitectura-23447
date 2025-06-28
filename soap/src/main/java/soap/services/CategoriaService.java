package soap.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import soap.model.Categoria;

import java.util.List;

@WebService(name = "CategoriaService")
public interface CategoriaService {

    @WebMethod
    @WebResult(name = "Categoria")
    Categoria getCategoriaById(@WebParam(name = "id") Long id);

    @WebMethod
    List<Categoria> getCategorias();

    @WebMethod
    Categoria createCategoria(@WebParam(name = "categoria") Categoria categoria);

    @WebMethod
    boolean deleteCategoria(@WebParam(name = "id") Long id);
}
