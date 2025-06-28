package soap.services.impl;

import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soap.model.Producto;
import soap.repository.ProductoRepository;
import soap.services.ProductoService;

import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "soap.services.ProductoService",
        serviceName = "ProductoService")
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto createProducto(Producto producto) {
        producto.setId(null);
        return productoRepository.save(producto);
    }

    @Override
    public boolean deleteProducto(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isPresent()) {
            productoRepository.deleteById(id);
        }
        return false;
    }
}
