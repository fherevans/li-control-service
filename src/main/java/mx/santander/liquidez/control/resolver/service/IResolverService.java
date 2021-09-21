package mx.santander.liquidez.control.resolver.service;

import mx.santander.liquidez.resolver.dto.model.InputFromCorpIdDTO;
import mx.santander.liquidez.resolver.dto.model.OutputFromCorpIdDTO;

/**
 * *************************************************************
 * @Cliente Santander Mexico
 * @Empresa Praxis
 * @Proyecto li-control-service
 * @Clase IResolverService.java
 * @Descripcion Inetrface service para exponer los metodos de negocio que consumiran al WS Soap del resolver
 * @Categoria IService
 * @author Jose Manuel Gonzalez Quillo
 * *************************************************************
 * @since 1.0
 * @since JDK1.8
 * @version 1.0       
 * @version 30 jul. 2019
 * @version by Jose Manuel Gonzalez Quillo
 * *************************************************************
 * @see OutputFromCorpIdDTO
 * @see InputFromCorpIdDTO
 */
public interface IResolverService {
    
    /**
     * Metodo para consultar el nombre del usuario corporativo
     * @param inputResolver datos de entrada para el servicio CommonNameFromCorpID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio CommonNameFromCorpID del WS Resolver
     */
    OutputFromCorpIdDTO resolverCommonNameFromCorpID(InputFromCorpIdDTO inputResolver);
    
    /**
     * Metodo para consultar el usuario corporativo del usuario local
     * @param inputResolver datos de entrada para el servicio CorporateUserFromLocalID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio CorporateUserFromLocalID del WS Resolver
     */
    OutputFromCorpIdDTO resolverCorporateUserFromLocalID(InputFromCorpIdDTO inputResolver);
    
    /**
     * Metodo para consultar el email del usuario corporativo
     * @param inputResolver datos de entrada para el servicio EmailFromCorpID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio EmailFromCorpID del WS Resolver
     */
    OutputFromCorpIdDTO resolverEmailFromCorpID(InputFromCorpIdDTO inputResolver);
    
    /**
     * Metodo para consultar el usuario local en base al usuario corporativo
     * @param inputResolver datos de entrada para el servicio LocalUserFromCorpID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio LocalUserFromCorpID del WS Resolver
     */
    OutputFromCorpIdDTO resolverLocalUserFromCorpID(InputFromCorpIdDTO inputResolver);
    
    /**
     * Metodo para consultar el centro de costos del usuario corporativo
     * @param inputResolver datos de entrada para el servicio LocationFromCorpID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio LocationFromCorpID del WS Resolver
     */
    OutputFromCorpIdDTO resolverLocationFromCorpID(InputFromCorpIdDTO inputResolver);
    
    /**
     * Metodo para consultar el codigo de puesto del usuario corporativo
     * @param inputResolver datos de entrada para el servicio PositionFromCorpID del WS Resolver
     * @return {@link OutputFromCorpIdDTO} objeto con informacion de respuesta del servicio PositionFromCorpID del WS Resolver
     */
    OutputFromCorpIdDTO resolverPositionFromCorpID(InputFromCorpIdDTO inputResolver);

}
