package mx.santander.liquidez.control.resolver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.santander.liquidez.control.resolver.ws.GetCommonNameFromCorpID;
import mx.santander.liquidez.control.resolver.ws.GetCommonNameFromCorpIDResponse;
import mx.santander.liquidez.control.resolver.ws.GetCorporateUserFromLocalID;
import mx.santander.liquidez.control.resolver.ws.GetCorporateUserFromLocalIDResponse;
import mx.santander.liquidez.control.resolver.ws.GetEmailFromCorpID;
import mx.santander.liquidez.control.resolver.ws.GetEmailFromCorpIDResponse;
import mx.santander.liquidez.control.resolver.ws.GetLocalUserFromCorpID;
import mx.santander.liquidez.control.resolver.ws.GetLocalUserFromCorpIDResponse;
import mx.santander.liquidez.control.resolver.ws.GetLocationFromCorpID;
import mx.santander.liquidez.control.resolver.ws.GetLocationFromCorpIDResponse;
import mx.santander.liquidez.control.resolver.ws.GetPositionFromCorpID;
import mx.santander.liquidez.control.resolver.ws.GetPositionFromCorpIDResponse;
import mx.santander.liquidez.control.resolver.ws.RequestCorporativo;
import mx.santander.liquidez.control.resolver.ws.RequestLocal;
import mx.santander.liquidez.control.resolver.ws.ResponseConsultaUsrLDAP;
import mx.santander.liquidez.control.util.SOAPConnector;
import mx.santander.liquidez.resolver.dto.model.InputFromCorpIdDTO;
import mx.santander.liquidez.resolver.dto.model.OutputFromCorpIdDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> ResolverService.java
* <br><b>Description:</b> Descripcion Clase service para consultar datos como email, usuario local, 
* usuario corporativo, centros de costos, puesto y nombre de usuario
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019, FSW Praxis Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service
*
*/
@Service
public class ResolverService implements IResolverService{
    
    /**
     * Variable endPoint de tipo String
     */
    @Value(value = "${resolver.endpoint}")
    private static String endPoint;
    
    /**
     * Variable soapConnector de tipo SOAPConnector
     */
    @Autowired
    private SOAPConnector soapConnector;

    /**
     * Metodo de implementacion para consultar el nombre del usuario corporativo
     * @param inputResolver datos de entrada para el servicio CommonNameFromCorpID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio CommonNameFromCorpID del WS Resolver
     */
    @Override
    public OutputFromCorpIdDTO resolverCommonNameFromCorpID(InputFromCorpIdDTO inputResolver) {
        GetCommonNameFromCorpID commonNameFromCorpID = new GetCommonNameFromCorpID();
        RequestCorporativo request = new RequestCorporativo();
        request.setClaveAplicativo(inputResolver.getClaveAplicativo());
        request.setIdentificadorCorporativo(inputResolver.getIdentificadorCorporativo());
        request.setUsuarioAplicativo(inputResolver.getUsuarioAplicativo());
        commonNameFromCorpID.setArg0(request);
        //se llama al servicio CommonNameFromCorpID
        GetCommonNameFromCorpIDResponse response = (GetCommonNameFromCorpIDResponse) soapConnector.callWebService(endPoint, commonNameFromCorpID);
        return setOutputFromCorpIdDTO(response.getReturn());
    }

    /**
     * Metodo de implementacion para consultar el usuario corporativo del usuario local
     * @param inputResolver datos de entrada para el servicio CorporateUserFromLocalID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio CorporateUserFromLocalID del WS Resolver
     */
    @Override
    public OutputFromCorpIdDTO resolverCorporateUserFromLocalID(InputFromCorpIdDTO inputResolver) {
        GetCorporateUserFromLocalID corporateUserFromLocalID = new GetCorporateUserFromLocalID();
        RequestLocal request = new RequestLocal();
        request.setClaveAplicativo(inputResolver.getClaveAplicativo());
        request.setIdentificadorLocal(inputResolver.getIdentificadorLocal());
        request.setUsuarioAplicativo(inputResolver.getUsuarioAplicativo());
        corporateUserFromLocalID.setArg0(request);
        //se llama al servicio CorporateUserFromLocalID
        GetCorporateUserFromLocalIDResponse response = (GetCorporateUserFromLocalIDResponse) soapConnector.callWebService(endPoint, corporateUserFromLocalID);
        return setOutputFromCorpIdDTO(response.getReturn());
    }

    /**
     * Metodo de implementacion para consultar el email del usuario corporativo
     * @param inputResolver datos de entrada para el servicio EmailFromCorpID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio EmailFromCorpID del WS Resolver
     */
    @Override
    public OutputFromCorpIdDTO resolverEmailFromCorpID(InputFromCorpIdDTO inputResolver) {
        GetEmailFromCorpID emailFromCorpID = new GetEmailFromCorpID();
        RequestCorporativo request = new RequestCorporativo();
        request.setClaveAplicativo(inputResolver.getClaveAplicativo());
        request.setIdentificadorCorporativo(inputResolver.getIdentificadorCorporativo());
        request.setUsuarioAplicativo(inputResolver.getUsuarioAplicativo());
        emailFromCorpID.setArg0(request);
        //se llama al servicio EmailFromCorpID
        GetEmailFromCorpIDResponse response = (GetEmailFromCorpIDResponse) soapConnector.callWebService(endPoint, emailFromCorpID);
        return setOutputFromCorpIdDTO(response.getReturn());
    }

    /**
     * Metodo de implementacion para consultar el usuario local en base al usuario corporativo
     * @param inputResolver datos de entrada para el servicio LocalUserFromCorpID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio LocalUserFromCorpID del WS Resolver
     */
    @Override
    public OutputFromCorpIdDTO resolverLocalUserFromCorpID(InputFromCorpIdDTO inputResolver) {
        GetLocalUserFromCorpID localUserFromCorpID = new GetLocalUserFromCorpID();
        RequestCorporativo request = new RequestCorporativo();
        request.setClaveAplicativo(inputResolver.getClaveAplicativo());
        request.setIdentificadorCorporativo(inputResolver.getIdentificadorCorporativo());
        request.setUsuarioAplicativo(inputResolver.getUsuarioAplicativo());
        localUserFromCorpID.setReqUsrLDAP(request);
        //se llama al servicio LocalUserFromCorpID
        GetLocalUserFromCorpIDResponse response = (GetLocalUserFromCorpIDResponse) soapConnector.callWebService(endPoint, localUserFromCorpID);
        return setOutputFromCorpIdDTO(response.getReturn());
    }

    @Override
    public OutputFromCorpIdDTO resolverLocationFromCorpID(InputFromCorpIdDTO inputResolver) {
        GetLocationFromCorpID locationFromCorpID = new GetLocationFromCorpID();
        RequestCorporativo request = new RequestCorporativo();
        request.setClaveAplicativo(inputResolver.getClaveAplicativo());
        request.setIdentificadorCorporativo(inputResolver.getIdentificadorCorporativo());
        request.setUsuarioAplicativo(inputResolver.getUsuarioAplicativo());
        locationFromCorpID.setArg0(request);
        //se llama al servicio LocationFromCorpID
        GetLocationFromCorpIDResponse response = (GetLocationFromCorpIDResponse) soapConnector.callWebService(endPoint, locationFromCorpID);
        return setOutputFromCorpIdDTO(response.getReturn());
    }

    @Override
    public OutputFromCorpIdDTO resolverPositionFromCorpID(InputFromCorpIdDTO inputResolver) {
        GetPositionFromCorpID positionFromCorpID = new GetPositionFromCorpID();
        RequestCorporativo request = new RequestCorporativo();
        request.setClaveAplicativo(inputResolver.getClaveAplicativo());
        request.setIdentificadorCorporativo(inputResolver.getIdentificadorCorporativo());
        request.setUsuarioAplicativo(inputResolver.getUsuarioAplicativo());
        positionFromCorpID.setArg0(request);
        //se llama al servicio PositionFromCorpID
        GetPositionFromCorpIDResponse response = (GetPositionFromCorpIDResponse) soapConnector.callWebService(endPoint, positionFromCorpID);
        return setOutputFromCorpIdDTO(response.getReturn());
    }
    
    /**
     * Clase para inicializar y setear las propiedades del objeto OutputFromCorpIdDTO
     * @param response objeto con datos para llenar las propiedades de OutputFromCorpIdDTO
     * @return OutputFromCorpIdDTO objeto inicializado y lleno
     */
    public OutputFromCorpIdDTO setOutputFromCorpIdDTO(ResponseConsultaUsrLDAP response) {
        OutputFromCorpIdDTO outPut = new OutputFromCorpIdDTO();
        outPut.setCodigoError(response.getCodigoError());
        outPut.setMensajeError(response.getMensajeError());
        outPut.setResultado(response.getResultado());
        return outPut;
    }

}
