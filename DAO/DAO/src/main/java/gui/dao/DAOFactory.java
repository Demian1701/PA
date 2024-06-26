/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.dao;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFactory {
    
    private static DAOFactory instance;
    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String TIPO_DAO_TXT = "TIPO_DAO_TXT";
    public static final String TIPO_DAO_SQL = "TIPO_DAO_SQL";
    public static final String FULL_PATH = "FULL_PATH";
    public static final String URL_DB = "URL_DB";
    public static final String USER_DB = "USER_DB";
    public static final String PWD_DB = "PWD_DB";
    
    private DAOFactory() {
    }
    
    public static DAOFactory getInstance() {
        
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
    
    public static DAO crearDAO(Map<String, String> configMap) throws DAOFactoryException {
        
        try {
            String tipoDAO = configMap.get(TIPO_DAO);
            switch (tipoDAO) {
                case TIPO_DAO_TXT:
                    String fullpath = configMap.get(FULL_PATH);
                    return new DAOTXT(fullpath);
                case TIPO_DAO_SQL:
                    String url = configMap.get(URL_DB);
                    String user = configMap.get(USER_DB);
                    String password = configMap.get(PWD_DB);
                    return new DAOSQL(url, user, password);
                default:
                    throw new DAOFactoryException("No implementado");
            }
        } catch (DAOException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOFactoryException(
                    "Error al crear el DAO ("+ex.getLocalizedMessage()+")");
        }
    }
}
