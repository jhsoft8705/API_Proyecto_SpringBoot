package jhsoftperu.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * APlicativo para prestamos de dinero
 */
@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;
    private Double monto;
    private Double igv;
    private Double total; 
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;

    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_registro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_actualizar;
    @Column(length = 20)
    private String estado;
 
    public Prestamo() {
    }

    public Prestamo(Integer id, Cliente cliente, Double monto, Double igv, Double total, Date fechaPrestamo, Date fechaDevolucion, Date fecha_registro, Date fecha_actualizar, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.monto = monto;
        this.igv = igv;
        this.total = total;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.fecha_registro = fecha_registro;
        this.fecha_actualizar = fecha_actualizar;
        this.estado = estado;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_actualizar() {
        return fecha_actualizar;
    }

    public void setFecha_actualizar(Date fecha_actualizar) {
        this.fecha_actualizar = fecha_actualizar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
}