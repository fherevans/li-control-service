package mx.santander.liquidez.control.toast.repository;

import org.springframework.data.repository.CrudRepository;

import mx.santander.liquidez.notificacion.toast.model.MensajeFrontDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-ctrl-monitor-service
* <br><b>Class:</b> IToastRepository.java
* <br><b>Description:</b> Clase repository para acceder a los datos de un toast
* 
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category InterfaceRepository
*
*/
public interface IMensajeFrontRepository extends CrudRepository<MensajeFrontDTO, Integer>{
}
