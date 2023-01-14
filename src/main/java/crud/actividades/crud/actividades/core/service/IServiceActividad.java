package crud.actividades.crud.actividades.core.service;

import crud.actividades.crud.actividades.core.repository.entity.Actividad;

import java.util.List;

public interface IServiceActividad {
    List<Actividad> getAll();
    int create (Actividad actividades);
    int update (Actividad actividades);
    int deleteById (int id);
}
