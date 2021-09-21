package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.InstitucionesPaginadaRequest;
import mx.santander.liquidez.control.parametria.model.RequestInstitucionIndeval;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-parametria-service <br>
 * <b>Class:</b> IInstitucionesIndevalService.java <br>
 * <b>Description:</b> Interface para acceder a los métodos de negocio de instituciones
 *
 * @author Victor Basurto Alonso
 * @company Práxis
 * @created 04 Nov. 2020
 * @since JDK: 1.8
 *
 * @category Interface Service
 *
 */
public interface IInstitucionesIndevalService {

    /**
     * Método para consultar todas las instituciones de liquidéz
     * 
     * @param audit variable de tipo String
     * @return Object con la lista de instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    
    Object getAllInstituciones(String audit) throws ServiceException;

    /**
     * Método para consultar todas las instituciones de liquidéz por filtro
     * 
     * @param audit variable de tipo String
     * @return Object con la lista de instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    Object getInstitucionesFilters(String audit) throws ServiceException;

    /**
     * Método para consultar todas las instituciones de liquidéz por filtro
     * 
     * @param audit variable de tipo String
     * @param requestInstitucionIndeval variable de tipo RequestInstitucionIndeval
     * @return Object con la lista de instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    Object createsInstitutions(String audit, RequestInstitucionIndeval requestInstitucionIndeval) throws ServiceException;

    /**
     * Método para consultar todas las instituciones de liquidéz por filtro
     * 
     * @param audit variable de tipo String
     * @param requestInstitucionIndeval variable de tipo RequestInstitucionIndeval
     * @return Object con la lista de instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    Object updatesInstitutions(String audit, RequestInstitucionIndeval requestInstitucionIndeval) throws ServiceException;

    /**
     * Método para consultar todas las instituciones de liquidéz por filtro
     * 
     * @param audit variable de tipo String
     * @param requestInstitucionIndeval variable de tipo RequestInstitucionIndeval
     * @return Object con la lista de instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    Object removesInstitutions(String audit, RequestInstitucionIndeval requestInstitucionIndeval) throws ServiceException;

    /**
     * Método para consultar todas las instituciones de liquidéz por filtro
     * 
     * @param audit variable de tipo String
     * @param institucionesPaginadaRequest variable de tipo InstitucionesPaginadaRequest
     * @return Object con la lista de instituciones paginadas
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    Object getInstitutionsPageable(String audit, InstitucionesPaginadaRequest institucionesPaginadaRequest) throws ServiceException;

}
