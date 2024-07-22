package jhsoftperu.service;

import java.util.List;
import java.util.Optional;
import jhsoftperu.dao.ClienteRepository;
import jhsoftperu.model.Cliente;
import jhsoftperu.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> ListCliet_x_Id(Integer id) {
        return clienteRepository.findById(id);
    }

    public Cliente actualizarCliente(Integer id, Cliente clienteActualizado) {
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        clienteExistente.setNombre_apellido(clienteActualizado.getNombre_apellido());
        clienteExistente.setDireccion(clienteActualizado.getDireccion());
        clienteExistente.setGmail(clienteActualizado.getGmail());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setEstado_civil(clienteActualizado.getEstado_civil());
        return clienteRepository.save(clienteExistente);
    }
}
