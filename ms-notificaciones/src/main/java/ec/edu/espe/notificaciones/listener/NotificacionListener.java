package ec.edu.espe.notificaciones.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espe.notificaciones.dto.NotificacionDto;
import ec.edu.espe.notificaciones.service.NotificacionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacionListener {

    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "queue.notificaciones")
    public void recibirNotificacion(String mensajeJson){
        try {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Notificacion recibidad: "+mensajeJson);
            System.out.println("---------------------------------------------------------------------------");
            NotificacionDto dto = objectMapper.readValue(mensajeJson, NotificacionDto.class);
            notificacionService.guardar(dto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
