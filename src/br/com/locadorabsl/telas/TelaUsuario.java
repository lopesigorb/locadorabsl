/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.locadorabsl.telas;

import br.com.locadorabsl.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class TelaUsuario extends javax.swing.JInternalFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void adicionar() {
        String sql = "insert into usuario(nome, login, senha, telefone, perfil) values(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TxtUsuNom.getText());
            pst.setString(2, TxtUsuLog.getText());
            pst.setString(3, TxtUsuSen.getText());
            pst.setString(4, TxtUsuTel.getText());
            pst.setString(5, TxtUsuPer.getText());
            // validação dos campos obrigatórios
            if ((((TxtUsuNom.getText().isEmpty()) || (TxtUsuLog.getText().isEmpty()))
                    || (TxtUsuSen.getText().isEmpty())) || (TxtUsuTel.getText().isEmpty()) || (TxtUsuPer.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                // a linha abaixo atualiza com os dados do formulario
                int adicionado = pst.executeUpdate();
                if (adicionado > 0);
                {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                    TxtUsuId.setText(null);
                    TxtUsuNom.setText(null);
                    TxtUsuLog.setText(null);
                    TxtUsuSen.setText(null);
                    TxtUsuTel.setText(null);
                    TxtUsuPer.setText(null);                  
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void pesquisar() {
        String sql = "select * from usuario where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TxtUsuId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                TxtUsuNom.setText(rs.getString(2));
                TxtUsuLog.setText(rs.getString(3));
                TxtUsuSen.setText(rs.getString(4));
                TxtUsuTel.setText(rs.getString(5));
                TxtUsuPer.setText(rs.getString(6));
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                TxtUsuId.setText(null);
                TxtUsuNom.setText(null);
                TxtUsuLog.setText(null);
                TxtUsuSen.setText(null);
                TxtUsuTel.setText(null);
                TxtUsuPer.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void editar() {
        String sql = "update usuario set nome=?, login=?, senha=?, telefone=?, perfil=? where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TxtUsuNom.getText());
            pst.setString(2, TxtUsuLog.getText());
            pst.setString(3, TxtUsuSen.getText());
            pst.setString(4, TxtUsuTel.getText());
            pst.setString(5, TxtUsuPer.getText());
            pst.setString(6, TxtUsuId.getText());
           

            if ((((TxtUsuNom.getText().isEmpty()))
                    || (TxtUsuLog.getText().isEmpty())) || (TxtUsuSen.getText().isEmpty()) || (TxtUsuTel.getText().isEmpty()) || (TxtUsuPer.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Usuário alterados com sucesso");
                    TxtUsuId.setText(null);
                    TxtUsuNom.setText(null);
                    TxtUsuLog.setText(null);
                    TxtUsuSen.setText(null);
                    TxtUsuTel.setText(null);
                    TxtUsuPer.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from usuario where iduser=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtUsuId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");

                    TxtUsuId.setText(null);
                    TxtUsuNom.setText(null);
                    TxtUsuLog.setText(null);
                    TxtUsuSen.setText(null);
                    TxtUsuTel.setText(null);
                    TxtUsuPer.setText(null);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtUsuId = new javax.swing.JTextField();
        TxtUsuNom = new javax.swing.JTextField();
        TxtUsuLog = new javax.swing.JTextField();
        TxtUsuSen = new javax.swing.JTextField();
        TxtUsuTel = new javax.swing.JTextField();
        TxtUsuPer = new javax.swing.JTextField();
        BtnUsuIns = new javax.swing.JButton();
        BtnUsuPes = new javax.swing.JButton();
        BtnUsuEdi = new javax.swing.JButton();
        BtnUsuExc = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuário");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("User:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Login:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Senha:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Telefone:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Perfil:");

        BtnUsuIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/adicionarnovo.png"))); // NOI18N
        BtnUsuIns.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnUsuIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuInsActionPerformed(evt);
            }
        });

        BtnUsuPes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/pesquisar.png"))); // NOI18N
        BtnUsuPes.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnUsuPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuPesActionPerformed(evt);
            }
        });

        BtnUsuEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/editar.png"))); // NOI18N
        BtnUsuEdi.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnUsuEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuEdiActionPerformed(evt);
            }
        });

        BtnUsuExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/excluir.png"))); // NOI18N
        BtnUsuExc.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnUsuExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuExcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(BtnUsuIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(BtnUsuPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(BtnUsuEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(BtnUsuExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtUsuNom, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtUsuSen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtUsuLog, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(205, 205, 205))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtUsuTel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(TxtUsuPer))
                        .addGap(235, 235, 235))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtUsuTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TxtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(TxtUsuNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(TxtUsuLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtUsuSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtUsuPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnUsuIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUsuPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUsuEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUsuExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        setBounds(0, 0, 671, 557);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnUsuInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuInsActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_BtnUsuInsActionPerformed

    private void BtnUsuPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuPesActionPerformed
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_BtnUsuPesActionPerformed

    private void BtnUsuEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuEdiActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_BtnUsuEdiActionPerformed

    private void BtnUsuExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuExcActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_BtnUsuExcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnUsuEdi;
    private javax.swing.JButton BtnUsuExc;
    private javax.swing.JButton BtnUsuIns;
    private javax.swing.JButton BtnUsuPes;
    private javax.swing.JTextField TxtUsuId;
    private javax.swing.JTextField TxtUsuLog;
    private javax.swing.JTextField TxtUsuNom;
    private javax.swing.JTextField TxtUsuPer;
    private javax.swing.JTextField TxtUsuSen;
    private javax.swing.JTextField TxtUsuTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
