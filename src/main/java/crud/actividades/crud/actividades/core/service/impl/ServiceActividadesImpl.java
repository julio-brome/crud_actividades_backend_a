package crud.actividades.crud.actividades.core.service.impl;

import crud.actividades.crud.actividades.core.repository.dao.IActividadDAO;
import crud.actividades.crud.actividades.core.repository.entity.Actividad;
import crud.actividades.crud.actividades.core.service.IServiceActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ServiceActividadesImpl implements IServiceActividad {
    @Autowired
    private IActividadDAO actividadesDAO;;

    @Override
    public List<Actividad> getAll() {
        try{
            List<Actividad> result = actividadesDAO.getAllDatail(); //actividadesDAO.getAll();
            return result;
        }catch (Exception ex){
            return null;
        }
    }
    @Override
    public int create(Actividad actividades) {
        try{
            Actividad actividad_ = new Actividad();
            actividad_.setIdEmpleado(actividades.getIdEmpleado());
            actividad_.setDescripcion(actividades.getDescripcion());
            actividad_.setFechaRegistro(new Date());
            actividad_.setEstado(false);
            return  actividadesDAO.create(actividad_);
        }catch (Exception ex){
            return 0;
        }
    }

    @Override
    public int update(Actividad actividades) {
        try{
            Actividad actividad_ = new Actividad();
            actividad_.setIdActividades(actividades.getIdActividades());
            actividad_.setFechaEjecucion(new Date());
            actividad_.setEstado(actividades.getEstado());
            return  actividadesDAO.update(actividad_);
        }catch (Exception ex){
            return 0;
        }
    }

    @Override
    public int deleteById(int id) {
        try{
            return  actividadesDAO.deleteById(id);
        }catch (Exception ex){
            return 0;
        }
    }
}
