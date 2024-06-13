/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.studentView.dialog;

import com.toedter.calendar.JCalendar;
import gui.student.dto.AlumnoDTO;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fiora
 */
public class AlumnoDialog extends javax.swing.JDialog {

    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String READ = "READ";

    private String currentAction = "";
    
    public String getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(String currentAction) {
        this.currentAction = currentAction;
    }
    
    
    
    private AlumnoDTO dto;

    public AlumnoDTO getDto() {
        return dto;
    }

    public void setDto(AlumnoDTO dto) {
        this.dto = dto;
    }

    public JTextField getjTextFieldDNI() {
        return jTextFieldDNI;
    }

    public void setjTextFieldDNI(JTextField jTextFieldDNI) {
        this.jTextFieldDNI = jTextFieldDNI;
    }

    public JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    public void setjTextFieldNombre(JTextField jTextFieldNombre) {
        this.jTextFieldNombre = jTextFieldNombre;
    }

    public JTextField getjTextFieldApellido() {
        return jTextFieldApellido;
    }

    public void setjTextFieldApellido(JTextField jTextFieldApellido) {
        this.jTextFieldApellido = jTextFieldApellido;
    }
    
    
    /**
     * Creates new form AlumnoDialog
     */
    public AlumnoDialog(java.awt.Frame parent, boolean modal, String action) {
        super(parent, modal);
        setCurrentAction(action);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Student dialog");
        
        jButtonCancel.setVisible(!action.equals(READ));
        if(action.equals(READ)){
            jTextFieldDNI.setEnabled(true);
        }
        dto = new AlumnoDTO();
        System.out.println(action);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancel = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();
        jLabelDNI = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jDateChooserFechaNac = new com.toedter.calendar.JDateChooser();
        jLabelFechaNac = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jLabelLegajo = new javax.swing.JLabel();
        jLabelCantMatAprob = new javax.swing.JLabel();
        jLabelPromedio = new javax.swing.JLabel();
        jLabelFechaIngreso = new javax.swing.JLabel();
        jLabelCarreras = new javax.swing.JLabel();
        jDateChooserFechaIng = new com.toedter.calendar.JDateChooser();
        jTextFieldLegajo = new javax.swing.JTextField();
        jTextFieldCantMatAprob = new javax.swing.JTextField();
        jTextFieldPromedio = new javax.swing.JTextField();
        jTextFieldCarreras = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jLabelDNI.setText("DNI:");

        jLabelNombre.setText("Nombre:");

        jTextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIActionPerformed(evt);
            }
        });

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabelFechaNac.setText("Fecha Nac:");

        jLabel2.setText("Apellido:");

        jTextFieldApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoActionPerformed(evt);
            }
        });

        jLabelLegajo.setText("Legajo:");

        jLabelCantMatAprob.setText("Cant. Mat. Aprob:");

        jLabelPromedio.setText("Promedio:");

        jLabelFechaIngreso.setText("Fecha Ing:");

        jLabelCarreras.setText("Carreras:");

        jTextFieldLegajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLegajoActionPerformed(evt);
            }
        });

        jTextFieldCantMatAprob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantMatAprobActionPerformed(evt);
            }
        });

        jTextFieldPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPromedioActionPerformed(evt);
            }
        });

        jTextFieldCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCarrerasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabelNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonOK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldApellido)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelLegajo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelFechaNac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooserFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextFieldLegajo)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jTextFieldCarreras))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooserFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCantMatAprob, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jTextFieldCantMatAprob))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jTextFieldPromedio)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNI)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFechaNac)
                    .addComponent(jDateChooserFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLegajo)
                    .addComponent(jTextFieldLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCantMatAprob)
                    .addComponent(jTextFieldCantMatAprob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelPromedio)
                    .addComponent(jTextFieldPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFechaIngreso)
                    .addComponent(jDateChooserFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCarreras)
                    .addComponent(jTextFieldCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(!getCurrentAction().equals(AlumnoDialog.READ) && 
                !getCurrentAction().equals(AlumnoDialog.CREATE)){
            jTextFieldDNI.setText(String.valueOf(dto.getDNI()));
            jTextFieldNombre.setText(dto.getNombre().trim());
            jTextFieldApellido.setText(dto.getApellido().trim());
            int year = dto.getFecNac().getYear();
            int month = dto.getFecNac().getMonthValue();
            int day = dto.getFecNac().getDayOfMonth();
            Calendar cal = Calendar.getInstance();
            cal.set(year, month - 1, day);
            jDateChooserFechaNac.setCalendar(cal);
        }
        if(getCurrentAction().equals(AlumnoDialog.READ)){
            jTextFieldNombre.setEnabled(false);
            jTextFieldApellido.setEnabled(false);
            jDateChooserFechaNac.setEnabled(false);
            jTextFieldLegajo.setEnabled(false);
            jTextFieldCantMatAprob.setEnabled(false);
            jTextFieldPromedio.setEnabled(false);
            jDateChooserFechaIng.setEnabled(false);
            jTextFieldCarreras.setEnabled(false);
        }
        if(getCurrentAction().equals(AlumnoDialog.UPDATE)){
            jTextFieldDNI.setEditable(false);
            setCurrentAction(currentAction);
        }

    }//GEN-LAST:event_formWindowOpened

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        if(getCurrentAction().equals(AlumnoDialog.UPDATE)){
            dto.setDNI(Integer.parseInt(jTextFieldDNI.getText()));
            dto.setNombre(jTextFieldNombre.getText());
            dto.setApellido(jTextFieldApellido.getText());
            Calendar calendar = jDateChooserFechaNac.getCalendar();
            LocalDate localDate = LocalDateTime.ofInstant(calendar.toInstant(), 
                    calendar.getTimeZone().toZoneId()).toLocalDate();
            dto.setFecNac(localDate);
        }
        if(getCurrentAction().equals(AlumnoDialog.READ)){
            if( jTextFieldDNI.getText() == null || jTextFieldDNI.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Por favor complete el campo DNI",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String dniText = jTextFieldDNI.getText();
                if (isNumeric(dniText)) {
                    int dni = Integer.valueOf(dniText);
                    dto.setDNI(dni);
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor ingrese solo numeros en el campo DNI",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        if(getCurrentAction().equals(AlumnoDialog.CREATE)){
            if( jTextFieldDNI.getText() == null || jTextFieldDNI.getText().isEmpty()  ||
                jTextFieldNombre.getText() == null || jTextFieldNombre.getText().isEmpty() ||
                jTextFieldApellido.getText() == null || jTextFieldApellido.getText().isEmpty() ||
                jDateChooserFechaNac.getCalendar() == null){
            
                JOptionPane.showMessageDialog(this, "Complete todos los campos antes de crear un alumnis",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String dniText = jTextFieldDNI.getText();
                if (isNumeric(dniText)) {
                    int dni = Integer.valueOf(dniText);
                    dto.setDNI(dni);
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor ingrese solo numeros en el campo DNI",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //dto.setDNI(Integer.parseInt(jTextFieldDNI.getText()));
                dto.setNombre(jTextFieldNombre.getText());
                dto.setApellido(jTextFieldApellido.getText());
                Calendar calendar = jDateChooserFechaNac.getCalendar();
                LocalDate localDate = LocalDateTime.ofInstant(calendar.toInstant(), 
                calendar.getTimeZone().toZoneId()).toLocalDate();
                dto.setFecNac(localDate);
                dto.setEstado("A");
                dto.setLegajo(Integer.valueOf(jTextFieldLegajo.getText()));
                dto.setCantMatAprob(Short.valueOf(jTextFieldCantMatAprob.getText()));
                dto.setPromedio(Double.valueOf(jTextFieldPromedio.getText()));
                Calendar calendarIng = jDateChooserFechaIng.getCalendar();
                LocalDate localDateIng = LocalDateTime.ofInstant(calendar.toInstant(), 
                calendar.getTimeZone().toZoneId()).toLocalDate();
                dto.setFecIng(localDateIng);
                
            }
            
        }


        
        setVisible(false);
        

    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jTextFieldApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jTextFieldLegajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLegajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLegajoActionPerformed

    private void jTextFieldCantMatAprobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantMatAprobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantMatAprobActionPerformed

    private void jTextFieldPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPromedioActionPerformed

    private void jTextFieldCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCarrerasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCarrerasActionPerformed

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
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
            java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlumnoDialog dialog = new AlumnoDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private com.toedter.calendar.JDateChooser jDateChooserFechaIng;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNac;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCantMatAprob;
    private javax.swing.JLabel jLabelCarreras;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelFechaIngreso;
    private javax.swing.JLabel jLabelFechaNac;
    private javax.swing.JLabel jLabelLegajo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPromedio;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldCantMatAprob;
    private javax.swing.JTextField jTextFieldCarreras;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldLegajo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPromedio;
    // End of variables declaration//GEN-END:variables
}
