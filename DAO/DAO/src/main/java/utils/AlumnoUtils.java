/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import gui.persona.Alumno;
import gui.persona.Persona;
import gui.persona.PersonaException;
import java.sql.Date;
import java.time.LocalDate;

public class AlumnoUtils {
    
    public static Alumno str2Alu(String aluStr) throws PersonaException {
        int index = 0;

        Alumno alu = new Alumno();
        String[] lineasStr = aluStr.split(String.valueOf(Persona.DELIM));
        alu.setDni(Integer.valueOf(lineasStr[index++]));
        alu.setNombre(lineasStr[index++]);
        alu.setApellido(lineasStr[index++]);

        String fechaNac = lineasStr[index++]; // "05/11/1999"
        String[] fechaNacArr = fechaNac.split("/");
        int year = Integer.valueOf(fechaNacArr[2]);
        int month = Integer.valueOf(fechaNacArr[1]);
        int dayOfMonth = Integer.valueOf(fechaNacArr[0]);
        alu.setFechaNac(LocalDate.of(year, month, dayOfMonth));
        
        int legajo = Integer.valueOf(lineasStr[index++]);
        alu.setLegajo(legajo);
        short cantMatAprob = Short.valueOf(lineasStr[index++]);
        alu.setCantMatAprob(cantMatAprob);
        String formatedProm = lineasStr[index++].trim().replace(",",".");
        double promedio = Double.valueOf(formatedProm);
        alu.setPromedio(promedio);
        String fechaIng = lineasStr[index++]; // "05/11/1999"
        String[] fechaIngArr = fechaIng.split("/");
        int yearIng = Integer.valueOf(fechaIngArr[2]);
        int monthIng = Integer.valueOf(fechaIngArr[1]);
        int dayOfMonthIng = Integer.valueOf(fechaIngArr[0]);
        alu.setFechaIng(LocalDate.of(yearIng, monthIng, dayOfMonthIng));
        
        char estado = lineasStr[index++].charAt(0);
        alu.setEstado(estado);
       
        return alu;
    }
    
    public static Date localDate2SqlDate(LocalDate localDate) {
        
        return Date.valueOf(localDate);
    }

    public static LocalDate sqlDate2LocalDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }
}
