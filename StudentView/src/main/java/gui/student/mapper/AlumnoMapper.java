/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.student.mapper;

import gui.persona.Alumno;
import gui.persona.PersonaException;
import gui.student.dto.AlumnoDTO;
import java.time.LocalDate;

/**
 *
 * @author fiora
 */
public final class AlumnoMapper {
    
    public static AlumnoDTO alumno2DTO(Alumno al){
        AlumnoDTO dto = new AlumnoDTO();
        dto.setDNI(al.getDni());
        dto.setNombre(al.getNombre());
        dto.setApellido(al.getApellido());
        dto.setFecNac(al.getFechaNac());
        dto.setEstado(String.valueOf(al.getEstado()));
        return dto;
    }
    
    public static Alumno dto2Alumno(AlumnoDTO dto) throws PersonaException{
        Alumno al = new Alumno();
        al.setDni(dto.getDNI());
        al.setNombre(dto.getNombre());
        al.setApellido(dto.getApellido());        
        al.setFechaNac(dto.getFecNac());
        al.setEstado(dto.getEstado().charAt(0));
        
        return al;
    }
}
