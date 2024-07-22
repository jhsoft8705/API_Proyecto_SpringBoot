package jhsoftperu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;  
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "El nombre y apellido son obligatorios")
    @Size(min = 3, max = 100, message = "El nombre y apellido deben tener entre 3 y 100 caracteres")
    @Column(name = "nombre_apellido", nullable = false)
    private String nombre_apellido;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(min = 5, max = 200, message = "La dirección debe tener entre 5 y 200 caracteres")
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Size(min = 5, max = 100, message = "El correo electrónico debe tener entre 5 y 100 caracteres")
    @Column(name = "gmail", nullable = false)
    private String gmail;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 8, max = 20, message = "El teléfono debe tener entre 8 y 20 caracteres")
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @NotBlank(message = "El estado civil es obligatorio")
    @Size(min = 3, max = 50, message = "El estado civil debe tener entre 3 y 50 caracteres")
    @Column(name = "estado_civil", nullable = false)
    private String estado_civil;
    
    
    public Cliente() {
    }

    public Cliente(Integer id, String nombre_apellido, String direccion, String gmail, String telefono, String estado_civil) {
        this.id = id;
        this.nombre_apellido = nombre_apellido;
        this.direccion = direccion;
        this.gmail = gmail;
        this.telefono = telefono;
        this.estado_civil = estado_civil;
    }

    //@JsonIgnore 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
    
    // Constructor
}