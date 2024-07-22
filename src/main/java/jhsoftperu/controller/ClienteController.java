package jhsoftperu.controller;
 
import io.swagger.annotations.ApiResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import jhsoftperu.model.Cliente;
import jhsoftperu.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
//@Api(value = "Clientes", description = "Operaciones relacionadas con los clientes") 
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //@ApiOperation(value = "Listar clientes", notes = "Devuelve una lista de todos los clientes")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarCliente(@Valid @RequestBody Cliente cliente) {
        // Establecer el ID en null para que JPA genere un nuevo ID
        //cliente.setId(null);
        Cliente nuevoCliente = clienteService.registrarCliente(cliente);

        // Devolver un mensaje personalizado y el objeto Cliente en el cuerpo de la respuesta
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Registro exitoso");
        response.put("cliente", nuevoCliente);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //    @PostMapping("/register")
//    public ResponseEntity<Cliente> registrarCliente(@Valid @RequestBody Cliente cliente) {
//        Cliente nuevoCliente = clienteService.registrarCliente(cliente);
//        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientePorId(@PathVariable Integer id) {
        Optional<Cliente> clienteOptional = clienteService.ListCliet_x_Id(id);

        if (clienteOptional.isPresent()) {
            return ResponseEntity.ok(clienteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @Valid @RequestBody Cliente clienteActualizado) {
        Cliente clienteActualizadoRespuesta = clienteService.actualizarCliente(id, clienteActualizado);
        return new ResponseEntity<>(clienteActualizadoRespuesta, HttpStatus.OK);
    }

}
