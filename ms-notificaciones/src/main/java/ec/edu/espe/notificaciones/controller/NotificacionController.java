package ec.edu.espe.notificaciones.controller;

import ec.edu.espe.notificaciones.dto.NotificacionDto;
import ec.edu.espe.notificaciones.entity.Notificacion;
import ec.edu.espe.notificaciones.service.NotificacionService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<Notificacion> listar(){
        return notificacionService.findAll();
    }
}
