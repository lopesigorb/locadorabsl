/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.locadorabsl.telas;

import java.sql.*;
import br.com.locadorabsl.dal.ModuloConexao;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Aluno
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
   
    
    private void pesquisar() {
    String sql = "select * from cliente where cpf=?";
    try{
        pst=conexao.prepareStatement(sql);
        pst.setString(1,TxtCliCpf.getText());
        rs=pst.executeQuery();
        if (rs.next()) {
        TxtCliNom.setText(rs.getString(2));
        TxtCliEnd.setText(rs.getString(3));
        TxtCliTel.setText(rs.getString(4));
        TxtCliCnh.setText(rs.getString(5));
        } else{
            JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
            TxtCliCpf.setText(null);
            TxtCliNom.setText(null);
            TxtCliEnd.setText(null);
            TxtCliTel.setText(null);
            TxtCliCnh.setText(null);      
        
        }
    }catch (Exception e ){
        JOptionPane.showMessageDialog(null, e);
    } 
}

    private void adicionar(){
    String sql = "insert into cliente(cpf, nome, endereco, telefone, cnh) values(?,?,?,?,?)";
    try {
        pst=conexao.prepareStatement(sql);
        pst.setString(1, TxtCliCpf.getText());
        pst.setString(2, TxtCliNom.getText());
        pst.setString(3, TxtCliEnd.getText());
        pst.setString(4, TxtCliTel.getText());
        pst.setString(5, TxtCliCnh.getText());
        // validação dos campos obrigatórios
        if ((((TxtCliCpf.getText().isEmpty()) || (TxtCliNom.getText().isEmpty())) || 
        (TxtCliEnd.getText().isEmpty())) || (TxtCliTel.getText().isEmpty()) || (TxtCliCnh.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {
        
        // a linha abaixo atualiza com os dados do formulario
        int adicionado = pst.executeUpdate();
        if(adicionado >0);{
        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
            TxtCliCpf.setText(null);
            TxtCliNom.setText(null);
            TxtCliEnd.setText(null);
            TxtCliTel.setText(null);
            TxtCliCnh.setText(null);
    }
        }    
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null,e);
    }
}
    
    
    private void editar(){
    String sql="update cliente set nome=?, endereco=?, telefone=?, cnh=? where cpf=?";
    try{
        pst=conexao.prepareStatement(sql);
        pst.setString(1, TxtCliNom.getText());
        pst.setString(2, TxtCliEnd.getText());
        pst.setString(3, TxtCliTel.getText());
        pst.setString(4, TxtCliCnh.getText());
        pst.setString(5, TxtCliCpf.getText());
       
        
        if ((((TxtCliNom.getText().isEmpty())) || 
        (TxtCliEnd.getText().isEmpty())) || (TxtCliTel.getText().isEmpty()) || (TxtCliCnh.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else{
            int adicionado = pst.executeUpdate();
            
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do Usuário alterados com sucesso");
                TxtCliCpf.setText(null);
                TxtCliNom.setText(null);
                TxtCliEnd.setText(null);
                TxtCliTel.setText(null);
                TxtCliCnh.setText(null);
                
            }
        }
        }catch(Exception e) {
        JOptionPane.showMessageDialog(null,e);
    
    }
}
  
    
    private void remover () {
    int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cliente?", "Atenção", JOptionPane.YES_NO_OPTION);
    if (confirma == JOptionPane.YES_OPTION) {
        String sql = "delete from cliente where cpf=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TxtCliCpf.getText());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
            
            TxtCliCpf.setText(null);
            TxtCliNom.setText(null);
            TxtCliEnd.setText(null);
            TxtCliTel.setText(null);
            TxtCliCnh.setText(null);
            
            }           
        }catch (Exception e) {
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
        TxtCliNom = new javax.swing.JTextField();
        TxtCliEnd = new javax.swing.JTextField();
        TxtCliTel = new javax.swing.JTextField();
        TxtCliCnh = new javax.swing.JTextField();
        BtnCliExc = new javax.swing.JButton();
        BtnCliEdi = new javax.swing.JButton();
        BtnCliIns = new javax.swing.JButton();
        BtnCliPes = new javax.swing.JButton();
        TxtCliCpf = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cliente");
        setPreferredSize(new java.awt.Dimension(671, 557));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CPF:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Endereço:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Telefone:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("CNH:");

        BtnCliExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/excluir.png"))); // NOI18N
        BtnCliExc.setToolTipText("Excluir");
        BtnCliExc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCliExc.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnCliExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCliExcActionPerformed(evt);
            }
        });

        BtnCliEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/editar.png"))); // NOI18N
        BtnCliEdi.setToolTipText("Editar");
        BtnCliEdi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCliEdi.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnCliEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCliEdiActionPerformed(evt);
            }
        });

        BtnCliIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/adicionarnovo.png"))); // NOI18N
        BtnCliIns.setToolTipText("Inserir");
        BtnCliIns.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCliIns.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnCliIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCliInsActionPerformed(evt);
            }
        });

        BtnCliPes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/pesquisar.png"))); // NOI18N
        BtnCliPes.setToolTipText("Pesquisar");
        BtnCliPes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCliPes.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnCliPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCliPesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 534, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(BtnCliIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TxtCliTel, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                        .addComponent(TxtCliCnh))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(BtnCliPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addComponent(BtnCliEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(BtnCliExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TxtCliNom, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtCliEnd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                                    .addComponent(TxtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtCliNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtCliEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(TxtCliTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtCliCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnCliExc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCliEdi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCliPes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCliIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCliInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCliInsActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_BtnCliInsActionPerformed

    private void BtnCliPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCliPesActionPerformed
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_BtnCliPesActionPerformed

    private void BtnCliEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCliEdiActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_BtnCliEdiActionPerformed

    private void BtnCliExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCliExcActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_BtnCliExcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCliEdi;
    private javax.swing.JButton BtnCliExc;
    private javax.swing.JButton BtnCliIns;
    private javax.swing.JButton BtnCliPes;
    private javax.swing.JTextField TxtCliCnh;
    private javax.swing.JFormattedTextField TxtCliCpf;
    private javax.swing.JTextField TxtCliEnd;
    private javax.swing.JTextField TxtCliNom;
    private javax.swing.JTextField TxtCliTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
