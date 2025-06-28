package soap.services.impl;

import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soap.model.Cliente;
import soap.repository.ClienteRepository;
import soap.services.ClienteService;

import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "soap.services.ClienteService",
        serviceName = "ClienteService")
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> listClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        cliente.setId(null);
        return repository.save(cliente);
    }

    @Override
    public boolean deleteCliente(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
