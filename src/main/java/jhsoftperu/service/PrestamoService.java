package jhsoftperu.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import jhsoftperu.dao.PrestamoRepository;
import jhsoftperu.model.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
/**
 *
 * @author Asus
 */
@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamorepository;

    public List<Prestamo> listarprestamo() {
        return prestamorepository.findAll();
    }

    public Prestamo Registrar_prestamo(Prestamo p) {
        return prestamorepository.save(p);
    }
    
    public Optional<Prestamo> ListPrestamo_x_id(Integer id){
        return prestamorepository.findById(id);
    }
    
    

    //Actualizar prestamo con SP
    @Transactional
    public String actualizarPrestamo(Integer id, String estado, Timestamp fechaActualizar, Date fechaDevolucion, Date fechaPrestamo, Double igv, Double monto, Double total, Integer clienteId) {
        try {
            prestamorepository.actualizarPrestamo(id, estado, fechaActualizar, fechaDevolucion, fechaPrestamo, igv, monto, total, clienteId);
            return "Actualización exitosa";
        } catch (Exception e) {
            return "No se pudo actualizar los datos: " + e.getMessage();
        }

//   @Transactional
//    public void actualizarPrestamo(Integer id, String estado, Timestamp fechaActualizar, Date fechaDevolucion, Date fechaPrestamo, Double igv, Double monto, Double total, Integer clienteId) {
//        prestamorepository.actualizarPrestamo(id, estado, fechaActualizar, fechaDevolucion, fechaPrestamo, igv, monto, total, clienteId);
    }

}
