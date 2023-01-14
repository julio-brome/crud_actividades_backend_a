package crud.actividades.crud.actividades.core.repository.dao.impl;

import crud.actividades.crud.actividades.core.repository.dao.IEmpleadoDAO;
import crud.actividades.crud.actividades.core.repository.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmpleadoDAOImpl implements IEmpleadoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Empleado> getAll() {
        String query = "SELECT * FROM tblempleado";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Empleado.class));
    }
}
