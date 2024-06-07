/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gui.daotest;

import gui.dao.DAO;
import gui.dao.DAOTXT;
import gui.dao.DAOException;
import gui.dao.DAOSQL;
import gui.persona.Alumno;
import gui.persona.Carrera;
import gui.persona.PersonaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nataly
 */
public class DAOTest {

    public static void main(String[] args) throws PersonaException {
        try {
            //DAO dao = new DAOTXT("alumnos.txt");
            DAO dao = new DAOSQL("jdbc:mysql://127.0.0.1:3306/universidad", "root", "root");

            LocalDate fechaNac = LocalDate.of(2000, 6, 14);
            LocalDate fechaIngreso = LocalDate.of(2020, 6, 20);
            List<Carrera> carreras = new ArrayList<>();
            short cantMatAprob = 30;
            
            Alumno alumno = new Alumno(2, cantMatAprob, 7.25, fechaIngreso, carreras, 12345678, "Demian", "Fiorani", fechaNac);
            
            dao.create(alumno);
            
        } catch (DAOException ex) {
            Logger.getLogger(DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
