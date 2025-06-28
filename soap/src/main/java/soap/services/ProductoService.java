package soap.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import soap.model.Producto;

import java.util.List;

@WebService(name = "ProductoService")
public interface ProductoService {

    @WebMethod
    List<Producto> listProductos();

    @WebMethod
    Producto getProductoById(@WebParam(name = "id") Long id);

    @WebMethod
    Producto createProducto(@WebParam(name = "producto") Producto producto);

    @WebMethod
    boolean deleteProducto(@WebParam(name = "id") Long id);
}
