package crud.actividades.crud.actividades.core.controller;

import crud.actividades.crud.actividades.core.controller.dto.ResponseDTO;
import crud.actividades.crud.actividades.core.repository.entity.Actividad;
import crud.actividades.crud.actividades.core.repository.entity.Empleado;
import crud.actividades.crud.actividades.core.service.IServiceActividad;
import crud.actividades.crud.actividades.core.service.IServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actividades")
@CrossOrigin("*")
public class ActividadController {
    @Autowired
    private IServiceActividad actividadesService;

    @Autowired
    private IServiceEmpleado serviceEmpleado;

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        try{
            List<Actividad> result = actividadesService.getAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list.empleados")
    public ResponseEntity<?> getAllEmpleados(){
        try{
            List<Empleado> result = serviceEmpleado.getAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO> create(@RequestBody Actividad actividad){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            int result = actividadesService.create(actividad);
            if(result == 0){
                responseDTO.setStatus(0);
                responseDTO.setMessage("No se pudo crear la actividad");
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
            responseDTO.setStatus(1);
            responseDTO.setMessage("Se creo la actividad con exito");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<ResponseDTO> update(@RequestBody Actividad actividad){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            int result = actividadesService.update(actividad);
            if(result == 0){
                responseDTO.setStatus(0);
                responseDTO.setMessage("No se pudo modificar la actividad");
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
            responseDTO.setStatus(1);
            responseDTO.setMessage("Se modifico la actividad con exito");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            int result = actividadesService.deleteById(id);
            if(result == 0){
                responseDTO.setStatus(0);
                responseDTO.setMessage("No se pudo eliminar la actividad");
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
            responseDTO.setStatus(1);
            responseDTO.setMessage("Se elimino la actividad con exito");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
