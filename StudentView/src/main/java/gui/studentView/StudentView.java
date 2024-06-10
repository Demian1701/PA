/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.studentView;

import gui.dao.DAO;
import gui.dao.DAOException;
import gui.dao.DAOFactory;
import gui.dao.DAOFactoryException;
import gui.dao.DAOSQL;
import gui.dao.DAOTXT;
import gui.persona.Alumno;
import gui.persona.PersonaException;
import gui.student.mapper.AlumnoMapper;
import gui.studentView.dialog.AlumnoDialog;
import java.util.List;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.TableModel;

/**
 *
 * @author fiora
 */


public class StudentView extends javax.swing.JFrame {

    private DAO dao;
    private DAO daoSQL;
    private Alumno alumno;
    private List<Alumno> alumnosList;
    private static final int TIPO_TXT = 0;
    private static final int TIPO_SQL = 1;

    /**
     * Creates new form StudentView
     */
    public StudentView() throws DAOException {
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setTitle("Student view");
            //Alumno alumno = new Alumno();
            dao = new DAOTXT("alumnos.txt");
            daoSQL = new DAOSQL("jdbc:mysql://127.0.0.1:3306/universidad", "root", "root");
            
            jTextFieldName.setVisible(false);
            jLabelName.setVisible(false);
            jTextFieldLastName.setVisible(false);
            jLabelLastName.setVisible(false);
            jComboBoxState.setVisible(false);
            jLabelState.setVisible(false);
            jButtonUpdate.setVisible(false);
            jLabelFN.setVisible(false);
            
            String[] initialValues = {"A", "I"};
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(initialValues);
            jComboBoxState.setModel(model);
            
            //disableButtons();
            
            AlumnoTableModel alumnoModel = new AlumnoTableModel();
            
            List<Alumno> alumnos = new ArrayList<>();
            
            Alumno alu1 = new Alumno();
            Alumno alu2 = new Alumno();
            alumnos.add(alu1);
            alumnos.add(alu2);
            
            alu1.setDni(12345678);
            alu1.setNombre("Nombre1");
            alu1.setApellido("Apellido1");
            alu1.setFechaNac(LocalDate.now());
            alu1.setEstado('A');
            
            alu2.setDni(87654321);
            alu2.setNombre("Nombre2");
            alu2.setApellido("Apellido2");
            alu2.setFechaNac(LocalDate.now().plusDays(45));
            alu2.setEstado('I');
            
            alumnoModel.setAlumnos(alumnos);
            
            jTableAlumnos.setModel(alumnoModel);
            jButtonBorrar.setEnabled(true);
        } catch (PersonaException ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextFieldDNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSelectedStudent = new javax.swing.JTextArea();
        jButtonFindAll = new javax.swing.JButton();
        jButtonModify = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelLastName = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jComboBoxState = new javax.swing.JComboBox<>();
        jLabelState = new javax.swing.JLabel();
        jButtonUpdate = new javax.swing.JButton();
        jLabelFN = new javax.swing.JLabel();
        jButtonBuscarSQL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jButtonCrear = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jComboBoxFeed = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtonPicker = new javax.swing.JButton();
        jTextFieldFullPath = new javax.swing.JTextField();
        jCheckBoxAlumnosActivos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("DNI");

        jTextAreaSelectedStudent.setColumns(20);
        jTextAreaSelectedStudent.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSelectedStudent);

        jButtonFindAll.setText("Buscar todos");
        jButtonFindAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindAllActionPerformed(evt);
            }
        });

        jButtonModify.setText("Modificar");
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });

        jLabelName.setText("Nombre:");
        jLabelName.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabelNameComponentHidden(evt);
            }
        });

        jLabelLastName.setText("Apellido");

        jComboBoxState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStateActionPerformed(evt);
            }
        });

        jLabelState.setText("Estado");

        jButtonUpdate.setText("Actualizar");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jLabelFN.setText("FN");

        jButtonBuscarSQL.setText("BuscarSQL");
        jButtonBuscarSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarSQLActionPerformed(evt);
            }
        });

        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableAlumnos);

        jButtonCrear.setText("Crear");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jComboBoxFeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TXT", "SQL" }));
        jComboBoxFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFeedActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione el repositorio");

        jButtonPicker.setText("...");
        jButtonPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPickerActionPerformed(evt);
            }
        });

        jTextFieldFullPath.setEditable(false);
        jTextFieldFullPath.setBackground(new java.awt.Color(204, 204, 204));

        jCheckBoxAlumnosActivos.setText("Solo activos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLastName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelState)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jButtonUpdate)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jButtonModify)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButtonFindAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jButtonBuscarSQL)))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxFeed, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1)
                                    .addComponent(jTextFieldFullPath, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jCheckBoxAlumnosActivos))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButtonFindAll)
                            .addComponent(jButtonModify))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarSQL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLastName)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelState)
                    .addComponent(jButtonUpdate)
                    .addComponent(jLabelFN))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonPicker))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldFullPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxAlumnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCrear)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBorrar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConsultar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String response="";
        try {
            Integer DNI = Integer.valueOf(jTextFieldDNI.getText());
            alumno = (Alumno) dao.read(DNI);
            if(alumno == null ){
                JOptionPane.showMessageDialog(this, "El alumno de DNI: " + DNI + " no fue encontrado");
                jTextAreaSelectedStudent.setText("");
                return;
            }
            response = alumno.toString();            
        } catch (NumberFormatException | DAOException ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        jTextAreaSelectedStudent.setText(response);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonFindAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindAllActionPerformed
        String response = "";
        try {
            alumnosList = (List<Alumno>) dao.findAll(true);
            for (Alumno alumno : alumnosList) {
            // Imprimir los detalles de cada alumno
                response += alumno.toString()+"\n";
            }
        } catch (DAOException ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextFieldDNI.setText("");
        jTextAreaSelectedStudent.setText(response);
    }//GEN-LAST:event_jButtonFindAllActionPerformed

    private void jLabelNameComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabelNameComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelNameComponentHidden

    private void jComboBoxStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStateActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        //alumno.setNombre(jTextFieldName.getText());
        //alumno.setApellido(jTextFieldLastName.getText());
        //alumno.setFechaNac(jTextFieldLastName.getText());
        //dao.update(alumno);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        String response="";
        try {
            Integer DNI = Integer.valueOf(jTextFieldDNI.getText());
            alumno = (Alumno) dao.read(DNI);
            if(alumno == null ){
                JOptionPane.showMessageDialog(this, "El alumno de DNI: " + DNI + " no fue encontrado");
                jTextAreaSelectedStudent.setText("");
                return;
            }
            jTextFieldName.setVisible(true);
            jLabelName.setVisible(true);
            jTextFieldLastName.setVisible(true);
            jLabelLastName.setVisible(true);
            jComboBoxState.setVisible(true);
            jLabelState.setVisible(true);
            jButtonUpdate.setVisible(true);
            
            jTextFieldName.setText(alumno.getNombre());
            jTextFieldLastName.setText(alumno.getApellido());
            jComboBoxState.setSelectedItem(alumno.getEstado());
            jLabelFN.setText(alumno.getFechaNac().toString());

            
            response = alumno.toString();         
        } catch (NumberFormatException | DAOException ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        jTextAreaSelectedStudent.setText(response);                // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModifyActionPerformed

    private void jButtonBuscarSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarSQLActionPerformed
        Integer DNI = Integer.valueOf(jTextFieldDNI.getText());
        try {
            alumno = (Alumno) daoSQL.findById(DNI);
            jTextAreaSelectedStudent.setText(alumno.getNombre());
        } catch (DAOException ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jButtonBuscarSQLActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        AlumnoDialog alumnoDIalog = new AlumnoDialog(this, true, AlumnoDialog.CREATE);
        alumnoDIalog.setVisible(true);
        System.out.println("");
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        int rowSelected = jTableAlumnos.getSelectedRow();
        if(rowSelected < 0){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un alumno", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Alumno alumno = getAlumnoSeleccionado(rowSelected);
        
        AlumnoDialog alumnoDialog = new AlumnoDialog(this, true, AlumnoDialog.UPDATE);
        alumnoDialog.setDto(AlumnoMapper.alumno2DTO(alumno));
        alumnoDialog.setVisible(true); //Cuando se cierra esto retoma
        try {
            //DAO dao = DAOFactory.getInstance().crearDAO(null);
            //dao.update(AlumnoMapper.dto2Alumno(alumnoDialog.getDto()));
            alumno = AlumnoMapper.dto2Alumno(alumnoDialog.getDto());
            System.out.println("alumno a persistir ==> "+alumno.getDni() + "- "+alumno.getNombre()+ "- "+alumno.getFechaNac());

        //} catch (DAOFactoryException | DAOException | PersonaException ex) {
        } catch (PersonaException ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al modificar (" + ex.getLocalizedMessage() + ")", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        AlumnoDialog alumnoDIalog = new AlumnoDialog(this, true, AlumnoDialog.READ);
        alumnoDIalog.setVisible(true);
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        int rowSelected = jTableAlumnos.getSelectedRow();
        if(rowSelected < 0){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un alumno", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Alumno alumno = getAlumnoSeleccionado(rowSelected);
            int resp = JOptionPane.showConfirmDialog(this, "¿Está seguro que quiere borrar al alumno con DNI: " + alumno.getDni() + " ?"  ,"Confirmación de borrado",JOptionPane.OK_CANCEL_OPTION);
            if(resp != JOptionPane.OK_OPTION){
                return;
            }
            System.out.println("Se borra");
        }
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private Alumno getAlumnoSeleccionado(int rowSelected) {
        AlumnoTableModel alumnoTableModel = (AlumnoTableModel)jTableAlumnos.getModel();
        java.util.List<Alumno> alumnos = alumnoTableModel.getAlumnos();
        Alumno alumno = alumnos.get(rowSelected);
        return alumno;
    }

    private void jButtonPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPickerActionPerformed
        JFileChooser chooser = new JFileChooser();
        File projectRoot = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(projectRoot);
        int resp = chooser.showOpenDialog(this);
        if (resp !=  JFileChooser.APPROVE_OPTION) {
            return;
        }
        jTextFieldFullPath.setText(chooser.getSelectedFile().getAbsolutePath());
        jButtonCrear.setEnabled(true);
        jButtonModificar.setEnabled(true);
    }//GEN-LAST:event_jButtonPickerActionPerformed

    private void jComboBoxFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFeedActionPerformed
        if(jComboBoxFeed.getSelectedIndex()== TIPO_TXT){
            jTextFieldFullPath.setVisible(true);
            jButtonPicker.setVisible(true);
        }
        else{
            jTextFieldFullPath.setVisible(false);
            jButtonPicker.setVisible(false);
        }
        
    }//GEN-LAST:event_jComboBoxFeedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StudentView().setVisible(true);
                } catch (DAOException ex) {
                    Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBuscarSQL;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonFindAll;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonModify;
    private javax.swing.JButton jButtonPicker;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JCheckBox jCheckBoxAlumnosActivos;
    private javax.swing.JComboBox<String> jComboBoxFeed;
    private javax.swing.JComboBox<String> jComboBoxState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFN;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelState;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JTextArea jTextAreaSelectedStudent;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldFullPath;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    private void disableButtons() {
        jButtonCrear.setEnabled(false);
        jButtonModificar.setEnabled(false);
        jButtonBorrar.setEnabled(false);
        jButtonConsultar.setEnabled(false);

    }
}
