package soap.config;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soap.services.impl.CategoriaServicesImpl;
import soap.services.impl.ClienteServiceImpl;
import soap.services.impl.ProductoServiceImpl;

@Configuration
public class CxfConfig {

    @Bean
    public Endpoint clienteEndpoint(Bus bus, ClienteServiceImpl clienteService) {
        EndpointImpl endpoint = new EndpointImpl(bus, clienteService);
        endpoint.publish("/ClienteService");
        return endpoint;
    }

    @Bean
    public Endpoint productoEndpoint(Bus bus, ProductoServiceImpl productoService) {
        EndpointImpl endpoint = new EndpointImpl(bus, productoService);
        endpoint.publish("/ProductoService");
        return endpoint;
    }

    @Bean
    public Endpoint categoriaEndpoint(Bus bus, CategoriaServicesImpl impl) {
        EndpointImpl endpoint = new EndpointImpl(bus, impl);
        endpoint.publish("/CategoriaService");
        return endpoint;
    }
}
