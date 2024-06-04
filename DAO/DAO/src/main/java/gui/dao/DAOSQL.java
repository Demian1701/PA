/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.dao;

import gui.persona.Alumno;
import gui.persona.Carrera;
import gui.persona.PersonaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.AlumnoUtils;

public class DAOSQL extends DAO <Alumno, Integer>{
    
    private final Connection connection;

    /*
        * PreparedStatement para ejecutar una consulta sql como insert o read
    */
    
    private final PreparedStatement insertPS;
    private final PreparedStatement readPS;
    private final PreparedStatement updatePS;
    private final PreparedStatement deletePS;
    private final PreparedStatement findAllPS;
    private final PreparedStatement findAllActivosPS;
    private final PreparedStatement findAllInactivosPS;
    
    public DAOSQL(String url, String user, String password) throws DAOException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado OK a la BBDD");

            String insertSql = "INSERT INTO alumnos\n" +
                    "(`dni`, `nombre`, `apellido`, `fec_nac`, `estado`, `legajo`, `cantMatAprob`, `promedio`, `fechaIng`, `carreras`)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            insertPS = connection.prepareStatement(insertSql);

            String readSql = "SELECT * FROM alumnos WHERE dni = ?;";
            readPS = connection.prepareStatement(readSql);
            
            String updateSql = "UPDATE alumnos SET\n" +
                "nombre = ?,\n" +
                "apellido = ?,\n" +
                "fec_nac = ?,\n" +
                "estado = ?,\n" +
                "legajo = ?,\n" +
                "cantMatAprob = ?,\n" +
                "promedio = ?,\n" +
                "fechaIng = ?,\n" +
                "carreras = ?\n" +
                "WHERE dni = ?;";
            updatePS = connection.prepareStatement(updateSql);
            
            String deleteSql = "UPDATE alumnos SET estado = ? WHERE dni = ?;";
            deletePS = connection.prepareStatement(deleteSql);
            
            String findAllSql = "SELECT * FROM alumnos;";
            findAllPS = connection.prepareStatement(findAllSql);
            
            String findAllActivosSql = "SELECT * FROM alumnos WHERE estado = 'A';";
            findAllActivosPS = connection.prepareStatement(findAllActivosSql);
            
            String findAllInactivosSql = "SELECT * FROM alumnos WHERE estado = 'I';";
            findAllInactivosPS = connection.prepareStatement(findAllInactivosSql);

        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error SQL ==> No se pudo conectar a la BBDD");
        }
    }

    @Override
    public void create(Alumno alumno) throws DAOException {
        try {
            int index = 1;
            insertPS.setInt(index++, alumno.getDni());
            insertPS.setString(index++, alumno.getNombre());
            insertPS.setString(index++, alumno.getApellido());
            insertPS.setDate(index++, AlumnoUtils.localDate2SqlDate(alumno.getFechaNac()));
            insertPS.setString(index++, String.valueOf(alumno.getEstado()));
            insertPS.setInt(index++, alumno.getLegajo());
            insertPS.setInt(index++, alumno.getCantMatAprob());
            insertPS.setDouble(index++, alumno.getPromedio());
            insertPS.setDate(index++, AlumnoUtils.localDate2SqlDate(alumno.getFechaIng()));
            insertPS.setString(index++, String.valueOf(alumno.getCarreras()));
            
            insertPS.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error SQL ==> No se pudo insertar el alumno");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        
        try {
            readPS.setInt(1, dni);
            ResultSet rs = readPS.executeQuery();
            if (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNac(AlumnoUtils.sqlDate2LocalDate(rs.getDate("fec_nac")));
                
                System.out.println("Alumno: " + alumno);
                
                return alumno;
            }
            else {
                System.out.println("No existe alumno con el dni " + dni);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error SQL ==> No se pudo leer el alumno (" + ex.getLocalizedMessage()+")");
            
        } catch (PersonaException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear el alumno (" + ex.getLocalizedMessage()+")");
        }
        return null;
    }

    @Override
    public void update(Alumno alumno) throws DAOException {
        
        try {
            int index = 1;
            
            updatePS.setString(index++, alumno.getNombre());
            updatePS.setString(index++, alumno.getApellido());
            updatePS.setDate(index++, AlumnoUtils.localDate2SqlDate(alumno.getFechaNac()));
            updatePS.setString(index++, String.valueOf(alumno.getEstado()));
            updatePS.setInt(index++, alumno.getLegajo());
            updatePS.setInt(index++, alumno.getCantMatAprob());
            updatePS.setDouble(index++, alumno.getPromedio());
            updatePS.setDate(index++, AlumnoUtils.localDate2SqlDate(alumno.getFechaIng()));
            updatePS.setString(index++, String.valueOf(alumno.getCarreras()));
            updatePS.setInt(index++, alumno.getDni()); // El dni para la condición WHERE
            
            updatePS.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error SQL ==> No se pudo actualizar el alumno (" + ex.getLocalizedMessage()+")");
        } 
    }

    @Override
    public void delete(Integer dni) throws DAOException {
        
        try {
            int index = 1;
            readPS.setInt(1, dni);
            ResultSet rs = readPS.executeQuery();
            
            if (rs.next()) {
                deletePS.setString(index++, "I");
                deletePS.setInt(index++, dni);

                deletePS.execute();
            }
            else {
                System.out.println("No existe alumno con el dni " + dni);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error SQL ==> No se pudo eliminar el alumno (" + ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public Alumno findById(Integer dni) throws DAOException {
        return read(dni);
    }

    @Override
    public List<Alumno> findAll(boolean solaActivos) throws DAOException {
        List<Alumno> alumnos = new ArrayList<>();
        
        try {
            ResultSet rs = findAllPS.executeQuery();
            
            while (rs.next()) {
                Alumno alumno = new Alumno();
             
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNac(rs.getDate("fec_nac").toLocalDate());
                alumno.setEstado(rs.getString("estado").charAt(0));
                alumno.setLegajo(rs.getInt("legajo"));
                alumno.setCantMatAprob(rs.getShort("cantMatAprob"));
                alumno.setPromedio(rs.getDouble("promedio"));
            
                alumnos.add(alumno);
                
                System.out.println(alumno);
            }
            
            return alumnos;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error SQL ==> No se pudieron obtener los alumnos");
        }  catch (PersonaException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear el alumno (" + ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public boolean exist(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void closeConnection() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Alumno> findAllByEstado(boolean estado) throws DAOException { 
        List<Alumno> alumnos = new ArrayList<>();
        
        try {
            ResultSet rs;
            if (estado == true) {
                rs = findAllActivosPS.executeQuery();
                while (rs.next()) {
                    Alumno alumno = new Alumno();

                    alumno.setDni(rs.getInt("dni"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setFechaNac(rs.getDate("fec_nac").toLocalDate());
                    alumno.setEstado(rs.getString("estado").charAt(0));
                    alumno.setLegajo(rs.getInt("legajo"));
                    alumno.setCantMatAprob(rs.getShort("cantMatAprob"));
                    alumno.setPromedio(rs.getDouble("promedio"));

                    alumnos.add(alumno);

                    System.out.println(alumno);
                }
            }
            else {
                rs = findAllInactivosPS.executeQuery();
                while (rs.next()) {
                    Alumno alumno = new Alumno();

                    alumno.setDni(rs.getInt("dni"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setFechaNac(rs.getDate("fec_nac").toLocalDate());
                    alumno.setEstado(rs.getString("estado").charAt(0));
                    alumno.setLegajo(rs.getInt("legajo"));
                    alumno.setCantMatAprob(rs.getShort("cantMatAprob"));
                    alumno.setPromedio(rs.getDouble("promedio"));

                    alumnos.add(alumno);

                    System.out.println(alumno);
                }
            }

            return alumnos;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error SQL ==> No se pudieron obtener los alumnos");
            
        }  catch (PersonaException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear el alumno (" + ex.getLocalizedMessage()+")");
        }
    }
    
}
