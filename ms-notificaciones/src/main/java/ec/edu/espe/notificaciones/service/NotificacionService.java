package ec.edu.espe.notificaciones.service;

import ec.edu.espe.notificaciones.dto.NotificacionDto;
import ec.edu.espe.notificaciones.entity.Notificacion;
import ec.edu.espe.notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public void guardar(NotificacionDto dto) {
        Notificacion notificacion = new Notificacion();
        notificacion.setTipo(dto.getTipo());
        notificacion.setMensaje(dto.getMensaje());
        notificacion.setFecha(LocalDateTime.now());
        notificacionRepository.save(notificacion);
    }

    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }
}
