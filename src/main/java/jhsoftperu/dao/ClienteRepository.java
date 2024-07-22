 
package jhsoftperu.dao;

import java.util.Optional;
import jhsoftperu.model.Cliente;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Asus
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    //Listar cliente x ID
    Optional<Cliente> findById(Integer  id);
   
}
