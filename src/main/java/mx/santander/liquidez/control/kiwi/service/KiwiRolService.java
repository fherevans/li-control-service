package mx.santander.liquidez.control.kiwi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.notificacion.kiwi.model.Kiwi;
import mx.santander.liquidez.notificacion.kiwi.model.KiwiRol;
import mx.santander.liquidez.request.model.KiwiRolRequest;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> KiwiRolService.java <br>
 * <b>Description:</b> Crear registros Y eliminar relaciones de roles asociados
 * a un kiwi.
 *
 * @author FSW Herwin Toral
 * @company Praxis
 * @created 5 sep 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 sep 2019 FSW Praxis Nombre del autor: Herwin Toral Creacion de
 *          la clase
 *
 * @category @Service
 */
@Service
public class KiwiRolService implements IKiwiRolService {

    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(KiwiRolService.class);

    /**
     * uri del servicio GetByIdRol expuesto en el api perfilamiento
     */
    @Value("${control.endpoint.kiwirol.get.byid}")
    private String uriGetByIdRol;

    /**
     * uri del servicio GetByIdRol no asignado expuesto en el api perfilamiento
     */
    @Value("${control.endpoint.kiwirol.get.byidrol}")
    private String uriGetIdRol;

    /**
     * uri del servicio delete Kiwirol expuesto en el api perfilamiento
     */
    @Value("${control.endpoint.kiwirol.delete}")
    private String uriDeleteKiwi;
    
    /**
     * uri del servicio crear kiwirol expuesto en el api perfilamiento
     */
    @Value("${control.endpoint.kiwirol.post}")
    private String uriPostKiwi;

    /**
     * Inyeccion de RestTemplate para consumir api de kiwiRol.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * metodo para obtener la lista de kiwis asignados a un rol.
     * 
     * @param idRol id de rol.
     * @param flagDia - flagDia para sontular los kiwis si son dia o dia + 1
     * @return lista de kiwis asignados a un rol.
     */
    @Override
    public List<Kiwi> obtenerKiwiIdRol(Long idRol, int flagDia) {
        LOGGER.info("IdRol a consultar: {} flagDia : {}", idRol, flagDia);
        return this.restTemplate.getForObject(StringUtil.concat(uriGetByIdRol, idRol, "/", flagDia), List.class);
    }

    /**
     * API para obtener kiwis no asignados a un rol.
     * 
     * @param idRol id de rol.
     * @param flagDia - flagDia para sontular los kiwis si son dia o dia + 1
     * @return Kiwis no asignados a un rol.
     */
    @Override
    public List<Kiwi> obtenerKiwisNoAsignadosIdRol(Long idRol, int flagDia) {
        LOGGER.info("IdRol a consultar: {} ", (uriGetIdRol+idRol));
        return this.restTemplate.getForObject(StringUtil.concat(uriGetIdRol, idRol, "/", flagDia), List.class);
    }

    /**
     * Metodo para eliminar una relacion de kiwi rol.
     * 
     * @param kiwiRolRequest kiwi rol request.
     */
    @Override
    public void eliminarKiwiIdRol(KiwiRolRequest kiwiRolRequest) {
        LOGGER.info("Rol y Kiwi a registrar idRol {}, idKiwi {}", kiwiRolRequest.getIdRolFk(), kiwiRolRequest.getIdKiwiFk());
        this.restTemplate.delete(StringUtil.concat(uriDeleteKiwi,"/", kiwiRolRequest.getIdRolFk(),"/",kiwiRolRequest.getIdKiwiFk()));
    }

    /**
     * API para crear un nuevo kiwi rol.
     * 
     * @param kiwiRolRequest kiwi rol request.
     * @return kiwiRol creado.
     */
    @Override
    public KiwiRol asignarKiwiRol(KiwiRolRequest kiwiRolRequest) {
        LOGGER.info("Rol y Kiwi a eliminar idRol {}, idKiwi {}", kiwiRolRequest.getIdRolFk(), kiwiRolRequest.getIdKiwiFk());
        
        return this.restTemplate.postForObject(uriDeleteKiwi, kiwiRolRequest, KiwiRol.class);
    }

}
