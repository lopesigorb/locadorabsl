/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.locadorabsl.telas;

import br.com.locadorabsl.dal.ModuloConexao;
import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author Aluno
 */
public class TelaPrincipal extends javax.swing.JFrame {
    Connection conexao = null;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        conexao = ModuloConexao.conector();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        LblData = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenCad = new javax.swing.JMenu();
        MenCadCli = new javax.swing.JMenuItem();
        MenCadVei = new javax.swing.JMenuItem();
        MenCadLoc = new javax.swing.JMenuItem();
        MenCadFun = new javax.swing.JMenuItem();
        MenCadUsu = new javax.swing.JMenuItem();
        MenAju = new javax.swing.JMenu();
        MenAjuSob = new javax.swing.JMenuItem();
        MenOpc = new javax.swing.JMenu();
        MenOpcSai = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        LblData.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        LblData.setText("Data");

        LblUsuario.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        LblUsuario.setForeground(new java.awt.Color(102, 204, 255));
        LblUsuario.setText("Usuário");

        Desktop.setPreferredSize(new java.awt.Dimension(671, 557));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        MenCad.setText("Cadastro");

        MenCadCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MenCadCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/cliente.png"))); // NOI18N
        MenCadCli.setText("Cliente");
        MenCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadCliActionPerformed(evt);
            }
        });
        MenCad.add(MenCadCli);

        MenCadVei.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MenCadVei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/8541772_car_transport_icon.png"))); // NOI18N
        MenCadVei.setText("Veículo");
        MenCadVei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadVeiActionPerformed(evt);
            }
        });
        MenCad.add(MenCadVei);

        MenCadLoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MenCadLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/locacao.png"))); // NOI18N
        MenCadLoc.setText("Locação");
        MenCadLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadLocActionPerformed(evt);
            }
        });
        MenCad.add(MenCadLoc);

        MenCadFun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MenCadFun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/func.png"))); // NOI18N
        MenCadFun.setText("Funcionário");
        MenCadFun.setEnabled(false);
        MenCadFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadFunActionPerformed(evt);
            }
        });
        MenCad.add(MenCadFun);

        MenCadUsu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MenCadUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/usuario.png"))); // NOI18N
        MenCadUsu.setText("Usuário");
        MenCadUsu.setEnabled(false);
        MenCadUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadUsuActionPerformed(evt);
            }
        });
        MenCad.add(MenCadUsu);

        jMenuBar1.add(MenCad);

        MenAju.setText("Ajuda");

        MenAjuSob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MenAjuSob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/sobre1.png"))); // NOI18N
        MenAjuSob.setText("Sobre");
        MenAjuSob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenAjuSobActionPerformed(evt);
            }
        });
        MenAju.add(MenAjuSob);

        jMenuBar1.add(MenAju);

        MenOpc.setText("Opções");

        MenOpcSai.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MenOpcSai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/sair.png"))); // NOI18N
        MenOpcSai.setText("Sair");
        MenOpcSai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenOpcSaiActionPerformed(evt);
            }
        });
        MenOpc.add(MenOpcSai);

        jMenuBar1.add(MenOpc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblData)
                    .addComponent(LblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(367, Short.MAX_VALUE)
                .addComponent(LblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblData)
                .addGap(109, 109, 109))
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(916, 596));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadCliActionPerformed
        // TODO add your handling code here:
        TelaCliente cliente = new TelaCliente ();
        cliente.setVisible(true);
        Desktop.add(cliente);
    }//GEN-LAST:event_MenCadCliActionPerformed

    private void MenCadVeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadVeiActionPerformed
        // TODO add your handling code here:
        TelaVeiculo veiculo = new TelaVeiculo ();
        veiculo.setVisible(true);
        Desktop.add(veiculo);
        
    }//GEN-LAST:event_MenCadVeiActionPerformed

    private void MenCadLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenCadLocActionPerformed

    private void MenCadFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenCadFunActionPerformed

    private void MenCadUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenCadUsuActionPerformed

    private void MenAjuSobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenAjuSobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenAjuSobActionPerformed

    private void MenOpcSaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenOpcSaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenOpcSaiActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        LblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JLabel LblData;
    public static javax.swing.JLabel LblUsuario;
    private javax.swing.JMenu MenAju;
    private javax.swing.JMenuItem MenAjuSob;
    private javax.swing.JMenu MenCad;
    private javax.swing.JMenuItem MenCadCli;
    public static javax.swing.JMenuItem MenCadFun;
    private javax.swing.JMenuItem MenCadLoc;
    public static javax.swing.JMenuItem MenCadUsu;
    private javax.swing.JMenuItem MenCadVei;
    private javax.swing.JMenu MenOpc;
    private javax.swing.JMenuItem MenOpcSai;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}