/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.studentView;

import gui.persona.Alumno;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fiora
 */
public class AlumnoTableModel extends AbstractTableModel {
    private List<Alumno> alumnos;

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
private static final String[] COLUMNAS = {"DNI","NOMBRE","APELLIDO","FEC. NAC.","Est","Leg", 
    "Cant Mat Aprob", "Prom", "Fec. Ing.", "Carreras"};

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    @Override
    public int getRowCount() {
        if(alumnos == null){
            return 0;
        }
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int fil, int col) {
        Alumno alumno = alumnos.get(fil);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        switch (col) {
            case 0: return alumno.getDni();
            case 1: return alumno.getNombre();
            case 2: return alumno.getApellido();
            case 3: return alumno.getFechaNac().format(formatter);
            case 4: return alumno.getEstado();
            case 5: return alumno.getLegajo();
            case 6: return alumno.getCantMatAprob();
            case 7: return alumno.getPromedio();
            case 8: return alumno.getFechaIng();
            case 9: return alumno.getCarreras();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column];
    }
 
    
}
