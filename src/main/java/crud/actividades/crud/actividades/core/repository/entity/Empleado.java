package crud.actividades.crud.actividades.core.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tblempleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int idEmpleado;
    private String nombre;
    private String correo;
    private Boolean estado;

}
