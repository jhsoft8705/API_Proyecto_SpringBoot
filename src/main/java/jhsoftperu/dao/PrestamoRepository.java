 
package jhsoftperu.dao;
 
import java.sql.Timestamp;
import java.util.Date;
 import jhsoftperu.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * JPA-CRUD
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{
    
    
   //Usar procedure para actualizar prestamo
    @Query(value = "CALL Sp_actualizar_prestamos(?, ?, ?, ?, ?, ?, ?, ?, ?)",nativeQuery = true)
    @Modifying
    void actualizarPrestamo(
            @Param("p_id") Integer id,
            @Param("p_estado") String estado,
            @Param("p_fecha_actualizar") Timestamp fechaActualizar,
            @Param("p_fecha_devolucion") Date fechaDevolucion,
            @Param("p_fecha_prestamo") Date fechaPrestamo,
            @Param("p_igv") Double igv,
            @Param("p_monto") Double monto,
            @Param("p_total") Double total,
            @Param("p_cliente_id") Integer clienteId
    );
    
/*TODO:repositorio*/
//    //Usar procedure para actualizar prestamo  SQL SERVER
//    @Procedure(name = "Sp_actualizar_prestampos")
//    @Modifying
//    void actualizarPrestamo(
//            @Param("p_id") Integer id,
//            @Param("p_estado") String estado,
//            @Param("p_fecha_actualizar") Timestamp   fechaActualizar,
//            @Param("p_fecha_devolucion") Date fechaDevolucion,
//            @Param("p_fecha_prestamo") Date fechaPrestamo,
//            @Param("p_igv") Double igv,
//            @Param("p_monto") Double monto,
//            @Param("p_total") Double total,
//            @Param("p_cliente_id") Integer clienteId
//    );
}
