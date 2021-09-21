/**
 * 
 */
package mx.santander.liquidez.control.toast.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.santander.liquidez.notificacion.toast.model.ToastRedis;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IToastRepository.java
 * <br><b>Description:</b>
 * Define el comportamiento para un repositorio destinado a la entidad de
 * toast. Extiende el comportamiento de un {@link CrudRepository}
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service Interface
 * 
 */
public interface IToastRepository extends CrudRepository<ToastRedis, Long> {
    
    /**
     * Obtiene todas las instancias de toasts que estan en cache por Id de rol.
     * @param idRol el Id de rol a buscar
     * @return una list de toasts 
     */
    List<ToastRedis> findByIdRolOrderByIdAsc(@Param("idRol") long idRol);

}
