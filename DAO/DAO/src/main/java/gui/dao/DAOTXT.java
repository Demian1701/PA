/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.dao;
import gui.persona.Alumno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOTXT extends DAO <Alumno, Integer>{
    
    private RandomAccessFile raf;
    
    public DAOTXT(String fullpath) throws DAOException {
        try {
            raf = new RandomAccessFile(fullpath, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error E/S ==> Archivo no encontrado");
        }
        System.out.println("Se conectó OK al TXT ==> "+fullpath);
    }

    @Override
    public void create(Alumno alumno) throws DAOException{
        
        try {
            if (exist(alumno.getDni())) {
                throw new DAOException("Alumno duplicado ==> "+ alumno.getDni());
            }
            raf.seek(raf.length()); // Se posiciona al final del archivo
            raf.writeBytes(alumno.toString()+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(DAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error E/S ==> No se pudo crear el alumno"+ "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public Alumno read(Integer id) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Alumno entity) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno findById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean solaActivos) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean exist(Integer dni) throws DAOException {
        try {
            raf.seek(0);
            String lineaAlu;
            Integer dniAlu;
            while ((lineaAlu = raf.readLine())!=null) {
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
    
}
