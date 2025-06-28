package soap.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soap.model.Categoria;
import soap.model.Cliente;
import soap.model.Producto;
import soap.repository.CategoriaRepository;
import soap.repository.ClienteRepository;
import soap.repository.ProductoRepository;

import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner cargarDatos(ClienteRepository clienteRepository,
                                         CategoriaRepository categoriaRepository,
                                         ProductoRepository productoRepositorys) {
        return args -> {
            //limpiar tablas para pruebas
            clienteRepository.deleteAll();
            categoriaRepository.deleteAll();
            productoRepositorys.deleteAll();

            Cliente cliente1 = new Cliente();
            cliente1.setDni("1234567890");
            cliente1.setNombre("Nathaly");
            cliente1.setApellido("Moncayo");
            cliente1.setEmail("nathaly@gmail.com");
            clienteRepository.save(cliente1);
            System.out.println("Cliente 1 registrado exitosamente");

            Cliente cliente2 = new Cliente();
            cliente2.setDni("1234567891");
            cliente2.setNombre("Juan");
            cliente2.setApellido("Ocaña");
            cliente2.setEmail("jocania@gmail.com");
            clienteRepository.save(cliente2);
            System.out.println("Cliente 2 registrado exitosamente");

            Cliente cliente3 = new Cliente();
            cliente3.setDni("1234567892");
            cliente3.setNombre("Ruth");
            cliente3.setApellido("Changalombo");
            cliente3.setEmail("rchangalombo@gmail.com");
            clienteRepository.save(cliente3);
            System.out.println("Cliente 3 registrado exitosamente");

            Categoria categoria1 = new Categoria();
            categoria1.setNombre("Limpieza");
            categoria1.setDescripcion("Productos de aseo y limpieza del hogar");
            categoriaRepository.save(categoria1);
            System.out.println("Categoria 1 registrada exitosamente");

            Categoria categoria2 = new Categoria();
            categoria2.setNombre("Eletrodomésticos");
            categoria2.setDescripcion("Productos para el hogar");
            categoriaRepository.save(categoria2);
            System.out.println("Categoria 2 registrada exitosamente");

            Producto p1 = new Producto();
            p1.setNombre("Desinfectante 1 galon lavanda");
            p1.setPrecio(39.99);
            p1.setCategoria(categoria1);
            System.out.println("Producto 1 registrado exitosamente");

            Producto p2 = new Producto();
            p2.setNombre("Suavizante de ropa caneca");
            p2.setPrecio(59.99);
            p2.setCategoria(categoria1);
            System.out.println("Producto 2 registrado exitosamente");

            Producto p3 = new Producto();
            p3.setNombre("Jabon líquido 1 litro");
            p3.setPrecio(3.99);
            p3.setCategoria(categoria1);
            System.out.println("Producto 3 registrado exitosamente");

            Producto p4 = new Producto();
            p4.setNombre("Microondas LG");
            p4.setPrecio(99.99);
            p4.setCategoria(categoria2);
            System.out.println("Producto 4 registrado exitosamente");

            Producto p5 = new Producto();
            p5.setNombre("Lavadora de ropa LG");
            p5.setPrecio(699.99);
            p5.setCategoria(categoria2);
            System.out.println("Producto 5 registrado exitosamente");

            //OPCIONAL -> AGREGAR LISTADO DE PRODUCTOS A CATEGORIAS
            categoria1.setProductos(Arrays.asList(p1, p2, p3));
            categoria2.setProductos(Arrays.asList(p4, p5));
            categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
            System.out.println("PROUDCTOS INICIALES CARGADOS EXITOSAMENTE");
        };
    }
}
