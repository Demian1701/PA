/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.dao;
import gui.persona.Alumno;
import gui.persona.PersonaException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.AlumnoUtils;

public class DAOTXT extends DAO <Alumno, Integer>{
    
    private RandomAccessFile raf;
    
    public DAOTXT(String fullpath) throws DAOException {
        
        try {
            raf = new RandomAccessFile(fullpath, "rws");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error E/S ==> Archivo no encontrado");
        }
        
        System.out.println("Se conectó OK al TXT ==> " + fullpath);
    }

    @Override
    public void create(Alumno alumno) throws DAOException{
        
        try {
            if (exist(alumno.getDni())) {
                throw new DAOException("Alumno duplicado ==> " + alumno.getDni());
            }
            alumno.setEstado('A');
            raf.seek(raf.length()); // Se posiciona al final del archivo
            raf.writeBytes(alumno.toString() + System.lineSeparator());
            
        } catch (IOException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error E/S ==> No se pudo crear el alumno" + "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException{
        
        try {
            raf.seek(0);
            String lineaAlu;
            Integer dniAlu;
            System.out.println(raf.readLine());
            while ((lineaAlu = raf.readLine())!= null) {
                dniAlu = Integer.valueOf(lineaAlu.substring(0, 8));
                if (dniAlu.equals(dni)) {
                    System.out.println(AlumnoUtils.str2Alu(lineaAlu));
                    return AlumnoUtils.str2Alu(lineaAlu);
                }
            }
            
            return null;
            
        } catch (IOException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error E/S ==> No se pudo leer el archivo" + "("+ex.getLocalizedMessage()+")");
            
        } catch (PersonaException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al construir el alumno" + "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public void update(Alumno alumno) throws DAOException {
        
        try {
            long filePointer = 0;
            raf.seek(filePointer);
            String lineaAlu;
            Integer dniAlu;
            while ((lineaAlu = raf.readLine())!= null) {
                dniAlu = Integer.valueOf(lineaAlu.substring(0, 8));
                if (dniAlu.equals(alumno.getDni())) {
                    raf.seek(filePointer);
                    raf.writeBytes(alumno.toString());
                    return;
                }
                filePointer = raf.getFilePointer();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        }  
    }

    @Override
    public void delete(Integer dni) throws DAOException {
        
        Alumno alumno = read(dni);
        alumno.setEstado('I');
        update(alumno);
    }

    @Override
    public Alumno findById(Integer dni) throws DAOException {
        return read(dni);
    }

    @Override
    public List<Alumno> findAll(boolean soloActivos) throws DAOException {
        
        List<Alumno> alumnos = new ArrayList<>();
        
        try {
            raf.seek(0);
            String lineaAlu;
            while ((lineaAlu = raf.readLine())!= null) {
                if (soloActivos == true && lineaAlu.trim().endsWith("A")) {
                    alumnos.add(AlumnoUtils.str2Alu(lineaAlu));
                    System.out.println(AlumnoUtils.str2Alu(lineaAlu));
                }
                if (soloActivos == false && lineaAlu.trim().endsWith("I")) {
                    alumnos.add(AlumnoUtils.str2Alu(lineaAlu));
                    System.out.println(AlumnoUtils.str2Alu(lineaAlu));
                }
            };
            
        } catch (IOException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error E/S ==> No se pudo leer el archivo" + "("+ex.getLocalizedMessage()+")");
            
        } catch (PersonaException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al construir el alumno" + "("+ex.getLocalizedMessage()+")");
        }
        
        return alumnos;
    }

    @Override
    public boolean exist(Integer dni) throws DAOException {
        
        try {
            raf.seek(0);
            String lineaAlu;
            Integer dniAlu;
            while ((lineaAlu = raf.readLine())!= null) {
                dniAlu = Integer.valueOf(lineaAlu.substring(0, 8));
                if (dniAlu.equals(dni)) {
                    return true;
                }
            }
            
            return false;
            
        } catch (IOException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public void closeConnection() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAllByEstado(boolean solaActivos) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
