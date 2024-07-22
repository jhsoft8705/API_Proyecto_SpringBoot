package jhsoftperu.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import jhsoftperu.model.Cliente;
import jhsoftperu.model.Prestamo;
import jhsoftperu.service.PrestamoService;
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
@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoservicio;

    @GetMapping
    public ResponseEntity<List<Prestamo>> listar_prestamo() {
        List<Prestamo> prestamos = prestamoservicio.listarprestamo();
        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Prestamo> registrar_prestamo(@Valid @RequestBody Prestamo p) {
        Prestamo newprestamo = prestamoservicio.Registrar_prestamo(p);
        return new ResponseEntity<>(newprestamo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> listar_prestamos_x_id(@PathVariable Integer id) {
        Optional<Prestamo> prestamosOptional = prestamoservicio.ListPrestamo_x_id(id);
        if (prestamosOptional.isPresent()) {
            return ResponseEntity.ok(prestamosOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarPrestamo(@PathVariable Integer id, @Valid
            @RequestBody Prestamo prestamo) {

        //Convertir Timetamps a DATE
        java.sql.Timestamp sqlFechaActualizar = new java.sql.Timestamp(prestamo.getFecha_actualizar().getTime());

        String mensaje = prestamoservicio.actualizarPrestamo(id, prestamo.getEstado(),
                sqlFechaActualizar, prestamo.getFechaDevolucion(), prestamo.getFechaPrestamo(), prestamo.getIgv(), prestamo.getMonto(), prestamo.getTotal(), prestamo.getCliente().getId());
        return ResponseEntity.ok(mensaje);
    }

}
