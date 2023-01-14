package crud.actividades.crud.actividades.core.repository.dao;

import crud.actividades.crud.actividades.core.repository.entity.Actividad;

import java.util.List;

public interface IActividadDAO {
    List<Actividad> getAll();
    List<Actividad> getAllDatail();
    int create (Actividad actividades);
    int update (Actividad actividades);
    int deleteById (int id);
}
