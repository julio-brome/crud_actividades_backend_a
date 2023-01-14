package crud.actividades.crud.actividades.core.service.impl;

import crud.actividades.crud.actividades.core.repository.dao.IEmpleadoDAO;
import crud.actividades.crud.actividades.core.repository.entity.Empleado;
import crud.actividades.crud.actividades.core.service.IServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpleadoImpl implements IServiceEmpleado {
    @Autowired
    private IEmpleadoDAO empleadoDAO;;

    @Override
    public List<Empleado> getAll() {
        try{
            List<Empleado> result = empleadoDAO.getAll();
            return result;
        }catch (Exception ex){
            return null;
        }
    }
}
