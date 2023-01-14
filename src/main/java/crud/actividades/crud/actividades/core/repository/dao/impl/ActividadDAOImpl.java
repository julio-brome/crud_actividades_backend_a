package crud.actividades.crud.actividades.core.repository.dao.impl;
import crud.actividades.crud.actividades.core.repository.dao.IActividadDAO;
import crud.actividades.crud.actividades.core.repository.entity.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActividadDAOImpl implements IActividadDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Actividad> getAll() {
        String query = "SELECT * FROM tblactividades";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Actividad.class));
    }

    @Override
    public List<Actividad> getAllDatail() {
        String query =
                "SELECT  " +
                "a.id_actividades , " +
                "e.nombre AS nombreEmpleado, " +
                "e.id_empleado AS idEmpleado, " +
                "a.descripcion AS descripcion, " +
                "a.fecha_registro AS fechaRegistro, " +
                "a.fecha_ejecucion AS fechaEjecucion , " +
                "a.estado  " +
                "FROM tblactividades a INNER JOIN tblempleado e ON a.empleado_id = e.id_empleado";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Actividad.class));
    }

    @Override
    public int create(Actividad actividades) {
        String query = "INSERT INTO tblactividades VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(query, new Object[]{actividades.getIdEmpleado(),actividades.getDescripcion(),actividades.getFechaRegistro(),actividades.getFechaEjecucion(),actividades.getEstado()});
    }

    @Override
    public int update(Actividad actividades) {
        String query = "UPDATE tblactividades SET fecha_ejecucion = ? , estado = ? WHERE id_actividades = ?  ";
        return jdbcTemplate.update(query, new Object[]{actividades.getFechaEjecucion(),actividades.getEstado(),actividades.getIdActividades()});
    }
    @Override
    public int deleteById(int id) {
        String query = "DELETE FROM tblactividades WHERE id_actividades = ?  ";
        return jdbcTemplate.update(query, new Object[]{id});
    }
}
