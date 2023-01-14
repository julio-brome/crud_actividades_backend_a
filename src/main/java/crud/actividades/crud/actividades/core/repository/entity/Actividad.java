package crud.actividades.crud.actividades.core.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Table(name = "tblactividades")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividades")
    private int idActividades;

    /*@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado_id" , referencedColumnName = "id_empleado")
    private Empleado empleado;*/

    @Column(name = "id_empleado")
    private int IdEmpleado;
    @Column(name = "nombre")
    private String nombreEmpleado;
    private String descripcion;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    @Column(name = "fecha_ejecucion")
    private Date fechaEjecucion;
    private Boolean estado;

}
